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
@Table(name = "mhers_trgovina")
public class Trgovina implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;
    
    @Column(name = "Godina")
    private Integer godina;    

    @Column(name = "Kupovina")
    private Double kupovina;        
    
    @Column(name = "VrednostKupovine")
    private Double vrednostKupovine;

    @Column(name = "Prodaja")
    private Double prodaja;        
    
    @Column(name = "VrednostProdaje")
    private Double vrednostProdaje;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Double getKupovina() {
        return kupovina;
    }

    public void setKupovina(Double kupovina) {
        this.kupovina = kupovina;
    }

    public Double getVrednostKupovine() {
        return vrednostKupovine;
    }

    public void setVrednostKupovine(Double vrednostKupovine) {
        this.vrednostKupovine = vrednostKupovine;
    }

    public Double getProdaja() {
        return prodaja;
    }

    public void setProdaja(Double prodaja) {
        this.prodaja = prodaja;
    }

    public Double getVrednostProdaje() {
        return vrednostProdaje;
    }

    public void setVrednostProdaje(Double vrednostProdaje) {
        this.vrednostProdaje = vrednostProdaje;
    }
    
    
    
}
