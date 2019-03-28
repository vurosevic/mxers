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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "mhers_satna_opterecenja")
public class SatnaOpterecenja implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id; 
    
    @Column(name = "Datum")
    private Date datum;

    @Column(name = "Op_00")
    private Double op00;    
    
    @Column(name = "Op_01")
    private Double op01;
    
    @Column(name = "Op_02")
    private Double op02;    
    
    @Column(name = "Op_03")
    private Double op03;

    @Column(name = "Op_04")
    private Double op04;    

    @Column(name = "Op_05")
    private Double op05;

    @Column(name = "Op_06")
    private Double op06;

    @Column(name = "Op_07")
    private Double op07;

    @Column(name = "Op_08")
    private Double op08;

    @Column(name = "Op_09")
    private Double op09;

    @Column(name = "Op_10")
    private Double op10;    

    @Column(name = "Op_11")
    private Double op11;
    
    @Column(name = "Op_12")
    private Double op12;

    @Column(name = "Op_13")
    private Double op13;

    @Column(name = "Op_14")
    private Double op14;

    @Column(name = "Op_15")
    private Double op15;   
    
    @Column(name = "Op_16")
    private Double op16;

    @Column(name = "Op_17")
    private Double op17;   
    
    @Column(name = "Op_18")
    private Double op18;

    @Column(name = "Op_19")
    private Double op19;    
    
    @Column(name = "Op_20")
    private Double op20;

    @Column(name = "Op_21")
    private Double op21;

    @Column(name = "Op_22")
    private Double op22;

    @Column(name = "Op_23")
    private Double op23;    
    
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
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the op01
     */
    public Double getOp01() {
        return op01;
    }

    /**
     * @param op01 the op01 to set
     */
    public void setOp01(Double op01) {
        this.op01 = op01;
    }

    /**
     * @return the op02
     */
    public Double getOp02() {
        return op02;
    }

    /**
     * @param op02 the op02 to set
     */
    public void setOp02(Double op02) {
        this.op02 = op02;
    }

    /**
     * @return the op03
     */
    public Double getOp03() {
        return op03;
    }

    /**
     * @param op03 the op03 to set
     */
    public void setOp03(Double op03) {
        this.op03 = op03;
    }

    /**
     * @return the op04
     */
    public Double getOp04() {
        return op04;
    }

    /**
     * @param op04 the op04 to set
     */
    public void setOp04(Double op04) {
        this.op04 = op04;
    }

    /**
     * @return the op05
     */
    public Double getOp05() {
        return op05;
    }

    /**
     * @param op05 the op05 to set
     */
    public void setOp05(Double op05) {
        this.op05 = op05;
    }

    /**
     * @return the op06
     */
    public Double getOp06() {
        return op06;
    }

    /**
     * @param op06 the op06 to set
     */
    public void setOp06(Double op06) {
        this.op06 = op06;
    }

    /**
     * @return the op07
     */
    public Double getOp07() {
        return op07;
    }

    /**
     * @param op07 the op07 to set
     */
    public void setOp07(Double op07) {
        this.op07 = op07;
    }

    /**
     * @return the op08
     */
    public Double getOp08() {
        return op08;
    }

    /**
     * @param op08 the op08 to set
     */
    public void setOp08(Double op08) {
        this.op08 = op08;
    }

    /**
     * @return the op09
     */
    public Double getOp09() {
        return op09;
    }

    /**
     * @param op09 the op09 to set
     */
    public void setOp09(Double op09) {
        this.op09 = op09;
    }

    /**
     * @return the op10
     */
    public Double getOp10() {
        return op10;
    }

    /**
     * @param op10 the op10 to set
     */
    public void setOp10(Double op10) {
        this.op10 = op10;
    }

    /**
     * @return the op11
     */
    public Double getOp11() {
        return op11;
    }

    /**
     * @param op11 the op11 to set
     */
    public void setOp11(Double op11) {
        this.op11 = op11;
    }

    /**
     * @return the op12
     */
    public Double getOp12() {
        return op12;
    }

    /**
     * @param op12 the op12 to set
     */
    public void setOp12(Double op12) {
        this.op12 = op12;
    }

    /**
     * @return the op13
     */
    public Double getOp13() {
        return op13;
    }

    /**
     * @param op13 the op13 to set
     */
    public void setOp13(Double op13) {
        this.op13 = op13;
    }

    /**
     * @return the op14
     */
    public Double getOp14() {
        return op14;
    }

    /**
     * @param op14 the op14 to set
     */
    public void setOp14(Double op14) {
        this.op14 = op14;
    }

    /**
     * @return the op15
     */
    public Double getOp15() {
        return op15;
    }

    /**
     * @param op15 the op15 to set
     */
    public void setOp15(Double op15) {
        this.op15 = op15;
    }

    /**
     * @return the op16
     */
    public Double getOp16() {
        return op16;
    }

    /**
     * @param op16 the op16 to set
     */
    public void setOp16(Double op16) {
        this.op16 = op16;
    }

    /**
     * @return the op17
     */
    public Double getOp17() {
        return op17;
    }

    /**
     * @param op17 the op17 to set
     */
    public void setOp17(Double op17) {
        this.op17 = op17;
    }

    /**
     * @return the op18
     */
    public Double getOp18() {
        return op18;
    }

    /**
     * @param op18 the op18 to set
     */
    public void setOp18(Double op18) {
        this.op18 = op18;
    }

    /**
     * @return the op19
     */
    public Double getOp19() {
        return op19;
    }

    /**
     * @param op19 the op19 to set
     */
    public void setOp19(Double op19) {
        this.op19 = op19;
    }

    /**
     * @return the op20
     */
    public Double getOp20() {
        return op20;
    }

    /**
     * @param op20 the op20 to set
     */
    public void setOp20(Double op20) {
        this.op20 = op20;
    }

    /**
     * @return the op21
     */
    public Double getOp21() {
        return op21;
    }

    /**
     * @param op21 the op21 to set
     */
    public void setOp21(Double op21) {
        this.op21 = op21;
    }

    /**
     * @return the op22
     */
    public Double getOp22() {
        return op22;
    }

    /**
     * @param op22 the op22 to set
     */
    public void setOp22(Double op22) {
        this.op22 = op22;
    }

    /**
     * @return the op23
     */
    public Double getOp23() {
        return op23;
    }

    /**
     * @param op23 the op23 to set
     */
    public void setOp23(Double op23) {
        this.op23 = op23;
    }

    /**
     * @return the op00
     */
    public Double getOp00() {
        return op00;
    }

    /**
     * @param op00 the op00 to set
     */
    public void setOp00(Double op00) {
        this.op00 = op00;
    }
    
}
