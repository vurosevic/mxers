/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.domen;

import javax.persistence.Basic;
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
@Table(name = "mhers_putanje_detalji")
public class PutanjaDetalj {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "Putanje_def_fk")
    private PutanjaDef putanjaDef;

    @ManyToOne
    @JoinColumn(name = "Aukcija_fk")
    private Aukcija aukcija;
}
