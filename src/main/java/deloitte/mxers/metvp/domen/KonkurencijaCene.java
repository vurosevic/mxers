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
@Table(name = "mhers_konkurencija_cene")
public class KonkurencijaCene implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Konkurencija_fk")
    private Konkurencija konkurencija;
    
    @Column(name = "Period")
    @Size(max = 20)
    private String period;    
    
    @Column(name = "Godina_perioda")
    @Size(max = 10)
    private String godinaPerioda;    
    
    @Column(name = "Cena")
    private Double cena;

    @Column(name = "Naziv_kupca")
    @Size(max = 255)
    private String nazivKupca;

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
     * @return the konkurencija
     */
    public Konkurencija getKonkurencija() {
        return konkurencija;
    }

    /**
     * @param konkurencija the konkurencija to set
     */
    public void setKonkurencija(Konkurencija konkurencija) {
        this.konkurencija = konkurencija;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * @return the godinaPerioda
     */
    public String getGodinaPerioda() {
        return godinaPerioda;
    }

    /**
     * @param godinaPerioda the godinaPerioda to set
     */
    public void setGodinaPerioda(String godinaPerioda) {
        this.godinaPerioda = godinaPerioda;
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
     * @return the nazivKupca
     */
    public String getNazivKupca() {
        return nazivKupca;
    }

    /**
     * @param nazivKupca the nazivKupca to set
     */
    public void setNazivKupca(String nazivKupca) {
        this.nazivKupca = nazivKupca;
    }
    
    
}
