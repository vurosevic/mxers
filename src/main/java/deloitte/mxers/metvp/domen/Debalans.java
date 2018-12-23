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
@Table(name = "mhers_debalans")
public class Debalans implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Mesec")
    private Integer mesec;     
    
    @Column(name = "Godina")
    private Integer godina;     

    @Column(name = "VisakEnergija")
    private Float visakEnergija;        

    @Column(name = "VisakCena")
    private Float visakCena;    

    @Column(name = "VisakNCEnergija")
    private Float visakNcEnergija;        

    @Column(name = "VisakNCCena")
    private Float visakNcCena;        
    
    @Column(name = "ManjakEnergija")
    private Float manjakEnergija;        

    @Column(name = "ManjakCena")
    private Float manjakCena;      

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

    public Float getVisakEnergija() {
        return visakEnergija;
    }

    public void setVisakEnergija(Float visakEnergija) {
        this.visakEnergija = visakEnergija;
    }

    public Float getVisakCena() {
        return visakCena;
    }

    public void setVisakCena(Float visakCena) {
        this.visakCena = visakCena;
    }

    public Float getVisakNcEnergija() {
        return visakNcEnergija;
    }

    public void setVisakNcEnergija(Float visakNcEnergija) {
        this.visakNcEnergija = visakNcEnergija;
    }

    public Float getVisakNcCena() {
        return visakNcCena;
    }

    public void setVisakNcCena(Float visakNcCena) {
        this.visakNcCena = visakNcCena;
    }

    public Float getManjakEnergija() {
        return manjakEnergija;
    }

    public void setManjakEnergija(Float manjakEnergija) {
        this.manjakEnergija = manjakEnergija;
    }

    public Float getManjakCena() {
        return manjakCena;
    }

    public void setManjakCena(Float manjakCena) {
        this.manjakCena = manjakCena;
    }

    
}
