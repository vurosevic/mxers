/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Debalans;
import deloitte.mxers.metvp.lazyViews.LazyDataModelDebalans;
import deloitte.mxers.metvp.service.DebalansService;
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
@Component("MBDebalans")
@SessionScoped
public class MBDebalans {
    
    @Autowired  
    private DebalansService debalansService;    
    private List<Debalans> lista;    
    private Debalans selectDebalans;
    private Debalans noviDebalans;    
    
    private LazyDataModel<Debalans> lazyModel;       

    public DebalansService getDebalansService() {
        return debalansService;
    }

    public void setDebalansService(DebalansService debalansService) {
        this.debalansService = debalansService;
    }

    public List<Debalans> getLista() {
        return lista;
    }

    public void setLista(List<Debalans> lista) {
        this.lista = lista;
    }

    public Debalans getSelectDebalans() {
        return selectDebalans;
    }

    public void setSelectDebalans(Debalans selectDebalans) {
        this.selectDebalans = selectDebalans;
    }

    public Debalans getNoviDebalans() {
        return noviDebalans;
    }

    public void setNoviDebalans(Debalans noviDebalans) {
        this.noviDebalans = noviDebalans;
    }

    public LazyDataModel<Debalans> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Debalans> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    @PostConstruct
    public void init(){     
         setLista(getDebalansService().findAll());         
         setLazyModel(new LazyDataModelDebalans(getDebalansService().findAll())); 
         setNoviDebalans(new Debalans());
         setSelectDebalans(null); 
    }           
    
    public void dodajNoviDebalans(){
        debalansService.save(noviDebalans);
        init();
    }
    
    public void azurirajDebalans() {
        debalansService.save(selectDebalans);
    }
    
    public void brisiDebalans() {        
        debalansService.delete(selectDebalans); 
        init();
    }        
    
}
