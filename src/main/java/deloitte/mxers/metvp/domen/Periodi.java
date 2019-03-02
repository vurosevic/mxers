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
@Table(name = "mhers_periodi")
public class Periodi implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;    
    
    @Column(name = "Sifra_perioda")
    private String sifraPerioda;

    @Column(name = "Mesec")
    private Integer mesec;    

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
     * @return the sifraPerioda
     */
    public String getSifraPerioda() {
        return sifraPerioda;
    }

    /**
     * @param sifraPerioda the sifraPerioda to set
     */
    public void setSifraPerioda(String sifraPerioda) {
        this.sifraPerioda = sifraPerioda;
    }

    /**
     * @return the mesec
     */
    public Integer getMesec() {
        return mesec;
    }

    /**
     * @param mesec the mesec to set
     */
    public void setMesec(Integer mesec) {
        this.mesec = mesec;
    }
    
    
}
