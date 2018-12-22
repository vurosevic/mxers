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
}
