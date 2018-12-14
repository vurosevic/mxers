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
@Table(name = "mhers_elektrane")
public class Elektrana implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;
    
    @Column(name = "Naziv")
    @Size(max = 15)
    private String naziv;

    @ManyToOne
    @JoinColumn(name = "Vrsta_fk")
    private VrstaElektrane vrstaElektrane;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public VrstaElektrane getVrstaElektrane() {
        return vrstaElektrane;
    }

    public void setVrstaElektrane(VrstaElektrane vrstaElektrane) {
        this.vrstaElektrane = vrstaElektrane;
    }
 
    
}
