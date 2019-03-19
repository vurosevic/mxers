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
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_drzava")
public class Drzava implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @Column(name = "Oznaka")
    @Size(max = 2)
    private String oznaka;     
    
    @Column(name = "Naziv_drzave")
    @Size(max = 255)
    private String nazivDrzave;

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
     * @return the oznaka
     */
    public String getOznaka() {
        return oznaka;
    }

    /**
     * @param oznaka the oznaka to set
     */
    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    /**
     * @return the nazivDrzave
     */
    public String getNazivDrzave() {
        return nazivDrzave;
    }

    /**
     * @param nazivDrzave the nazivDrzave to set
     */
    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }
    
}
