/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Konkurencija;
import deloitte.mxers.metvp.lazyViews.LazyDataModelKonkurencija;
import deloitte.mxers.metvp.service.KonkurencijaService;
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
@Component("MBKonkurencija")
@SessionScoped
public class MBKonkurencija {
    @Autowired  
    private KonkurencijaService konkurencijaService;    
    private List<Konkurencija> lista;    
    private Konkurencija selectKonkurencija;
    private Konkurencija novaKonkurencija;    
    
    private LazyDataModel<Konkurencija> lazyModel;      
    
    @PostConstruct
    public void init(){     
         setLista(getKonkurencijaService().findAll());         
         setLazyModel(new LazyDataModelKonkurencija(getKonkurencijaService().findAll())); 
         setNovaKonkurencija(new Konkurencija());
         setSelectKonkurencija(null); 
    }     

    /**
     * @return the lista
     */
    public List<Konkurencija> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Konkurencija> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectKonkurencija
     */
    public Konkurencija getSelectKonkurencija() {
        return selectKonkurencija;
    }

    /**
     * @param selectKonkurencija the selectKonkurencija to set
     */
    public void setSelectKonkurencija(Konkurencija selectKonkurencija) {
        this.selectKonkurencija = selectKonkurencija;
    }

    /**
     * @return the novaKonkurencija
     */
    public Konkurencija getNovaKonkurencija() {
        return novaKonkurencija;
    }

    /**
     * @param novaKonkurencija the novaKonkurencija to set
     */
    public void setNovaKonkurencija(Konkurencija novaKonkurencija) {
        this.novaKonkurencija = novaKonkurencija;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<Konkurencija> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<Konkurencija> lazyModel) {
        this.lazyModel = lazyModel;
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
    
    public void dodajNovuKonkurenciju(){
        konkurencijaService.save(novaKonkurencija);
        init();
    }
    
    public void azurirajKonkurenciju() {
        konkurencijaService.save(selectKonkurencija); 
    }
    
    public void brisiKonkurenciju() {        
        konkurencijaService.delete(selectKonkurencija); 
        init();
    }    
    
}
