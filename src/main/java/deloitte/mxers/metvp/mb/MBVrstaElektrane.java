/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.VrstaElektrane;
import deloitte.mxers.metvp.lazyViews.LazyDataModelVrstaElektrane;
import deloitte.mxers.metvp.service.VrstaElektraneService;
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
@Component("MBVrstaElektrane")
@SessionScoped
public class MBVrstaElektrane {
    
    @Autowired  
    private VrstaElektraneService vrstaElektraneService;    
    private List<VrstaElektrane> lista;    
    private VrstaElektrane selectVrstaElektrane;
    private VrstaElektrane novaVrstaElektrane;    
    
    private LazyDataModel<VrstaElektrane> lazyModel;      
    
    @PostConstruct
    public void init(){     
         setLista(getVrstaElektraneService().findAll());         
         setLazyModel(new LazyDataModelVrstaElektrane(getVrstaElektraneService().findAll())); 
         setNovaVrstaElektrane(new VrstaElektrane());
         setSelectVrstaElektrane(null);
    }     

    public MBVrstaElektrane() {
    }        

    public VrstaElektraneService getVrstaElektraneService() {
        return vrstaElektraneService;
    }

    public void setVrstaElektraneService(VrstaElektraneService vrstaElektraneService) {
        this.vrstaElektraneService = vrstaElektraneService;
    }

    public List<VrstaElektrane> getLista() {
        return lista;
    }

    public void setLista(List<VrstaElektrane> lista) {
        this.lista = lista;
    }

    public VrstaElektrane getSelectVrstaElektrane() {
        return selectVrstaElektrane;
    }

    public void setSelectVrstaElektrane(VrstaElektrane selectVrstaElektrane) {
        this.selectVrstaElektrane = selectVrstaElektrane;
    }

    public VrstaElektrane getNovaVrstaElektrane() {
        return novaVrstaElektrane;
    }

    public void setNovaVrstaElektrane(VrstaElektrane novaVrstaElektrane) {
        this.novaVrstaElektrane = novaVrstaElektrane;
    }

    public LazyDataModel<VrstaElektrane> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<VrstaElektrane> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuVrstuElektrane(){
        vrstaElektraneService.save(novaVrstaElektrane);
        init();
    }
    
    public void azurirajVrstuElektrane() {
        vrstaElektraneService.save(selectVrstaElektrane);
    }
    
    public void brisiVrstuElektrane() {        
        vrstaElektraneService.delete(selectVrstaElektrane); 
        init();
    }
    
}
