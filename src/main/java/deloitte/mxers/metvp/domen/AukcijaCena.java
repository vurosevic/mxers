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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_aukcije_cena")
public class AukcijaCena implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;    
    
    @ManyToOne
    @JoinColumn(name = "Smer_fk")
    private Smer smer;    
    
    @Column(name = "Godina")
    private Integer godina;     
    
    @Column(name = "Cena")
    private Double cena;

    @ManyToOne
    @JoinColumn(name = "Aukcija_fk")
    private Aukcija aukcija;     

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
     * @return the smer
     */
    public Smer getSmer() {
        return smer;
    }

    /**
     * @param smer the smer to set
     */
    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    /**
     * @return the godina
     */
    public Integer getGodina() {
        return godina;
    }

    /**
     * @param godina the godina to set
     */
    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    /**
     * @return the cena
     */
    public Double getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(Double cena) {
        this.cena = cena;
    }

    /**
     * @return the aukcija
     */
    public Aukcija getAukcija() {
        return aukcija;
    }

    /**
     * @param aukcija the aukcija to set
     */
    public void setAukcija(Aukcija aukcija) {
        this.aukcija = aukcija;
    }
        
}
