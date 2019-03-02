/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Bilans;
import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.service.BilansService;
import deloitte.mxers.metvp.service.CenePragaService;
import deloitte.mxers.metvp.service.DebalansService;
import deloitte.mxers.metvp.service.PeriodiService;
import deloitte.mxers.metvp.service.TrosakPrekogranicnihKapacitetaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
    
    @Autowired
    private CenePragaService cenePragaService;
    
    @Autowired
    private TrosakPrekogranicnihKapacitetaService trosakPrekogranicnihKapacitetaService;
    
    @Autowired
    private PeriodiService periodiService;
    
    private String izabraniTip;
    
    private List<String> sifrePerioda;
    
    private Integer godinaOd;
    
    private Integer godinaDo;
    
    private Double procenatTroskovaErs;
    
    private Double ukupniTroskoviBalansiranja;
    
    private Double troskoviPgk;
    
    private Double ebit;
    
    private Double procenjenaInflacija;
    
    private Double prosecnaCena;
    
    private Double cvpmin;

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
    
    @PostConstruct    
    public void init(){     
         setSifrePerioda(periodiService.findAllSifra());                  
    }      
    
    public void racunaj(){
        racunajUkupneTroskoveBalansiranja();
        racunajProsecnuCenu();
        racunajTroskovePGK();
        racunajCvpMin();
    }
    
    public Double racunajUkupneTroskoveBalansiranja(){
        Double result = new Double(0);
        Double pom = new Double(0);
        
        for (int i=godinaOd; i<=godinaDo; i++){
            try {
            result += debalansService.ukupniTroskoviDebalansaPoGodini(i);            
            } catch (Exception ex ){
                System.out.println("Troskovi za godinu " + i + " su 0.");
            }
            try {
            pom += bilansService.ukupnoOstvarenoPoGodini(i);
            } catch (Exception ex){
                System.out.println("Ostvareno el. en.  za godinu " + i + " je 0.");
            }
            
        }
        
        ukupniTroskoviBalansiranja = result / pom;        
        return ukupniTroskoviBalansiranja;
    }
    
    public Double racunajTroskovePGK(){
        Double result = new Double(0);
        Double pom = new Double(0);

        for (int i=godinaOd; i<=godinaDo; i++){                     
            try {
            result += trosakPrekogranicnihKapacitetaService.ukupanTrosakPoGodini(i);   
            } catch (Exception ex ){
                System.out.println("Troskovi za godinu " + i + " su 0.");
            }
            try {
            pom += bilansService.ukupnoOstvarenoPoGodini(i);
            } catch (Exception ex){
                System.out.println("Ostvareno el. en.  za godinu " + i + " je 0.");
            }            
            
        }        
        
        troskoviPgk = result / pom;
        return troskoviPgk;
    }
    
    public Double racunajProsecnuCenu(){
        
        List<Bilans> bilansLista = bilansService.findByPeriod(godinaOd, godinaDo);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");        
        dateformat.setTimeZone(TimeZone.getTimeZone("CET"));                  
        Double ukupnaOstvarenaEnergija = 0.0;        
        prosecnaCena = 0.0;
        
        for (Bilans bi : bilansLista) {            
                Date datum2 = new Date();                
                try {
                    datum2 = dateformat.parse("01." + bi.getMesec() + "." + bi.getGodina());
                } catch (ParseException ex) {                    
                }            
            
                List<CenaPraga> cp = cenePragaService.findByDate(datum2, bi.getElektrana().getId());                                            
                prosecnaCena = prosecnaCena + bi.getOstvarenaProizvodnja()*cp.get(0).getCena();
                ukupnaOstvarenaEnergija = ukupnaOstvarenaEnergija + bi.getOstvarenaProizvodnja();                
        }        
        
        prosecnaCena = prosecnaCena/ukupnaOstvarenaEnergija;
        return prosecnaCena;        
    }    
    
    public Double racunajCvpMin(){
        Double rezultat = 0.0;
        // CpMin
        rezultat = ukupniTroskoviBalansiranja + prosecnaCena + troskoviPgk;
        // ostali troskovi ERS-a
        rezultat /= (100-procenatTroskovaErs)/100;
        // zeljena EBIT
        rezultat /= (100-ebit)/100;
        // procenjena inflacija 
        rezultat /= (100-procenjenaInflacija)/100;        
        cvpmin = rezultat;        
        return cvpmin;
    }

    public Double getUkupniTroskoviBalansiranja() {
        return ukupniTroskoviBalansiranja;
    }

    public void setUkupniTroskoviBalansiranja(Double ukupniTroskoviBalansiranja) {
        this.ukupniTroskoviBalansiranja = ukupniTroskoviBalansiranja;
    }

    public CenePragaService getCenePragaService() {
        return cenePragaService;
    }

    public void setCenePragaService(CenePragaService cenePragaService) {
        this.cenePragaService = cenePragaService;
    }

    public Double getProsecnaCena() {
        return prosecnaCena;
    }

    public void setProsecnaCena(Double prosecnaCena) {
        this.prosecnaCena = prosecnaCena;
    }

    public Double getTroskoviPgk() {
        return troskoviPgk;
    }

    public void setTroskoviPgk(Double troskoviPgk) {
        this.troskoviPgk = troskoviPgk;
    }

    public Double getEbit() {
        return ebit;
    }

    public void setEbit(Double ebit) {
        this.ebit = ebit;
    }

    public Double getProcenjenaInflacija() {
        return procenjenaInflacija;
    }

    public void setProcenjenaInflacija(Double procenjenaInflacija) {
        this.procenjenaInflacija = procenjenaInflacija;
    }

    public Double getCvpmin() {
        return cvpmin;
    }

    public void setCvpmin(Double cvpmin) {
        this.cvpmin = cvpmin;
    }
    

    /**
     * @return the izabraniTip
     */
    public String getIzabraniTip() {
        return izabraniTip;
    }

    /**
     * @param izabraniTip the izabraniTip to set
     */
    public void setIzabraniTip(String izabraniTip) {
        this.izabraniTip = izabraniTip;
    }

    /**
     * @return the sifrePerioda
     */
    public List<String> getSifrePerioda() {
        return sifrePerioda;
    }

    /**
     * @param sifrePerioda the sifrePerioda to set
     */
    public void setSifrePerioda(List<String> sifrePerioda) {
        this.sifrePerioda = sifrePerioda;
    }
    
}
