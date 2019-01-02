/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_trosak_prekogranicnih_kapaciteta")
public class TrosakPrekogranicnihKapaciteta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Mesec")
    private Integer mesec;
    
    @Column(name = "Godina")
    private Integer godina;    
    
    @Column(name = "Trosak")
    private Double trosak;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMesec() {
        return mesec;
    }

    public void setMesec(Integer mesec) {
        this.mesec = mesec;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Double getTrosak() {
        return trosak;
    }

    public void setTrosak(Double trosak) {
        this.trosak = trosak;
    }
    
    
    
}
