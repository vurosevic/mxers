/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_aukcije")
public class Aukcija implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;     
    
    @ManyToOne
    @JoinColumn(name = "Drzava_od_fk")
    private Drzava drzavaOd;
    
    @ManyToOne
    @JoinColumn(name = "Drzava_do_fk")
    private Drzava drzavaDo;   

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the drzavaOd
     */
    public Drzava getDrzavaOd() {
        return drzavaOd;
    }

    /**
     * @param drzavaOd the drzavaOd to set
     */
    public void setDrzavaOd(Drzava drzavaOd) {
        this.drzavaOd = drzavaOd;
    }

    /**
     * @return the drzavaDo
     */
    public Drzava getDrzavaDo() {
        return drzavaDo;
    }

    /**
     * @param drzavaDo the drzavaDo to set
     */
    public void setDrzavaDo(Drzava drzavaDo) {
        this.drzavaDo = drzavaDo;
    }

    @Override
    public String toString() {
        return drzavaOd.getOznaka() + " - " + drzavaDo.getOznaka();
    }
        
    
}
