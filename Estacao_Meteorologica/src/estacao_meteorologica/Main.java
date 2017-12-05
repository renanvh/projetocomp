/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacao_meteorologica;

import Entidades.*;
import DAO.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author a1552287
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static DAOSensor daoSensor = new DAOSensor();
    static DAOTipoSensor daoTipoSensor = new DAOTipoSensor();
    static DAOColetaDados daoColetor = new DAOColetaDados();
    static int controllerBD = 1;

    public static void main(String[] args) throws IOException {

        //Inicializando conexão com o arduino
        Socket s = new Socket("172.16.1.100", 80);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        try {
            //Criando e inserindo os tipos de sensores
            TipoSensor sensorTemp = new TipoSensor(1, "Sensor de temperatura LM35", 0, 1000);
            TipoSensor sensorLum = new TipoSensor(2, "P7 - Sensor de Luminosidade", 0, 1000);

            daoTipoSensor.inserir(sensorTemp);
            daoTipoSensor.inserir(sensorLum);

            /*-------------------------------------------------*/
            //Criando e inserindo os sensores
            Sensor temperatura = new Sensor(1, "LM35", "Celsius", "medir a temperatura do ambiente", true);
            temperatura.setTipoSensorIdTipoSensor(daoTipoSensor.obter(1));
            Sensor luminosidade = new Sensor(2, "P7 - Sensor de Luminosidade", "Lumens", "medir a luminosidade do ambiente", true);
            luminosidade.setTipoSensorIdTipoSensor(daoTipoSensor.obter(2));

            daoSensor.inserir(temperatura);
            daoSensor.inserir(luminosidade);

        } catch (Exception ex) {
            System.out.println("Data Already Persisted");
        }
        /*-------------------------------------------------*/

        //Mensagem para iniciar o envio de mensagens
        String a = "oi";

        out.writeUTF(a);

        System.out.println("Inicializando a leitura");
        byte[] buffer = new byte[255];

        while (true) {

            int retorno = in.read(buffer);

            String x = new String(buffer);
            String splitter[] = x.split("-");
            String valorTemp = splitter[0];
            String valorLumi = splitter[1];

            System.out.println("valor temp: " + valorTemp);
            System.out.println("valor lumi: " + valorLumi);
            System.out.println("valor controler: " + controllerBD);
            ColetaDados coletaTemp = new ColetaDados(controllerBD);
            coletaTemp.setSensorIdSensor(daoSensor.obter(1));
            System.out.println("size: "+valorTemp.length());
            coletaTemp.setDadoColeta(new String(valorTemp));
            
            //inserindo no banco
            daoColetor.inserir(coletaTemp);
            controllerBD++;

            ColetaDados coletaLumi = new ColetaDados(controllerBD);
            coletaLumi.setSensorIdSensor(daoSensor.obter(2));
            coletaLumi.setDadoColeta(new String(valorLumi));
            
            //inserindo no banco
            daoColetor.inserir(coletaLumi);
            controllerBD++;
        }
    }
}
