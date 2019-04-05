/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.domen.viewclasses;

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
@Table(name = "vw_vp_final_set_jc")
public class VpFinalSetJc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @Column(name = "K_BLPL")
    private Double kBlPl;    
    
    @Column(name = "K_BL")
    private Double kBl;

    @Column(name = "K_PL")
    private Double kPl;    
    
    @Column(name = "Period")
    @Size(max = 20)
    private String period;    
    
    @Column(name = "Godina_perioda")
    @Size(max = 10)
    private String godinaPerioda;

    @Column(name = "CenaBL")
    private Double cenaBl;    
    
    @Column(name = "CenaPL")
    private Double cenaPl;

    @Column(name = "JC")
    private Double cenaJc;    

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
     * @return the kBlPl
     */
    public Double getkBlPl() {
        return kBlPl;
    }

    /**
     * @param kBlPl the kBlPl to set
     */
    public void setkBlPl(Double kBlPl) {
        this.kBlPl = kBlPl;
    }

    /**
     * @return the kBl
     */
    public Double getkBl() {
        return kBl;
    }

    /**
     * @param kBl the kBl to set
     */
    public void setkBl(Double kBl) {
        this.kBl = kBl;
    }

    /**
     * @return the kPl
     */
    public Double getkPl() {
        return kPl;
    }

    /**
     * @param kPl the kPl to set
     */
    public void setkPl(Double kPl) {
        this.kPl = kPl;
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
     * @return the cenaBl
     */
    public Double getCenaBl() {
        return cenaBl;
    }

    /**
     * @param cenaBl the cenaBl to set
     */
    public void setCenaBl(Double cenaBl) {
        this.cenaBl = cenaBl;
    }

    /**
     * @return the cenaPl
     */
    public Double getCenaPl() {
        return cenaPl;
    }

    /**
     * @param cenaPl the cenaPl to set
     */
    public void setCenaPl(Double cenaPl) {
        this.cenaPl = cenaPl;
    }

    /**
     * @return the cenaJc
     */
    public Double getCenaJc() {
        return cenaJc;
    }

    /**
     * @param cenaJc the cenaJc to set
     */
    public void setCenaJc(Double cenaJc) {
        this.cenaJc = cenaJc;
    }
    
    
}
