/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Trgovina;
import deloitte.mxers.metvp.lazyViews.LazyDataModelTrgovina;
import deloitte.mxers.metvp.service.TrgovinaService;
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
@Component("MBTrgovina")
@SessionScoped
public class MBTrgovina {
  
    @Autowired  
    private TrgovinaService trgovinaService;    
    private List<Trgovina> lista;    
    private Trgovina selectTrgovina;
    private Trgovina novaTrgovina;    
    
    private LazyDataModel<Trgovina> lazyModel;      

    public TrgovinaService getTrgovinaService() {
        return trgovinaService;
    }

    public void setTrgovinaService(TrgovinaService trgovinaService) {
        this.trgovinaService = trgovinaService;
    }

    public List<Trgovina> getLista() {
        return lista;
    }

    public void setLista(List<Trgovina> lista) {
        this.lista = lista;
    }

    public Trgovina getSelectTrgovina() {
        return selectTrgovina;
    }

    public void setSelectTrgovina(Trgovina selectTrgovina) {
        this.selectTrgovina = selectTrgovina;
    }

    public Trgovina getNovaTrgovina() {
        return novaTrgovina;
    }

    public void setNovaTrgovina(Trgovina novaTrgovina) {
        this.novaTrgovina = novaTrgovina;
    }

    public LazyDataModel<Trgovina> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Trgovina> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    @PostConstruct
    public void init(){     
         setLista(getTrgovinaService().findAll());         
         setLazyModel(new LazyDataModelTrgovina(getTrgovinaService().findAll())); 
         setNovaTrgovina(new Trgovina());
         setSelectTrgovina(null); 
    }       
    
    public void dodajNovuTrgovinu(){
        trgovinaService.save(novaTrgovina);
        init();
    }
    
    public void azurirajTrgovinu() {
        trgovinaService.save(selectTrgovina);
    }
    
    public void brisiTrgovinu() {        
        trgovinaService.delete(selectTrgovina); 
        init();
    }    
}
