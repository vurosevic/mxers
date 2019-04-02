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

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "vw_satna_potrosnja_period_norm")
public class SatnaPotrosnjaPeriodNorm implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Godina")
    private Integer godina;  
    
    @Column(name = "Sifra_perioda")
    private String sifraPerioda;  
    
    @Column(name = "OpNorm_00")
    private Double opNorm00; 
    
    @Column(name = "OpNorm_01")
    private Double opNorm01; 

    @Column(name = "OpNorm_02")
    private Double opNorm02; 

    @Column(name = "OpNorm_03")
    private Double opNorm03;
    
    @Column(name = "OpNorm_04")
    private Double opNorm04; 
    
    @Column(name = "OpNorm_05")
    private Double opNorm05; 

    @Column(name = "OpNorm_06")
    private Double opNorm06; 

    @Column(name = "OpNorm_07")
    private Double opNorm07;   
    
    @Column(name = "OpNorm_08")
    private Double opNorm08; 
    
    @Column(name = "OpNorm_09")
    private Double opNorm09; 

    @Column(name = "OpNorm_10")
    private Double opNorm10; 

    @Column(name = "OpNorm_11")
    private Double opNorm11;
    
    @Column(name = "OpNorm_12")
    private Double opNorm12; 
    
    @Column(name = "OpNorm_13")
    private Double opNorm13; 

    @Column(name = "OpNorm_14")
    private Double opNorm14; 

    @Column(name = "OpNorm_15")
    private Double opNorm15;  
    
    @Column(name = "OpNorm_16")
    private Double opNorm16; 
    
    @Column(name = "OpNorm_17")
    private Double opNorm17; 

    @Column(name = "OpNorm_18")
    private Double opNorm18; 

    @Column(name = "OpNorm_19")
    private Double opNorm19;
    
    @Column(name = "OpNorm_20")
    private Double opNorm20; 
    
    @Column(name = "OpNorm_21")
    private Double opNorm21; 

    @Column(name = "OpNorm_22")
    private Double opNorm22; 

    @Column(name = "OpNorm_23")
    private Double opNorm23;     

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
     * @return the godina
     */
    public Integer getGodina() {
        return godina;
    }

    /**
     * @param godina the godina to set
     */
    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    /**
     * @return the sifraPerioda
     */
    public String getSifraPerioda() {
        return sifraPerioda;
    }

    /**
     * @param sifraPerioda the sifraPerioda to set
     */
    public void setSifraPerioda(String sifraPerioda) {
        this.sifraPerioda = sifraPerioda;
    }

    /**
     * @return the opNorm00
     */
    public Double getOpNorm00() {
        return opNorm00;
    }

    /**
     * @param opNorm00 the opNorm00 to set
     */
    public void setOpNorm00(Double opNorm00) {
        this.opNorm00 = opNorm00;
    }

    /**
     * @return the opNorm01
     */
    public Double getOpNorm01() {
        return opNorm01;
    }

    /**
     * @param opNorm01 the opNorm01 to set
     */
    public void setOpNorm01(Double opNorm01) {
        this.opNorm01 = opNorm01;
    }

    /**
     * @return the opNorm02
     */
    public Double getOpNorm02() {
        return opNorm02;
    }

    /**
     * @param opNorm02 the opNorm02 to set
     */
    public void setOpNorm02(Double opNorm02) {
        this.opNorm02 = opNorm02;
    }

    /**
     * @return the opNorm03
     */
    public Double getOpNorm03() {
        return opNorm03;
    }

    /**
     * @param opNorm03 the opNorm03 to set
     */
    public void setOpNorm03(Double opNorm03) {
        this.opNorm03 = opNorm03;
    }

    /**
     * @return the opNorm04
     */
    public Double getOpNorm04() {
        return opNorm04;
    }

    /**
     * @param opNorm04 the opNorm04 to set
     */
    public void setOpNorm04(Double opNorm04) {
        this.opNorm04 = opNorm04;
    }

    /**
     * @return the opNorm05
     */
    public Double getOpNorm05() {
        return opNorm05;
    }

    /**
     * @param opNorm05 the opNorm05 to set
     */
    public void setOpNorm05(Double opNorm05) {
        this.opNorm05 = opNorm05;
    }

    /**
     * @return the opNorm06
     */
    public Double getOpNorm06() {
        return opNorm06;
    }

    /**
     * @param opNorm06 the opNorm06 to set
     */
    public void setOpNorm06(Double opNorm06) {
        this.opNorm06 = opNorm06;
    }

    /**
     * @return the opNorm07
     */
    public Double getOpNorm07() {
        return opNorm07;
    }

    /**
     * @param opNorm07 the opNorm07 to set
     */
    public void setOpNorm07(Double opNorm07) {
        this.opNorm07 = opNorm07;
    }

    /**
     * @return the opNorm08
     */
    public Double getOpNorm08() {
        return opNorm08;
    }

    /**
     * @param opNorm08 the opNorm08 to set
     */
    public void setOpNorm08(Double opNorm08) {
        this.opNorm08 = opNorm08;
    }

    /**
     * @return the opNorm09
     */
    public Double getOpNorm09() {
        return opNorm09;
    }

    /**
     * @param opNorm09 the opNorm09 to set
     */
    public void setOpNorm09(Double opNorm09) {
        this.opNorm09 = opNorm09;
    }

    /**
     * @return the opNorm10
     */
    public Double getOpNorm10() {
        return opNorm10;
    }

    /**
     * @param opNorm10 the opNorm10 to set
     */
    public void setOpNorm10(Double opNorm10) {
        this.opNorm10 = opNorm10;
    }

    /**
     * @return the opNorm11
     */
    public Double getOpNorm11() {
        return opNorm11;
    }

    /**
     * @param opNorm11 the opNorm11 to set
     */
    public void setOpNorm11(Double opNorm11) {
        this.opNorm11 = opNorm11;
    }

    /**
     * @return the opNorm12
     */
    public Double getOpNorm12() {
        return opNorm12;
    }

    /**
     * @param opNorm12 the opNorm12 to set
     */
    public void setOpNorm12(Double opNorm12) {
        this.opNorm12 = opNorm12;
    }

    /**
     * @return the opNorm13
     */
    public Double getOpNorm13() {
        return opNorm13;
    }

    /**
     * @param opNorm13 the opNorm13 to set
     */
    public void setOpNorm13(Double opNorm13) {
        this.opNorm13 = opNorm13;
    }

    /**
     * @return the opNorm14
     */
    public Double getOpNorm14() {
        return opNorm14;
    }

    /**
     * @param opNorm14 the opNorm14 to set
     */
    public void setOpNorm14(Double opNorm14) {
        this.opNorm14 = opNorm14;
    }

    /**
     * @return the opNorm15
     */
    public Double getOpNorm15() {
        return opNorm15;
    }

    /**
     * @param opNorm15 the opNorm15 to set
     */
    public void setOpNorm15(Double opNorm15) {
        this.opNorm15 = opNorm15;
    }

    /**
     * @return the opNorm16
     */
    public Double getOpNorm16() {
        return opNorm16;
    }

    /**
     * @param opNorm16 the opNorm16 to set
     */
    public void setOpNorm16(Double opNorm16) {
        this.opNorm16 = opNorm16;
    }

    /**
     * @return the opNorm17
     */
    public Double getOpNorm17() {
        return opNorm17;
    }

    /**
     * @param opNorm17 the opNorm17 to set
     */
    public void setOpNorm17(Double opNorm17) {
        this.opNorm17 = opNorm17;
    }

    /**
     * @return the opNorm18
     */
    public Double getOpNorm18() {
        return opNorm18;
    }

    /**
     * @param opNorm18 the opNorm18 to set
     */
    public void setOpNorm18(Double opNorm18) {
        this.opNorm18 = opNorm18;
    }

    /**
     * @return the opNorm19
     */
    public Double getOpNorm19() {
        return opNorm19;
    }

    /**
     * @param opNorm19 the opNorm19 to set
     */
    public void setOpNorm19(Double opNorm19) {
        this.opNorm19 = opNorm19;
    }

    /**
     * @return the opNorm20
     */
    public Double getOpNorm20() {
        return opNorm20;
    }

    /**
     * @param opNorm20 the opNorm20 to set
     */
    public void setOpNorm20(Double opNorm20) {
        this.opNorm20 = opNorm20;
    }

    /**
     * @return the opNorm21
     */
    public Double getOpNorm21() {
        return opNorm21;
    }

    /**
     * @param opNorm21 the opNorm21 to set
     */
    public void setOpNorm21(Double opNorm21) {
        this.opNorm21 = opNorm21;
    }

    /**
     * @return the opNorm22
     */
    public Double getOpNorm22() {
        return opNorm22;
    }

    /**
     * @param opNorm22 the opNorm22 to set
     */
    public void setOpNorm22(Double opNorm22) {
        this.opNorm22 = opNorm22;
    }

    /**
     * @return the opNorm23
     */
    public Double getOpNorm23() {
        return opNorm23;
    }

    /**
     * @param opNorm23 the opNorm23 to set
     */
    public void setOpNorm23(Double opNorm23) {
        this.opNorm23 = opNorm23;
    }
    
    
}
