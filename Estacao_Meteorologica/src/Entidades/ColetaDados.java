/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a1552287
 */
@Entity
@Table(name = "coleta_dados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColetaDados.findAll", query = "SELECT c FROM ColetaDados c")
    , @NamedQuery(name = "ColetaDados.findByIdColetaDados", query = "SELECT c FROM ColetaDados c WHERE c.idColetaDados = :idColetaDados")
    , @NamedQuery(name = "ColetaDados.findByDadoColeta", query = "SELECT c FROM ColetaDados c WHERE c.dadoColeta = :dadoColeta")})
public class ColetaDados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_coleta_dados")
    private Integer idColetaDados;
    @Basic(optional = false)
    @Column(name = "dado_coleta")
    private String dadoColeta;
    @JoinColumn(name = "sensor_id_sensor", referencedColumnName = "id_sensor")
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Sensor sensorIdSensor;

    public ColetaDados() {
    }

    public ColetaDados(Integer idColetaDados) {
        this.idColetaDados = idColetaDados;
    }

    public ColetaDados(Integer idColetaDados, String dadoColeta) {
        this.idColetaDados = idColetaDados;
        this.dadoColeta = dadoColeta;
    }

    public Integer getIdColetaDados() {
        return idColetaDados;
    }

    public void setIdColetaDados(Integer idColetaDados) {
        this.idColetaDados = idColetaDados;
    }

    public String getDadoColeta() {
        return dadoColeta;
    }

    public void setDadoColeta(String dadoColeta) {
        this.dadoColeta = dadoColeta;
    }

    public Sensor getSensorIdSensor() {
        return sensorIdSensor;
    }

    public void setSensorIdSensor(Sensor sensorIdSensor) {
        this.sensorIdSensor = sensorIdSensor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColetaDados != null ? idColetaDados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColetaDados)) {
            return false;
        }
        ColetaDados other = (ColetaDados) object;
        if ((this.idColetaDados == null && other.idColetaDados != null) || (this.idColetaDados != null && !this.idColetaDados.equals(other.idColetaDados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ColetaDados[ idColetaDados=" + idColetaDados + " ]";
    }

}
