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
@Table(name = "mhers_cena_praga")
public class CenaPraga implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Datum_od")
    private Date datumOd;    

    @Column(name = "Datum_do")
    private Date datumDo;    
    
    @Column(name = "Cena")
    private Double cena;
    
    @ManyToOne
    @JoinColumn(name = "Elektrana_fk")
    private Elektrana elektrana;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Elektrana getElektrana() {
        return elektrana;
    }

    public void setElektrana(Elektrana elektrana) {
        this.elektrana = elektrana;
    }
    
    
}
