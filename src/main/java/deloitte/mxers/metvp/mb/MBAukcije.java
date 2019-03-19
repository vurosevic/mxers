/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Aukcija;
import deloitte.mxers.metvp.lazyViews.LazyDataModelAukcija;
import deloitte.mxers.metvp.service.AukcijaService;
import deloitte.mxers.metvp.service.DrzavaService;
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
@Component("MBAukcije")
@SessionScoped
public class MBAukcije {
    
    @Autowired
    private AukcijaService aukcijaService;
    
    private Long selectDrzavaOdId;   
    private Long selectDrzavaDoId;
    
    private Long novaDrzavaOdId;   
    private Long novaDrzavaDoId;    
    
    @Autowired  
    private DrzavaService drzavaService;
    private List<Aukcija> lista;    
    private Aukcija selectAukcija;
    private Aukcija novaAukcija;    
    
    private LazyDataModel<Aukcija> lazyModel;     
    
    @PostConstruct
    public void init(){     
         setLista(getAukcijaService().findAll());         
         setLazyModel(new LazyDataModelAukcija(getAukcijaService().findAll())); 
         setNovaAukcija(new Aukcija());
         setSelectAukcija(null);
         selectDrzavaOdId = null;
         selectDrzavaDoId = null;
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
     * @return the selectDrzavaOdId
     */
    public Long getSelectDrzavaOdId() {
        return selectDrzavaOdId;
    }

    /**
     * @param selectDrzavaOdId the selectDrzavaOdId to set
     */
    public void setSelectDrzavaOdId(Long selectDrzavaOdId) {
        this.selectDrzavaOdId = selectDrzavaOdId;
    }

    /**
     * @return the selectDrzavaDoId
     */
    public Long getSelectDrzavaDoId() {
        return selectDrzavaDoId;
    }

    /**
     * @param selectDrzavaDoId the selectDrzavaDoId to set
     */
    public void setSelectDrzavaDoId(Long selectDrzavaDoId) {
        this.selectDrzavaDoId = selectDrzavaDoId;
    }

    /**
     * @return the drzavaService
     */
    public DrzavaService getDrzavaService() {
        return drzavaService;
    }

    /**
     * @param drzavaService the drzavaService to set
     */
    public void setDrzavaService(DrzavaService drzavaService) {
        this.drzavaService = drzavaService;
    }

    /**
     * @return the lista
     */
    public List<Aukcija> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Aukcija> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectAukcija
     */
    public Aukcija getSelectAukcija() {
        return selectAukcija;
    }

    /**
     * @param selectAukcija the selectAukcija to set
     */
    public void setSelectAukcija(Aukcija selectAukcija) {
        this.selectAukcija = selectAukcija;
    }

    /**
     * @return the novaAukcija
     */
    public Aukcija getNovaAukcija() {
        return novaAukcija;
    }

    /**
     * @param novaAukcija the novaAukcija to set
     */
    public void setNovaAukcija(Aukcija novaAukcija) {
        this.novaAukcija = novaAukcija;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<Aukcija> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<Aukcija> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuAukciju(){
        novaAukcija.setDrzavaOd(getDrzavaService().findById(getNovaDrzavaOdId()).get());  
        novaAukcija.setDrzavaDo(getDrzavaService().findById(getNovaDrzavaDoId()).get());  
        aukcijaService.save(novaAukcija);
        init();
        novaDrzavaOdId = null;
        novaDrzavaDoId = null;
    }
    
    public void azurirajAukciju() {
        if (getSelectDrzavaOdId() != null)
        selectAukcija.setDrzavaOd(getDrzavaService().findById(getSelectDrzavaOdId()).get());  
        selectAukcija.setDrzavaDo(getDrzavaService().findById(getSelectDrzavaDoId()).get()); 
        aukcijaService.save(selectAukcija);
        
    }
    
    public void brisiAukciju() {        
        aukcijaService.delete(selectAukcija);
        init();
    }     

    /**
     * @return the novaDrzavaOdId
     */
    public Long getNovaDrzavaOdId() {
        return novaDrzavaOdId;
    }

    /**
     * @param novaDrzavaOdId the novaDrzavaOdId to set
     */
    public void setNovaDrzavaOdId(Long novaDrzavaOdId) {
        this.novaDrzavaOdId = novaDrzavaOdId;
    }

    /**
     * @return the novaDrzavaDoId
     */
    public Long getNovaDrzavaDoId() {
        return novaDrzavaDoId;
    }

    /**
     * @param novaDrzavaDoId the novaDrzavaDoId to set
     */
    public void setNovaDrzavaDoId(Long novaDrzavaDoId) {
        this.novaDrzavaDoId = novaDrzavaDoId;
    }
    
}
