/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Bilans;
import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.domen.Debalans;
import deloitte.mxers.metvp.domen.KonkurencijaCene;
import deloitte.mxers.metvp.domen.KursnaLista;
import deloitte.mxers.metvp.domen.Periodi;
import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
import deloitte.mxers.metvp.service.BerzaPodaciService;
import deloitte.mxers.metvp.service.BilansService;
import deloitte.mxers.metvp.service.CenePragaService;
import deloitte.mxers.metvp.service.DebalansService;
import deloitte.mxers.metvp.service.KonkurencijaCeneService;
import deloitte.mxers.metvp.service.KursnaListaService;
import deloitte.mxers.metvp.service.PeriodiService;
import deloitte.mxers.metvp.service.TrosakPrekogranicnihKapacitetaService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.apache.commons.lang.time.DateUtils;
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
    
    @Autowired
    private MBVpFinalSetJc mBVpFinalSetJc;
    
    @Autowired
    private KonkurencijaCeneService konkurencijaCeneService;
    
    @Autowired
    KursnaListaService kursnaListaService;
    
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
    
    // za racunanje svih perioda odjednom
    private Double nUkupniTroskoviBalansiranja[] = new Double[5];
    private Double nProsecnaCena[] = new Double[5];
    private Double nTroskoviPgk[] = new Double[5];
    private Double nCvpmin[] = new Double[5];
    
    private Double jedinstveneVpCene[] = new Double[5];

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
    
    public void racunajSve(){
        
      for (int sp=0; sp<sifrePerioda.size(); sp++){
          // prolazi sve sifre perioda
          String trenutniPeriod = sifrePerioda.get(sp);
          
          //// racunaj troskove balansiranja          
            Double result = new Double(0);
            Double pom = new Double(0);
            List<Periodi> listaMeseca = periodiService.findBySifra(trenutniPeriod);

            for (int i=godinaOd; i<=godinaDo; i++){            
                for (Debalans d : debalansService.listaMesecnihDebalansaPoGodini(i))    {
                    for (Periodi p : listaMeseca) {
                        if (d.getMesec() == p.getMesec()){
                            result += d.getVisakCena() + Math.abs(d.getVisakNcCena() + d.getVisakCena() + d.getManjakCena());                        
                        }
                    }
                }

                for (Bilans b : bilansService.listaMesecnihOstvarenjaUGodini(i)){
                    for (Periodi p : listaMeseca) {
                        if (b.getMesec() == p.getMesec()){                    
                            pom += b.getOstvarenaProizvodnja();
                        }
                    }            
                }                        
            }

            getnUkupniTroskoviBalansiranja()[sp] = result / pom;                       
          //// end troskova balansiranja
          
          //// racunaj prosecnu cenu          
            List<Bilans> bilansLista = bilansService.findByPeriod(godinaOd, godinaDo);
            SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");        
            dateformat.setTimeZone(TimeZone.getTimeZone("CET"));                  
            Double ukupnaOstvarenaEnergija = 0.0;        
            prosecnaCena = 0.0;

            for (Bilans bi : bilansLista) {      
                for (Periodi p : listaMeseca) {
                   if (bi.getMesec() == p.getMesec()){  
                        Date datum2 = new Date();                
                        try {
                            datum2 = dateformat.parse("01." + bi.getMesec() + "." + bi.getGodina());
                        } catch (ParseException ex) {                    
                        }            

                        List<CenaPraga> cp = cenePragaService.findByDate(datum2, bi.getElektrana().getId());                                            
                        prosecnaCena = prosecnaCena + bi.getOstvarenaProizvodnja()*cp.get(0).getCena();
                        ukupnaOstvarenaEnergija = ukupnaOstvarenaEnergija + bi.getOstvarenaProizvodnja();
                    }
                }
            }        
            getnProsecnaCena()[sp] = prosecnaCena/ukupnaOstvarenaEnergija;                    
          //// end prosecna cena
          
          //// racunaj troskove PGK

            result = new Double(0);
            pom = new Double(0);

            for (int i=godinaOd; i<=godinaDo; i++){                     

                for (TrosakPrekogranicnihKapaciteta t : trosakPrekogranicnihKapacitetaService.listaTroskovaPoGodini(i)){
                    for (Periodi p : listaMeseca) {
                        if (t.getMesec() == p.getMesec()){
                            result += t.getTrosak();
                        }
                    }
                }

                for (Bilans b : bilansService.listaMesecnihOstvarenjaUGodini(i)){
                    for (Periodi p : listaMeseca) {
                        if (b.getMesec() == p.getMesec()){                    
                            pom += b.getOstvarenaProizvodnja();
                        }
                    }            
                }                                                
            }        

            getnTroskoviPgk()[sp] = result / pom;          
          
          //// end troskovi PGK
          
          //// racunaj cVpMin          
            Double rezultat = 0.0;
            // CpMin
            rezultat = getnUkupniTroskoviBalansiranja()[sp] + getnProsecnaCena()[sp] + getnTroskoviPgk()[sp];
            // ostali troskovi ERS-a
            rezultat /= (100-procenatTroskovaErs)/100;
            // zeljena EBIT
            rezultat /= (100-ebit)/100;
            // procenjena inflacija se izbacuje
            // rezultat /= (100-procenjenaInflacija)/100;        
            getnCvpmin()[sp] = rezultat;           
          //// end cVpMin
      }
        
    }
    
    public void racunaj(){
        racunajUkupneTroskoveBalansiranja();
        racunajProsecnuCenu();
        racunajTroskovePGK();
        racunajCvpMin();
        izvorSvihJc();
    }
    
    public Double racunajUkupneTroskoveBalansiranja(){
        Double result = new Double(0);
        Double pom = new Double(0);
        List<Periodi> listaMeseca = periodiService.findBySifra(izabraniTip);
        
        for (int i=godinaOd; i<=godinaDo; i++){            
            for (Debalans d : debalansService.listaMesecnihDebalansaPoGodini(i))    {
                for (Periodi p : listaMeseca) {
                    if (d.getMesec() == p.getMesec()){
                        result += d.getVisakCena() + Math.abs(d.getVisakNcCena() + d.getVisakCena() + d.getManjakCena());                        
                    }
                }
            }
            
            for (Bilans b : bilansService.listaMesecnihOstvarenjaUGodini(i)){
                for (Periodi p : listaMeseca) {
                    if (b.getMesec() == p.getMesec()){                    
                        pom += b.getOstvarenaProizvodnja();
                    }
                }            
            }                        
        }
        
        System.out.println("Debelans ukupni: " + result);
        System.out.println("Ostvareno ukupno: " + pom); 
        
        ukupniTroskoviBalansiranja = result / pom;        
        return ukupniTroskoviBalansiranja;
    }
    
    public Double racunajTroskovePGK(){
        Double result = new Double(0);
        Double pom = new Double(0);
        List<Periodi> listaMeseca = periodiService.findBySifra(izabraniTip);
        
        for (int i=godinaOd; i<=godinaDo; i++){                     
            
            for (TrosakPrekogranicnihKapaciteta t : trosakPrekogranicnihKapacitetaService.listaTroskovaPoGodini(i)){
                for (Periodi p : listaMeseca) {
                    if (t.getMesec() == p.getMesec()){
                        result += t.getTrosak();
                    }
                }
            }
            
            for (Bilans b : bilansService.listaMesecnihOstvarenjaUGodini(i)){
                for (Periodi p : listaMeseca) {
                    if (b.getMesec() == p.getMesec()){                    
                        pom += b.getOstvarenaProizvodnja();
                    }
                }            
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
        List<Periodi> listaMeseca = periodiService.findBySifra(izabraniTip);
        
        for (Bilans bi : bilansLista) {      
            for (Periodi p : listaMeseca) {
               if (bi.getMesec() == p.getMesec()){  
                    Date datum2 = new Date();                
                    try {
                        datum2 = dateformat.parse("01." + bi.getMesec() + "." + bi.getGodina());
                    } catch (ParseException ex) {                    
                    }            

                    List<CenaPraga> cp = cenePragaService.findByDate(datum2, bi.getElektrana().getId());                                            
                    prosecnaCena = prosecnaCena + bi.getOstvarenaProizvodnja()*cp.get(0).getCena();
                    ukupnaOstvarenaEnergija = ukupnaOstvarenaEnergija + bi.getOstvarenaProizvodnja();
                }
            }
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

    /**
     * @return the mBVpFinalSetJc
     */
    public MBVpFinalSetJc getmBVpFinalSetJc() {
        return mBVpFinalSetJc;
    }

    /**
     * @param mBVpFinalSetJc the mBVpFinalSetJc to set
     */
    public void setmBVpFinalSetJc(MBVpFinalSetJc mBVpFinalSetJc) {
        this.mBVpFinalSetJc = mBVpFinalSetJc;
    }

    /**
     * @return the nUkupniTroskoviBalansiranja
     */
    public Double[] getnUkupniTroskoviBalansiranja() {
        return nUkupniTroskoviBalansiranja;
    }

    /**
     * @param nUkupniTroskoviBalansiranja the nUkupniTroskoviBalansiranja to set
     */
    public void setnUkupniTroskoviBalansiranja(Double[] nUkupniTroskoviBalansiranja) {
        this.nUkupniTroskoviBalansiranja = nUkupniTroskoviBalansiranja;
    }

    /**
     * @return the nProsecnaCena
     */
    public Double[] getnProsecnaCena() {
        return nProsecnaCena;
    }

    /**
     * @param nProsecnaCena the nProsecnaCena to set
     */
    public void setnProsecnaCena(Double[] nProsecnaCena) {
        this.nProsecnaCena = nProsecnaCena;
    }

    /**
     * @return the nTroskoviPgk
     */
    public Double[] getnTroskoviPgk() {
        return nTroskoviPgk;
    }

    /**
     * @param nTroskoviPgk the nTroskoviPgk to set
     */
    public void setnTroskoviPgk(Double[] nTroskoviPgk) {
        this.nTroskoviPgk = nTroskoviPgk;
    }

    /**
     * @return the nCvpmin
     */
    public Double[] getnCvpmin() {
        return nCvpmin;
    }

    /**
     * @param nCvpmin the nCvpmin to set
     */
    public void setnCvpmin(Double[] nCvpmin) {
        this.nCvpmin = nCvpmin;
    }
    
    public void izvorSvihJc(){
        String per;
        String god;
        Double cVpMax = 0.0;
        int index = 0;
        for (int i=0; i<5; i++){
            
            if (i<4) {
                per = mBVpFinalSetJc.getFinalSetJcData(i).getPeriod();
                god = mBVpFinalSetJc.getFinalSetJcData(i).getGodinaPerioda();
                cVpMax = mBVpFinalSetJc.getFinalSetJcData(i).getCenaJc();
            } else {
                per = mBVpFinalSetJc.getFinalSetGodinaJcData(0).getPeriod();
                god = mBVpFinalSetJc.getFinalSetGodinaJcData(0).getGodinaPerioda(); 
                cVpMax = mBVpFinalSetJc.getFinalSetGodinaJcData(0).getCenaJc();
            }      
            
            if (per.equals("Q1")) index = 0;
            else if (per.equals("Q2")) index = 1;
            else if (per.equals("Q3")) index = 2;
            else if (per.equals("Q4")) index = 3;
            else if (per.equals("YR")) index = 4;
                        
            DecimalFormat newFormat = new DecimalFormat("#.##");            
            jedinstveneVpCene[i] = Double.valueOf(newFormat.format(izborJedinstveneCene(nCvpmin[index], cVpMax, per, god)));
        }
    }
    
    private Double izborJedinstveneCene(Double cVpMinKM, Double cVpMax, String period, String godinaPerioda){
        Double rezultat = 0.0;
        //Calendar cal = Calendar.getInstance(); // locale-specific
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);        
        
        if (Double.isNaN(cVpMinKM)) return Double.NaN;
        if (Double.isNaN(cVpMax)) return Double.NaN;
        
        Double cVpsMin = konkurencijaCeneService.minCenaByProizvod(period, godinaPerioda);
        //Double kurs =  kursnaListaService.kursNaDan(cal.getTime());
        if (kursnaListaService.kursPoslednji().isEmpty()) return rezultat;
        Double kurs =  kursnaListaService.kursPoslednji().get(0).getKurs();

        if (kurs == null) return Double.NaN;
        Double cVpMin = cVpMinKM/kurs;
        
        if (cVpMin < cVpMax){
            // cVpMin < cVpMax
            
            // nema podataka od konkurencije
            if (cVpsMin == null) {
                if (0.95*cVpMax < cVpMin) return cVpMin;
                else return 0.95*cVpMax;                
            } 
            
            if (cVpMax < cVpsMin) {
                if (0.95*cVpMax < cVpMin) return cVpMin;
                else return 0.95*cVpMax;
            } else {
                // cVpMax > cVpsMin
                if (0.95*cVpsMin < cVpMin) return rezultat; // odluka rukovodstva
                else return 0.95*cVpsMin;
            }
        } else {
            // cVpMin > cVpMax
            
            // nema podataka od konkurencije
            if (cVpsMin == null) return cVpMin;
            
            if (cVpMin < cVpsMin) return cVpMin;
            else return rezultat; //odluka rukovodstva            
        }                                
    }

    /**
     * @return the jedinstveneVpCene
     */
    public Double[] getJedinstveneVpCene() {
        return jedinstveneVpCene;
    }

    /**
     * @param jedinstveneVpCene the jedinstveneVpCene to set
     */
    public void setJedinstveneVpCene(Double[] jedinstveneVpCene) {
        this.jedinstveneVpCene = jedinstveneVpCene;
    }
    
}
