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
    private Double visakEnergija;        

    @Column(name = "VisakCena")
    private Double visakCena;    

    @Column(name = "VisakNCEnergija")
    private Double visakNcEnergija;        

    @Column(name = "VisakNCCena")
    private Double visakNcCena;        
    
    @Column(name = "ManjakEnergija")
    private Double manjakEnergija;        

    @Column(name = "ManjakCena")
    private Double manjakCena;      

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

    public Double getVisakEnergija() {
        return visakEnergija;
    }

    public void setVisakEnergija(Double visakEnergija) {
        this.visakEnergija = visakEnergija;
    }

    public Double getVisakCena() {
        return visakCena;
    }

    public void setVisakCena(Double visakCena) {
        this.visakCena = visakCena;
    }

    public Double getVisakNcEnergija() {
        return visakNcEnergija;
    }

    public void setVisakNcEnergija(Double visakNcEnergija) {
        this.visakNcEnergija = visakNcEnergija;
    }

    public Double getVisakNcCena() {
        return visakNcCena;
    }

    public void setVisakNcCena(Double visakNcCena) {
        this.visakNcCena = visakNcCena;
    }

    public Double getManjakEnergija() {
        return manjakEnergija;
    }

    public void setManjakEnergija(Double manjakEnergija) {
        this.manjakEnergija = manjakEnergija;
    }

    public Double getManjakCena() {
        return manjakCena;
    }

    public void setManjakCena(Double manjakCena) {
        this.manjakCena = manjakCena;
    }

    
}
