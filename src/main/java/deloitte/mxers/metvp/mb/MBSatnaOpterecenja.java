/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.SatnaOpterecenja;
import deloitte.mxers.metvp.lazyViews.LazyDataModelSatnaOpterecenja;
import deloitte.mxers.metvp.service.SatnaOpterecenjaService;
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
@Component("MBSatnaOpterecenja")
@SessionScoped
public class MBSatnaOpterecenja {
    
    @Autowired  
    private SatnaOpterecenjaService satnaOpterecenjaService;    
    private List<SatnaOpterecenja> lista;    
    private SatnaOpterecenja selectSatnaOpterecenja;
    private SatnaOpterecenja novaSatnaOpterecenja;    
    
    private LazyDataModel<SatnaOpterecenja> lazyModel;     
    
    @PostConstruct
    public void init(){     
         setLista(getSatnaOpterecenjaService().findAll());         
         setLazyModel(new LazyDataModelSatnaOpterecenja(getSatnaOpterecenjaService().findAll())); 
         setNovaSatnaOpterecenja(new SatnaOpterecenja());
         setSelectSatnaOpterecenja(null);
    }

    /**
     * @return the satnaOpterecenjaService
     */
    public SatnaOpterecenjaService getSatnaOpterecenjaService() {
        return satnaOpterecenjaService;
    }

    /**
     * @param satnaOpterecenjaService the satnaOpterecenjaService to set
     */
    public void setSatnaOpterecenjaService(SatnaOpterecenjaService satnaOpterecenjaService) {
        this.satnaOpterecenjaService = satnaOpterecenjaService;
    }

    /**
     * @return the lista
     */
    public List<SatnaOpterecenja> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<SatnaOpterecenja> lista) {
        this.lista = lista;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<SatnaOpterecenja> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<SatnaOpterecenja> lazyModel) {
        this.lazyModel = lazyModel;
    }

    /**
     * @return the selectSatnaOpterecenja
     */
    public SatnaOpterecenja getSelectSatnaOpterecenja() {
        return selectSatnaOpterecenja;
    }

    /**
     * @param selectSatnaOpterecenja the selectSatnaOpterecenja to set
     */
    public void setSelectSatnaOpterecenja(SatnaOpterecenja selectSatnaOpterecenja) {
        this.selectSatnaOpterecenja = selectSatnaOpterecenja;
    }

    /**
     * @return the novaSatnaOpterecenja
     */
    public SatnaOpterecenja getNovaSatnaOpterecenja() {
        return novaSatnaOpterecenja;
    }

    /**
     * @param novaSatnaOpterecenja the novaSatnaOpterecenja to set
     */
    public void setNovaSatnaOpterecenja(SatnaOpterecenja novaSatnaOpterecenja) {
        this.novaSatnaOpterecenja = novaSatnaOpterecenja;
    }
    
     public void dodajNovaSatnaOpterecenja(){
        satnaOpterecenjaService.save(novaSatnaOpterecenja);
        init();
    }
    
    public void azurirajSatnaOpterecenja() {
        satnaOpterecenjaService.save(selectSatnaOpterecenja);
    }
    
    public void brisiSatnaOpterecenja() {        
        satnaOpterecenjaService.delete(selectSatnaOpterecenja); 
        init();
    }   
    
}
