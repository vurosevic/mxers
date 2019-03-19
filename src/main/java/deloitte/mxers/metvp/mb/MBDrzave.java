/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Drzava;
import deloitte.mxers.metvp.lazyViews.LazyDataModelDrzava;
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
@Component("MBDrzave")
@SessionScoped
public class MBDrzave {
    
    @Autowired  
    private DrzavaService drzavaService;    
    private List<Drzava> lista;    
    private Drzava selectDrzava;
    private Drzava novaDrzava;    
    
    private LazyDataModel<Drzava> lazyModel;      
    
    @PostConstruct
    public void init(){     
         setLista(getDrzavaService().findAll());         
         setLazyModel(new LazyDataModelDrzava(getDrzavaService().findAll())); 
         setNovaDrzava(new Drzava());
         setSelectDrzava(null);
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
    public List<Drzava> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Drzava> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectDrzava
     */
    public Drzava getSelectDrzava() {
        return selectDrzava;
    }

    /**
     * @param selectDrzava the selectDrzava to set
     */
    public void setSelectDrzava(Drzava selectDrzava) {
        this.selectDrzava = selectDrzava;
    }

    /**
     * @return the novaDrzava
     */
    public Drzava getNovaDrzava() {
        return novaDrzava;
    }

    /**
     * @param novaDrzava the novaDrzava to set
     */
    public void setNovaDrzava(Drzava novaDrzava) {
        this.novaDrzava = novaDrzava;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<Drzava> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<Drzava> lazyModel) {
        this.lazyModel = lazyModel;
    }
   
     public void dodajNovuDrzavu(){
        drzavaService.save(novaDrzava);
        init();
    }
    
    public void azurirajDrzavu() {
        drzavaService.save(selectDrzava);
    }
    
    public void brisiDrzavu() {        
        drzavaService.delete(selectDrzava); 
        init();
    }
    
}
