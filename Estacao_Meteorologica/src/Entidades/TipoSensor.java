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
@Table(name = "tipo_sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSensor.findAll", query = "SELECT t FROM TipoSensor t")
    , @NamedQuery(name = "TipoSensor.findByIdTipoSensor", query = "SELECT t FROM TipoSensor t WHERE t.idTipoSensor = :idTipoSensor")
    , @NamedQuery(name = "TipoSensor.findByTipoSenso", query = "SELECT t FROM TipoSensor t WHERE t.tipoSenso = :tipoSenso")
    , @NamedQuery(name = "TipoSensor.findByRangeMinSensor", query = "SELECT t FROM TipoSensor t WHERE t.rangeMinSensor = :rangeMinSensor")
    , @NamedQuery(name = "TipoSensor.findByRangeMaxSensor", query = "SELECT t FROM TipoSensor t WHERE t.rangeMaxSensor = :rangeMaxSensor")})
public class TipoSensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_sensor")
    private Integer idTipoSensor;
    @Basic(optional = false)
    @Column(name = "tipo_senso")
    private String tipoSenso;
    @Basic(optional = false)
    @Column(name = "range_min_sensor")
    private int rangeMinSensor;
    @Basic(optional = false)
    @Column(name = "range_max_sensor")
    private int rangeMaxSensor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSensorIdTipoSensor")
    private List<Sensor> sensorList;

    public TipoSensor() {
    }

    public TipoSensor(Integer idTipoSensor) {
        this.idTipoSensor = idTipoSensor;
    }

    public TipoSensor(Integer idTipoSensor, String tipoSenso, int rangeMinSensor, int rangeMaxSensor) {
        this.idTipoSensor = idTipoSensor;
        this.tipoSenso = tipoSenso;
        this.rangeMinSensor = rangeMinSensor;
        this.rangeMaxSensor = rangeMaxSensor;
    }

    public Integer getIdTipoSensor() {
        return idTipoSensor;
    }

    public void setIdTipoSensor(Integer idTipoSensor) {
        this.idTipoSensor = idTipoSensor;
    }

    public String getTipoSenso() {
        return tipoSenso;
    }

    public void setTipoSenso(String tipoSenso) {
        this.tipoSenso = tipoSenso;
    }

    public int getRangeMinSensor() {
        return rangeMinSensor;
    }

    public void setRangeMinSensor(int rangeMinSensor) {
        this.rangeMinSensor = rangeMinSensor;
    }

    public int getRangeMaxSensor() {
        return rangeMaxSensor;
    }

    public void setRangeMaxSensor(int rangeMaxSensor) {
        this.rangeMaxSensor = rangeMaxSensor;
    }

    @XmlTransient
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSensor != null ? idTipoSensor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSensor)) {
            return false;
        }
        TipoSensor other = (TipoSensor) object;
        if ((this.idTipoSensor == null && other.idTipoSensor != null) || (this.idTipoSensor != null && !this.idTipoSensor.equals(other.idTipoSensor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoSensor[ idTipoSensor=" + idTipoSensor + " ]";
    }
    
}
