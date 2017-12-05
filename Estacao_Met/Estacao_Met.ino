//http://www.arduinoecia.com.br/2013/06/ethernet-shield-wiznet-w5100-parte-1.html
//https://www.arduino.cc/en/Reference/Ethernet

#include <SPI.h>
#include <Ethernet.h>

// the media access control (ethernet hardware) address for the shield:
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };  
//the IP address for the shield:
byte ip[] = { 172, 16, 1, 100 };    
// the router's gateway address:
byte gateway[] = {172, 16, 1, 65 };
// the subnet:
byte subnet[] = { 255, 255, 255, 0 };

//char buffer[1024];

EthernetServer server = EthernetServer(80);

const int analogPin_temp = 0;
const int analogPin_lumi = 1;

const int minTempSensor = 0;
const int maxTempSensor = 600;

const int minLumiSensor = 0;
const int maxLumiSensor = 1010;

float valorTemp;
int valorLumi;

void setup() {
  // Open serial communications and wait for port to open:
  Serial.begin(9600);
  
  // initialize the ethernet device
  Ethernet.begin(mac, ip, gateway, subnet);

  // start listening for clients
  server.begin();
}

void loop() {
  
  EthernetClient client = server.available();
  if (client){
    while (client.connected()){
      if (client.available()){
        valorTemp = analogRead(analogPin_temp);
        valorLumi = analogRead(analogPin_lumi);
        Serial.print(valorTemp);
        Serial.print("-");
        Serial.println(valorLumi);
        
        String teste = String(valorTemp) + String("-") +String(valorLumi);
        char enviar[255];
        teste.toCharArray(enviar,255);
        client.write(enviar);
        
        client.flush();
        delay(10000);
      }  
    }
    delay(1);
    client.stop();
  }
}
