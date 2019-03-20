/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Aukcija;
import deloitte.mxers.metvp.domen.AukcijaCena;
import deloitte.mxers.metvp.domen.Smer;
import deloitte.mxers.metvp.lazyViews.LazyDataModelAukcijaCena;
import deloitte.mxers.metvp.service.AukcijaCenaService;
import deloitte.mxers.metvp.service.AukcijaService;
import deloitte.mxers.metvp.service.SmerService;
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
@Component("MBAukcijaCene")
@SessionScoped
public class MBAukcijaCene {
    
    @Autowired
    private AukcijaCenaService aukcijaCenaService;
    
    private Long selectSmerId;   
    private Long selectAukcijaId;
    
    private Long novaSmerId;   
    private Long novaAukcijaId;    
    
    @Autowired  
    private AukcijaService aukcijaService;
 
    @Autowired  
    private SmerService smerService;
    
    private List<AukcijaCena> lista; 
    private List<Smer> listaSmer;
    private AukcijaCena selectAukcijaCena;
    private AukcijaCena novaAukcijaCena;    
    
    private LazyDataModel<AukcijaCena> lazyModel;      

    /**
     * @return the aukcijaCenaService
     */
    public AukcijaCenaService getAukcijaCenaService() {
        return aukcijaCenaService;
    }

    @PostConstruct
    public void init(){     
         //setLista(getAukcijaCenaService().findAll());  
         setListaSmer(getSmerService().findAll()); 
         //setLazyModel(new LazyDataModelAukcijaCena(getAukcijaCenaService().findAll())); 
         setNovaAukcijaCena(new AukcijaCena());
         setSelectAukcijaCena(null);
         selectSmerId = null;
         //selectAukcijaId = null;
         refresh();
    }    
    
    /**
     * @param aukcijaCenaService the aukcijaCenaService to set
     */
    public void setAukcijaCenaService(AukcijaCenaService aukcijaCenaService) {
        this.aukcijaCenaService = aukcijaCenaService;
    }

    /**
     * @return the selectSmerId
     */
    public Long getSelectSmerId() {
        return selectSmerId;
    }

    /**
     * @param selectSmerId the selectSmerId to set
     */
    public void setSelectSmerId(Long selectSmerId) {
        this.selectSmerId = selectSmerId;
    }

    /**
     * @return the selectAukcijaId
     */
    public Long getSelectAukcijaId() {
        return selectAukcijaId;
    }

    /**
     * @param selectAukcijaId the selectAukcijaId to set
     */
    public void setSelectAukcijaId(Long selectAukcijaId) {
        this.selectAukcijaId = selectAukcijaId;
    }

    /**
     * @return the novaSmerId
     */
    public Long getNovaSmerId() {
        return novaSmerId;
    }

    /**
     * @param novaSmerId the novaSmerId to set
     */
    public void setNovaSmerId(Long novaSmerId) {
        this.novaSmerId = novaSmerId;
    }

    /**
     * @return the novaAukcijaId
     */
    public Long getNovaAukcijaId() {
        return novaAukcijaId;
    }

    /**
     * @param novaAukcijaId the novaAukcijaId to set
     */
    public void setNovaAukcijaId(Long novaAukcijaId) {
        this.novaAukcijaId = novaAukcijaId;
    }

    /**
     * @return the aukcijaService
     */
    public AukcijaService getAukcijaService() {
        return aukcijaService;
    }

    /**
     * @param aukcijaService the aukcijaService to set
     */
    public void setAukcijaService(AukcijaService aukcijaService) {
        this.aukcijaService = aukcijaService;
    }

    /**
     * @return the smerService
     */
    public SmerService getSmerService() {
        return smerService;
    }

    /**
     * @param smerService the smerService to set
     */
    public void setSmerService(SmerService smerService) {
        this.smerService = smerService;
    }

    /**
     * @return the lista
     */
    public List<AukcijaCena> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<AukcijaCena> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectAukcijaCena
     */
    public AukcijaCena getSelectAukcijaCena() {
        return selectAukcijaCena;
    }

    /**
     * @param selectAukcijaCena the selectAukcijaCena to set
     */
    public void setSelectAukcijaCena(AukcijaCena selectAukcijaCena) {
        this.selectAukcijaCena = selectAukcijaCena;
    }

    /**
     * @return the novaAukcijaCena
     */
    public AukcijaCena getNovaAukcijaCena() {
        return novaAukcijaCena;
    }

    /**
     * @param novaAukcijaCena the novaAukcijaCena to set
     */
    public void setNovaAukcijaCena(AukcijaCena novaAukcijaCena) {
        this.novaAukcijaCena = novaAukcijaCena;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<AukcijaCena> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<AukcijaCena> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    
    public void dodajNovuAukcijuCenu(){
        novaAukcijaCena.setSmer(getSmerService().findById(getNovaSmerId()).get());
        novaAukcijaCena.setAukcija(getAukcijaService().findById(getSelectAukcijaId()).get()); // dodaje se selektovana aukcija 
        aukcijaCenaService.save(novaAukcijaCena);
        init();
        novaSmerId = null;
        novaAukcijaId = null;
    }
    
    public void azurirajAukcijuCenu() {
        if (getSelectSmerId() != null)
        selectAukcijaCena.setSmer(getSmerService().findById(getSelectSmerId()).get());  
        
        if (getSelectAukcijaId() != null)
        selectAukcijaCena.setAukcija(getAukcijaService().findById(getSelectAukcijaId()).get());          
        
        aukcijaCenaService.save(selectAukcijaCena);         
    }
    
    public void brisiAukcijuCenu() {        
        aukcijaCenaService.delete(selectAukcijaCena);
        init();
    }    
    
    public void refresh(){
         setLista(aukcijaCenaService.listaCenaPoAukciji(getSelectAukcijaId()));
         setLazyModel(new LazyDataModelAukcijaCena(aukcijaCenaService.listaCenaPoAukciji(getSelectAukcijaId())));         
         selectAukcijaCena = null;
    }
    
    public Aukcija getParentAukcija(){
        if (getSelectAukcijaId() != null)
            return getAukcijaService().findById(getSelectAukcijaId()).get();
        else return null;
    }

    /**
     * @return the listaSmer
     */
    public List<Smer> getListaSmer() {
        return listaSmer;
    }

    /**
     * @param listaSmer the listaSmer to set
     */
    public void setListaSmer(List<Smer> listaSmer) {
        this.listaSmer = listaSmer;
    }
    
}
