/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a1552287
 */
@Entity
@Table(name = "sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s")
    , @NamedQuery(name = "Sensor.findByIdSensor", query = "SELECT s FROM Sensor s WHERE s.idSensor = :idSensor")
    , @NamedQuery(name = "Sensor.findByNomeSensor", query = "SELECT s FROM Sensor s WHERE s.nomeSensor = :nomeSensor")
    , @NamedQuery(name = "Sensor.findByUnidadeMedidaSensor", query = "SELECT s FROM Sensor s WHERE s.unidadeMedidaSensor = :unidadeMedidaSensor")
    , @NamedQuery(name = "Sensor.findByFinalidadeSensor", query = "SELECT s FROM Sensor s WHERE s.finalidadeSensor = :finalidadeSensor")
    , @NamedQuery(name = "Sensor.findByStatusSensor", query = "SELECT s FROM Sensor s WHERE s.statusSensor = :statusSensor")})
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sensor")
    private Integer idSensor;
    @Basic(optional = false)
    @Column(name = "nome_sensor")
    private String nomeSensor;
    @Basic(optional = false)
    @Column(name = "unidade_medida_sensor")
    private String unidadeMedidaSensor;
    @Basic(optional = false)
    @Column(name = "finalidade_sensor")
    private String finalidadeSensor;
    @Basic(optional = false)
    @Column(name = "status_sensor")
    private boolean statusSensor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorIdSensor")
    private List<ColetaDados> coletaDadosList;
    @JoinColumn(name = "tipo_sensor_id_tipo_sensor", referencedColumnName = "id_tipo_sensor")
    @ManyToOne(optional = false)
    private TipoSensor tipoSensorIdTipoSensor;

    public Sensor() {
    }

    public Sensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public Sensor(Integer idSensor, String nomeSensor, String unidadeMedidaSensor, String finalidadeSensor, boolean statusSensor) {
        this.idSensor = idSensor;
        this.nomeSensor = nomeSensor;
        this.unidadeMedidaSensor = unidadeMedidaSensor;
        this.finalidadeSensor = finalidadeSensor;
        this.statusSensor = statusSensor;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public String getNomeSensor() {
        return nomeSensor;
    }

    public void setNomeSensor(String nomeSensor) {
        this.nomeSensor = nomeSensor;
    }

    public String getUnidadeMedidaSensor() {
        return unidadeMedidaSensor;
    }

    public void setUnidadeMedidaSensor(String unidadeMedidaSensor) {
        this.unidadeMedidaSensor = unidadeMedidaSensor;
    }

    public String getFinalidadeSensor() {
        return finalidadeSensor;
    }

    public void setFinalidadeSensor(String finalidadeSensor) {
        this.finalidadeSensor = finalidadeSensor;
    }

    public boolean getStatusSensor() {
        return statusSensor;
    }

    public void setStatusSensor(boolean statusSensor) {
        this.statusSensor = statusSensor;
    }

    @XmlTransient
    public List<ColetaDados> getColetaDadosList() {
        return coletaDadosList;
    }

    public void setColetaDadosList(List<ColetaDados> coletaDadosList) {
        this.coletaDadosList = coletaDadosList;
    }

    public TipoSensor getTipoSensorIdTipoSensor() {
        return tipoSensorIdTipoSensor;
    }

    public void setTipoSensorIdTipoSensor(TipoSensor tipoSensorIdTipoSensor) {
        this.tipoSensorIdTipoSensor = tipoSensorIdTipoSensor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensor != null ? idSensor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.idSensor == null && other.idSensor != null) || (this.idSensor != null && !this.idSensor.equals(other.idSensor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sensor[ idSensor=" + idSensor + " ]";
    }
    
}
