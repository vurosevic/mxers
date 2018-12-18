/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.lazyViews.LazyDataModelCenePraga;
import deloitte.mxers.metvp.service.CenePragaService;
import deloitte.mxers.metvp.service.ElektraneService;
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
@Component("MBCenePraga")
@SessionScoped
public class MBCenePraga {
    
    @Autowired
    private ElektraneService elektraneService; 
    
    private Long selectElektranaId;   
    
    @Autowired      
    private CenePragaService cenaPragaService;    
    
    private List<CenaPraga> lista;    
    private CenaPraga selectCenaPraga;
    private CenaPraga novaCenaPraga;    
    
    private LazyDataModel<CenaPraga> lazyModel;      
    
    @PostConstruct    
    public void init(){     
         setLista(getCenaPragaService().findAll());         
         setLazyModel(new LazyDataModelCenePraga(getCenaPragaService().findAll())); 
         setNovaCenaPraga(new CenaPraga());  
         setSelectCenaPraga(null); 
         selectElektranaId = null;
    }     
    
    public ElektraneService getElektraneService() {
        return elektraneService;
    }

    public void setElektraneService(ElektraneService elektraneService) {
        this.elektraneService = elektraneService;
    }

    public Long getSelectElektranaId() {
        return selectElektranaId;
    }

    public void setSelectElektranaId(Long selectElektranaId) {
        this.selectElektranaId = selectElektranaId;
    }

    public List<CenaPraga> getLista() {
        return lista;
    }

    public void setLista(List<CenaPraga> lista) {
        this.lista = lista;
    }

    public CenaPraga getSelectCenaPraga() {
        return selectCenaPraga;
    }

    public void setSelectCenaPraga(CenaPraga selectCenaPraga) {
        this.selectCenaPraga = selectCenaPraga;
    }

    public CenaPraga getNovaCenaPraga() {
        return novaCenaPraga;
    }

    public void setNovaCenaPraga(CenaPraga novaCenaPraga) {
        this.novaCenaPraga = novaCenaPraga;
    }

    public LazyDataModel<CenaPraga> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<CenaPraga> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public CenePragaService getCenaPragaService() {
        return cenaPragaService;
    }

    public void setCenaPragaService(CenePragaService cenaPragaService) {
        this.cenaPragaService = cenaPragaService;
    }

    public void dodajNovuCenuPraga(){
        novaCenaPraga.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());  
        cenaPragaService.save(novaCenaPraga);
        init();
    }
    
    public void azurirajCenuPraga() {
        if (getSelectElektranaId() != null)
        selectCenaPraga.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());   
        
        cenaPragaService.save(selectCenaPraga);
        selectElektranaId = null; 
    }
    
    public void brisiCenuPraga() {        
        cenaPragaService.delete(selectCenaPraga);
        init();
    }
      
}
