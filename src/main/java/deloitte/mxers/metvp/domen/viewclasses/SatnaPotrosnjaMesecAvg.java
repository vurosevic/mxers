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
@Table(name = "vw_satna_potrosnja_mesec_avg")
public class SatnaPotrosnjaMesecAvg implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;

    @Column(name = "Godina")
    private Integer godina;  
    
    @Column(name = "Mesec")
    private Integer mesec;  
    
    @Column(name = "Kvartal")
    private String kvartal;
    
    @Column(name = "OpAvg_00")
    private Integer opAvg00; 
    
    @Column(name = "OpAvg_01")
    private Integer opAvg01; 

    @Column(name = "OpAvg_02")
    private Integer opAvg02; 

    @Column(name = "OpAvg_03")
    private Integer opAvg03;
    
    @Column(name = "OpAvg_04")
    private Integer opAvg04; 
    
    @Column(name = "OpAvg_05")
    private Integer opAvg05; 

    @Column(name = "OpAvg_06")
    private Integer opAvg06; 

    @Column(name = "OpAvg_07")
    private Integer opAvg07;   
    
    @Column(name = "OpAvg_08")
    private Integer opAvg08; 
    
    @Column(name = "OpAvg_09")
    private Integer opAvg09; 

    @Column(name = "OpAvg_10")
    private Integer opAvg10; 

    @Column(name = "OpAvg_11")
    private Integer opAvg11;
    
    @Column(name = "OpAvg_12")
    private Integer opAvg12; 
    
    @Column(name = "OpAvg_13")
    private Integer opAvg13; 

    @Column(name = "OpAvg_14")
    private Integer opAvg14; 

    @Column(name = "OpAvg_15")
    private Integer opAvg15;  
    
    @Column(name = "OpAvg_16")
    private Integer opAvg16; 
    
    @Column(name = "OpAvg_17")
    private Integer opAvg17; 

    @Column(name = "OpAvg_18")
    private Integer opAvg18; 

    @Column(name = "OpAvg_19")
    private Integer opAvg19;
    
    @Column(name = "OpAvg_20")
    private Integer opAvg20; 
    
    @Column(name = "OpAvg_21")
    private Integer opAvg21; 

    @Column(name = "OpAvg_22")
    private Integer opAvg22; 

    @Column(name = "OpAvg_23")
    private Integer opAvg23;    

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
     * @return the opAvg00
     */
    public Integer getOpAvg00() {
        return opAvg00;
    }

    /**
     * @param opAvg00 the opAvg00 to set
     */
    public void setOpAvg00(Integer opAvg00) {
        this.opAvg00 = opAvg00;
    }

    /**
     * @return the opAvg01
     */
    public Integer getOpAvg01() {
        return opAvg01;
    }

    /**
     * @param opAvg01 the opAvg01 to set
     */
    public void setOpAvg01(Integer opAvg01) {
        this.opAvg01 = opAvg01;
    }

    /**
     * @return the opAvg02
     */
    public Integer getOpAvg02() {
        return opAvg02;
    }

    /**
     * @param opAvg02 the opAvg02 to set
     */
    public void setOpAvg02(Integer opAvg02) {
        this.opAvg02 = opAvg02;
    }

    /**
     * @return the opAvg03
     */
    public Integer getOpAvg03() {
        return opAvg03;
    }

    /**
     * @param opAvg03 the opAvg03 to set
     */
    public void setOpAvg03(Integer opAvg03) {
        this.opAvg03 = opAvg03;
    }

    /**
     * @return the opAvg04
     */
    public Integer getOpAvg04() {
        return opAvg04;
    }

    /**
     * @param opAvg04 the opAvg04 to set
     */
    public void setOpAvg04(Integer opAvg04) {
        this.opAvg04 = opAvg04;
    }

    /**
     * @return the opAvg05
     */
    public Integer getOpAvg05() {
        return opAvg05;
    }

    /**
     * @param opAvg05 the opAvg05 to set
     */
    public void setOpAvg05(Integer opAvg05) {
        this.opAvg05 = opAvg05;
    }

    /**
     * @return the opAvg06
     */
    public Integer getOpAvg06() {
        return opAvg06;
    }

    /**
     * @param opAvg06 the opAvg06 to set
     */
    public void setOpAvg06(Integer opAvg06) {
        this.opAvg06 = opAvg06;
    }

    /**
     * @return the opAvg07
     */
    public Integer getOpAvg07() {
        return opAvg07;
    }

    /**
     * @param opAvg07 the opAvg07 to set
     */
    public void setOpAvg07(Integer opAvg07) {
        this.opAvg07 = opAvg07;
    }

    /**
     * @return the opAvg08
     */
    public Integer getOpAvg08() {
        return opAvg08;
    }

    /**
     * @param opAvg08 the opAvg08 to set
     */
    public void setOpAvg08(Integer opAvg08) {
        this.opAvg08 = opAvg08;
    }

    /**
     * @return the opAvg09
     */
    public Integer getOpAvg09() {
        return opAvg09;
    }

    /**
     * @param opAvg09 the opAvg09 to set
     */
    public void setOpAvg09(Integer opAvg09) {
        this.opAvg09 = opAvg09;
    }

    /**
     * @return the opAvg10
     */
    public Integer getOpAvg10() {
        return opAvg10;
    }

    /**
     * @param opAvg10 the opAvg10 to set
     */
    public void setOpAvg10(Integer opAvg10) {
        this.opAvg10 = opAvg10;
    }

    /**
     * @return the opAvg11
     */
    public Integer getOpAvg11() {
        return opAvg11;
    }

    /**
     * @param opAvg11 the opAvg11 to set
     */
    public void setOpAvg11(Integer opAvg11) {
        this.opAvg11 = opAvg11;
    }

    /**
     * @return the opAvg12
     */
    public Integer getOpAvg12() {
        return opAvg12;
    }

    /**
     * @param opAvg12 the opAvg12 to set
     */
    public void setOpAvg12(Integer opAvg12) {
        this.opAvg12 = opAvg12;
    }

    /**
     * @return the opAvg13
     */
    public Integer getOpAvg13() {
        return opAvg13;
    }

    /**
     * @param opAvg13 the opAvg13 to set
     */
    public void setOpAvg13(Integer opAvg13) {
        this.opAvg13 = opAvg13;
    }

    /**
     * @return the opAvg14
     */
    public Integer getOpAvg14() {
        return opAvg14;
    }

    /**
     * @param opAvg14 the opAvg14 to set
     */
    public void setOpAvg14(Integer opAvg14) {
        this.opAvg14 = opAvg14;
    }

    /**
     * @return the opAvg15
     */
    public Integer getOpAvg15() {
        return opAvg15;
    }

    /**
     * @param opAvg15 the opAvg15 to set
     */
    public void setOpAvg15(Integer opAvg15) {
        this.opAvg15 = opAvg15;
    }

    /**
     * @return the opAvg16
     */
    public Integer getOpAvg16() {
        return opAvg16;
    }

    /**
     * @param opAvg16 the opAvg16 to set
     */
    public void setOpAvg16(Integer opAvg16) {
        this.opAvg16 = opAvg16;
    }

    /**
     * @return the opAvg17
     */
    public Integer getOpAvg17() {
        return opAvg17;
    }

    /**
     * @param opAvg17 the opAvg17 to set
     */
    public void setOpAvg17(Integer opAvg17) {
        this.opAvg17 = opAvg17;
    }

    /**
     * @return the opAvg18
     */
    public Integer getOpAvg18() {
        return opAvg18;
    }

    /**
     * @param opAvg18 the opAvg18 to set
     */
    public void setOpAvg18(Integer opAvg18) {
        this.opAvg18 = opAvg18;
    }

    /**
     * @return the opAvg19
     */
    public Integer getOpAvg19() {
        return opAvg19;
    }

    /**
     * @param opAvg19 the opAvg19 to set
     */
    public void setOpAvg19(Integer opAvg19) {
        this.opAvg19 = opAvg19;
    }

    /**
     * @return the opAvg20
     */
    public Integer getOpAvg20() {
        return opAvg20;
    }

    /**
     * @param opAvg20 the opAvg20 to set
     */
    public void setOpAvg20(Integer opAvg20) {
        this.opAvg20 = opAvg20;
    }

    /**
     * @return the opAvg21
     */
    public Integer getOpAvg21() {
        return opAvg21;
    }

    /**
     * @param opAvg21 the opAvg21 to set
     */
    public void setOpAvg21(Integer opAvg21) {
        this.opAvg21 = opAvg21;
    }

    /**
     * @return the opAvg22
     */
    public Integer getOpAvg22() {
        return opAvg22;
    }

    /**
     * @param opAvg22 the opAvg22 to set
     */
    public void setOpAvg22(Integer opAvg22) {
        this.opAvg22 = opAvg22;
    }

    /**
     * @return the opAvg23
     */
    public Integer getOpAvg23() {
        return opAvg23;
    }

    /**
     * @param opAvg23 the opAvg23 to set
     */
    public void setOpAvg23(Integer opAvg23) {
        this.opAvg23 = opAvg23;
    }

    /**
     * @return the mesec
     */
    public Integer getMesec() {
        return mesec;
    }

    /**
     * @param mesec the mesec to set
     */
    public void setMesec(Integer mesec) {
        this.mesec = mesec;
    }

    /**
     * @return the kvartal
     */
    public String getKvartal() {
        return kvartal;
    }

    /**
     * @param kvartal the kvartal to set
     */
    public void setKvartal(String kvartal) {
        this.kvartal = kvartal;
    }
    
}
