/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Elektrana;
import deloitte.mxers.metvp.lazyViews.LazyDataModelElektrane;
import deloitte.mxers.metvp.service.ElektraneService;
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
@Component("MBElektrane")
@SessionScoped
public class MBElektrane {
    
    @Autowired
    private VrstaElektraneService vrstaElektraneService;
    
    private Long selectVrstaElektraneId;   
    
    @Autowired  
    private ElektraneService elektraneService;
    private List<Elektrana> lista;    
    private Elektrana selectElektrana;
    private Elektrana novaElektrana;    
    
    private LazyDataModel<Elektrana> lazyModel;      

    @PostConstruct
    public void init(){     
         setLista(getElektraneService().findAll());         
         setLazyModel(new LazyDataModelElektrane(getElektraneService().findAll())); 
         setNovaElektrana(new Elektrana());
         setSelectElektrana(null); 
         selectVrstaElektraneId = null;
    }     
    
    public ElektraneService getElektraneService() {
        return elektraneService;
    }

    public void setElektraneService(ElektraneService elektraneService) {
        this.elektraneService = elektraneService;
    }

    public List<Elektrana> getLista() {
        return lista;
    }

    public void setLista(List<Elektrana> lista) {
        this.lista = lista;
    }

    public Elektrana getSelectElektrana() {
        return selectElektrana;
    }

    public void setSelectElektrana(Elektrana selectElektrana) {
        this.selectElektrana = selectElektrana;
    }

    public Elektrana getNovaElektrana() {
        return novaElektrana;
    }

    public void setNovaElektrana(Elektrana novaElektrana) {
        this.novaElektrana = novaElektrana;
    }

    public LazyDataModel<Elektrana> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Elektrana> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuElektranu(){
        novaElektrana.setVrstaElektrane(getVrstaElektraneService().findById(getSelectVrstaElektraneId()).get());  
        elektraneService.save(novaElektrana);
        init();
    }
    
    public void azurirajElektranu() {
        if (getSelectVrstaElektraneId() != null)
        selectElektrana.setVrstaElektrane(getVrstaElektraneService().findById(getSelectVrstaElektraneId()).get());  
        
        elektraneService.save(selectElektrana);
        selectVrstaElektraneId = null;
    }
    
    public void brisiElektranu() {        
        elektraneService.delete(selectElektrana);
        init();
    }    

    public VrstaElektraneService getVrstaElektraneService() {
        return vrstaElektraneService;
    }

    public void setVrstaElektraneService(VrstaElektraneService vrstaElektraneService) {
        this.vrstaElektraneService = vrstaElektraneService;
    }

    public Long getSelectVrstaElektraneId() {
        return selectVrstaElektraneId;
    }

    public void setSelectVrstaElektraneId(Long selectVrstaElektraneId) {
        this.selectVrstaElektraneId = selectVrstaElektraneId;
    }
    
    
    
    
}
