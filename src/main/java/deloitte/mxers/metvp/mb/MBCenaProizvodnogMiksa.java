/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.service.BilansService;
import deloitte.mxers.metvp.service.DebalansService;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBCenaProizvodnogMiksa")
@SessionScoped
public class MBCenaProizvodnogMiksa {
    
    @Autowired      
    private BilansService bilansService;

    @Autowired      
    private DebalansService debalansService;  
    
    private Integer godinaOd;
    
    private Integer godinaDo;
    
    private Double procenatTroskovaErs;
    
    private Double ukupniTroskoviBalansiranja;

    public BilansService getBilansService() {
        return bilansService;
    }

    public void setBilansService(BilansService bilansService) {
        this.bilansService = bilansService;
    }

    public DebalansService getDebalansService() {
        return debalansService;
    }

    public void setDebalansService(DebalansService debalansService) {
        this.debalansService = debalansService;
    }

    public Integer getGodinaOd() {
        return godinaOd;
    }

    public void setGodinaOd(Integer godinaOd) {
        this.godinaOd = godinaOd;
    }

    public Integer getGodinaDo() {
        return godinaDo;
    }

    public void setGodinaDo(Integer godinaDo) {
        this.godinaDo = godinaDo;
    }

    public Double getProcenatTroskovaErs() {
        return procenatTroskovaErs;
    }

    public void setProcenatTroskovaErs(Double procenatTroskovaErs) {
        this.procenatTroskovaErs = procenatTroskovaErs;
    }
    
    public Double racunajUkupneTroskoveBalansiranja(){
        Double result = new Double(0);
        Double pom = new Double(0);
        
        for (int i=godinaOd; i<=godinaDo; i++){
            result += debalansService.ukupniTroskoviDebalansaPoGodini(i);            
            pom += bilansService.ukupnoOstvarenoPoGodini(i);
        }
        
        ukupniTroskoviBalansiranja = result / pom;        
        return ukupniTroskoviBalansiranja;
    }

    public Double getUkupniTroskoviBalansiranja() {
        return ukupniTroskoviBalansiranja;
    }

    public void setUkupniTroskoviBalansiranja(Double ukupniTroskoviBalansiranja) {
        this.ukupniTroskoviBalansiranja = ukupniTroskoviBalansiranja;
    }
    
}
