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

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_bilans")
public class Bilans implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Mesec")
    private Integer mesec;
    
    @Column(name = "Godina")
    private Integer godina;    
    
    @Column(name = "PlaniranaProizvodnja")
    private Double planiranaProizvodnja;        
    
    @Column(name = "OstvarenaProizvodnja")
    private Double ostvarenaProizvodnja;            
    
    @Column(name = "PlaniranUvoz")
    private Double planiraniUvoz;
    
    @Column(name = "PlaniranIzvoz")
    private Double planiraniIzvoz;    
    
    @ManyToOne
    @JoinColumn(name = "Elektrana_fk")
    private Elektrana elektrana;    

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

    public Double getPlaniranaProizvodnja() {
        return planiranaProizvodnja;
    }

    public void setPlaniranaProizvodnja(Double planiranaProizvodnja) {
        this.planiranaProizvodnja = planiranaProizvodnja;
    }

    public Double getOstvarenaProizvodnja() {
        return ostvarenaProizvodnja;
    }

    public void setOstvarenaProizvodnja(Double ostvarenaProizvodnja) {
        this.ostvarenaProizvodnja = ostvarenaProizvodnja;
    }

    public Double getPlaniraniUvoz() {
        return planiraniUvoz;
    }

    public void setPlaniraniUvoz(Double planiraniUvoz) {
        this.planiraniUvoz = planiraniUvoz;
    }

    public Double getPlaniraniIzvoz() {
        return planiraniIzvoz;
    }

    public void setPlaniraniIzvoz(Double planiraniIzvoz) {
        this.planiraniIzvoz = planiraniIzvoz;
    }

    public Elektrana getElektrana() {
        return elektrana;
    }

    public void setElektrana(Elektrana elektrana) {
        this.elektrana = elektrana;
    }
    
    
    
}
