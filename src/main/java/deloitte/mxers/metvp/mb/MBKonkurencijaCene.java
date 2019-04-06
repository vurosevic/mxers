/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.KonkurencijaCene;
import deloitte.mxers.metvp.lazyViews.LazyDataModelKonkurencijaCene;
import deloitte.mxers.metvp.service.BerzaPodaciService;
import deloitte.mxers.metvp.service.KonkurencijaCeneService;
import deloitte.mxers.metvp.service.KonkurencijaService;
import deloitte.mxers.metvp.service.PeriodiService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBKonkurencijaCene")
@SessionScoped
public class MBKonkurencijaCene {
    @Autowired
    private KonkurencijaService konkurencijaService;
    
    private Long selectKonkurencijaId;   
    
    @Autowired
    private PeriodiService periodiService;

    private List<String> sifrePerioda;    
    
    @Autowired
    private BerzaPodaciService berzaPodaciService;    
    
    private List<String> godinePerioda;    
    
    @Autowired  
    private KonkurencijaCeneService konkurencijaCeneService;
    private List<KonkurencijaCene> lista;    
    private KonkurencijaCene selectKonkurencijaCene;
    private KonkurencijaCene novaKonkurencijaCene;    
    
    private LazyDataModel<KonkurencijaCene> lazyModel;      

    @PostConstruct
    public void init(){     
         setGodinePerioda(berzaPodaciService.findAllGodinePerioda());
         setSifrePerioda(periodiService.findAllSifra()); 
         setLista(getKonkurencijaCeneService().findAll());         
         setLazyModel(new LazyDataModelKonkurencijaCene(getKonkurencijaCeneService().findAll())); 
         setNovaKonkurencijaCene(new KonkurencijaCene());
         setSelectKonkurencijaCene(null); 
         selectKonkurencijaId = null;
    }      

    /**
     * @return the konkurencijaService
     */
    public KonkurencijaService getKonkurencijaService() {
        return konkurencijaService;
    }

    /**
     * @param konkurencijaService the konkurencijaService to set
     */
    public void setKonkurencijaService(KonkurencijaService konkurencijaService) {
        this.konkurencijaService = konkurencijaService;
    }

    /**
     * @return the selectKonkurencijaId
     */
    public Long getSelectKonkurencijaId() {
        return selectKonkurencijaId;
    }

    /**
     * @param selectKonkurencijaId the selectKonkurencijaId to set
     */
    public void setSelectKonkurencijaId(Long selectKonkurencijaId) {
        this.selectKonkurencijaId = selectKonkurencijaId;
    }

    /**
     * @return the konkurencijaCeneService
     */
    public KonkurencijaCeneService getKonkurencijaCeneService() {
        return konkurencijaCeneService;
    }

    /**
     * @param konkurencijaCeneService the konkurencijaCeneService to set
     */
    public void setKonkurencijaCeneService(KonkurencijaCeneService konkurencijaCeneService) {
        this.konkurencijaCeneService = konkurencijaCeneService;
    }

    /**
     * @return the lista
     */
    public List<KonkurencijaCene> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<KonkurencijaCene> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectKonkurencijaCene
     */
    public KonkurencijaCene getSelectKonkurencijaCene() {
        return selectKonkurencijaCene;
    }

    /**
     * @param selectKonkurencijaCene the selectKonkurencijaCene to set
     */
    public void setSelectKonkurencijaCene(KonkurencijaCene selectKonkurencijaCene) {
        this.selectKonkurencijaCene = selectKonkurencijaCene;
    }

    /**
     * @return the novaKonkurencijaCene
     */
    public KonkurencijaCene getNovaKonkurencijaCene() {
        return novaKonkurencijaCene;
    }

    /**
     * @param novaKonkurencijaCene the novaKonkurencijaCene to set
     */
    public void setNovaKonkurencijaCene(KonkurencijaCene novaKonkurencijaCene) {
        this.novaKonkurencijaCene = novaKonkurencijaCene;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<KonkurencijaCene> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<KonkurencijaCene> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuKonkurencijuCenu(){
        novaKonkurencijaCene.setKonkurencija(getKonkurencijaService().findById(getSelectKonkurencijaId()).get());  
        konkurencijaCeneService.save(novaKonkurencijaCene);
        init();
    }
    
    public void azurirajKonkurencijuCenu() {
        if (getSelectKonkurencijaId() != null)
        selectKonkurencijaCene.setKonkurencija(getKonkurencijaService().findById(getSelectKonkurencijaId()).get());         
        konkurencijaCeneService.save(selectKonkurencijaCene);
        selectKonkurencijaId = null;
    }
    
    public void brisiKonkurencijuCenu() {        
        konkurencijaCeneService.delete(selectKonkurencijaCene); 
        init();
    }     

    /**
     * @return the periodiService
     */
    public PeriodiService getPeriodiService() {
        return periodiService;
    }

    /**
     * @param periodiService the periodiService to set
     */
    public void setPeriodiService(PeriodiService periodiService) {
        this.periodiService = periodiService;
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
     * @return the berzaPodaciService
     */
    public BerzaPodaciService getBerzaPodaciService() {
        return berzaPodaciService;
    }

    /**
     * @param berzaPodaciService the berzaPodaciService to set
     */
    public void setBerzaPodaciService(BerzaPodaciService berzaPodaciService) {
        this.berzaPodaciService = berzaPodaciService;
    }

    /**
     * @return the godinePerioda
     */
    public List<String> getGodinePerioda() {
        return godinePerioda;
    }

    /**
     * @param godinePerioda the godinePerioda to set
     */
    public void setGodinePerioda(List<String> godinePerioda) {
        this.godinePerioda = godinePerioda;
    }
    
}
