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
    private Float kupovina;        
    
    @Column(name = "VrednostKupovine")
    private Float vrednostKupovine;

    @Column(name = "Prodaja")
    private Float prodaja;        
    
    @Column(name = "VrednostProdaje")
    private Float vrednostProdaje;    
    
}
