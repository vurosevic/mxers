/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
import deloitte.mxers.metvp.lazyViews.LazyDataModelTroskoviPGK;
import deloitte.mxers.metvp.service.TrosakPrekogranicnihKapacitetaService;
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
@Component("MBTrosakPGK")
@SessionScoped
public class MBTrosakPGK {
    
    @Autowired  
    private TrosakPrekogranicnihKapacitetaService trosakPrekogranicnihKapacitetaService;        
    private List<TrosakPrekogranicnihKapaciteta> lista;        
    private TrosakPrekogranicnihKapaciteta selectTrosakPrekogranicnihKapaciteta;
    private TrosakPrekogranicnihKapaciteta noviTrosakPrekogranicnihKapaciteta;   
    
    private LazyDataModel<TrosakPrekogranicnihKapaciteta> lazyModel;      

    public TrosakPrekogranicnihKapacitetaService getTrosakPrekogranicnihKapacitetaService() {
        return trosakPrekogranicnihKapacitetaService;
    }

    public void setTrosakPrekogranicnihKapacitetaService(TrosakPrekogranicnihKapacitetaService trosakPrekogranicnihKapacitetaService) {
        this.trosakPrekogranicnihKapacitetaService = trosakPrekogranicnihKapacitetaService;
    }

    public List<TrosakPrekogranicnihKapaciteta> getLista() {
        return lista;
    }

    public void setLista(List<TrosakPrekogranicnihKapaciteta> lista) {
        this.lista = lista;
    }

    public TrosakPrekogranicnihKapaciteta getSelectTrosakPrekogranicnihKapaciteta() {
        return selectTrosakPrekogranicnihKapaciteta;
    }

    public void setSelectTrosakPrekogranicnihKapaciteta(TrosakPrekogranicnihKapaciteta selectTrosakPrekogranicnihKapaciteta) {
        this.selectTrosakPrekogranicnihKapaciteta = selectTrosakPrekogranicnihKapaciteta;
    }

    public TrosakPrekogranicnihKapaciteta getNoviTrosakPrekogranicnihKapaciteta() {
        return noviTrosakPrekogranicnihKapaciteta;
    }

    public void setNoviTrosakPrekogranicnihKapaciteta(TrosakPrekogranicnihKapaciteta noviTrosakPrekogranicnihKapaciteta) {
        this.noviTrosakPrekogranicnihKapaciteta = noviTrosakPrekogranicnihKapaciteta;
    }

    public LazyDataModel<TrosakPrekogranicnihKapaciteta> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<TrosakPrekogranicnihKapaciteta> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    @PostConstruct
    public void init(){     
         setLista(getTrosakPrekogranicnihKapacitetaService().findAll());         
         setLazyModel(new LazyDataModelTroskoviPGK(getTrosakPrekogranicnihKapacitetaService().findAll())); 
         setNoviTrosakPrekogranicnihKapaciteta(new TrosakPrekogranicnihKapaciteta());
         setSelectTrosakPrekogranicnihKapaciteta(null); 
    }       
    
    public void dodajNoviTrosakPGK(){
        trosakPrekogranicnihKapacitetaService.save(noviTrosakPrekogranicnihKapaciteta);
        init();
    }
    
    public void azurirajTrosakPGK() { 
        trosakPrekogranicnihKapacitetaService.save(selectTrosakPrekogranicnihKapaciteta);
    }
    
    public void brisiTrosakPGK() {        
        trosakPrekogranicnihKapacitetaService.delete(selectTrosakPrekogranicnihKapaciteta); 
        init();
    }        
    
}
