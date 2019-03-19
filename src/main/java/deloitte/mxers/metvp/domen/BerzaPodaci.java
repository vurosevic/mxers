/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.domen;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "mhers_berza_podaci")
public class BerzaPodaci implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;      
    
    @Column(name = "Datum")
    private Date datum;
    
    @ManyToOne
    @JoinColumn(name = "Berza_fk")
    private Berza berza;
    
    @Column(name = "Vrsta_opterecenja")
    @Size(max = 2)
    private String vrstaOpterecenja;

    @Column(name = "Period")
    @Size(max = 20)
    private String period;    
    
    @Column(name = "Godina_perioda")
    @Size(max = 10)
    private String godinaPerioda;
    
    @Column(name = "Cena")
    private Double cena;  
    
    @Column(name = "Obim_trgovanja")
    private Double obimTrgovanja;

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
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the berza
     */
    public Berza getBerza() {
        return berza;
    }

    /**
     * @param berza the berza to set
     */
    public void setBerza(Berza berza) {
        this.berza = berza;
    }

    /**
     * @return the vrstaOpterecenja
     */
    public String getVrstaOpterecenja() {
        return vrstaOpterecenja;
    }

    /**
     * @param vrstaOpterecenja the vrstaOpterecenja to set
     */
    public void setVrstaOpterecenja(String vrstaOpterecenja) {
        this.vrstaOpterecenja = vrstaOpterecenja;
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
     * @return the obimTrgovanja
     */
    public Double getObimTrgovanja() {
        return obimTrgovanja;
    }

    /**
     * @param obimTrgovanja the obimTrgovanja to set
     */
    public void setObimTrgovanja(Double obimTrgovanja) {
        this.obimTrgovanja = obimTrgovanja;
    }
    
}
