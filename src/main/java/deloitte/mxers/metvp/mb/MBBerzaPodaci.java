/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.BerzaPodaci;
import deloitte.mxers.metvp.lazyViews.LazyDataModelBerzaPodaci;
import deloitte.mxers.metvp.service.BerzaPodaciService;
import deloitte.mxers.metvp.service.BerzaService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBBerzaPodaci")
@SessionScoped
public class MBBerzaPodaci {
    
    @Autowired
    private BerzaService berzaService;
    
    private Long selectBerzaId;   
    
    @Autowired      
    private BerzaPodaciService berzaPodaciService;
    
    @Autowired
    private DataSource dataSource;    
    
    private List<BerzaPodaci> lista;    
    private BerzaPodaci selectBerzaPodaci;
    private BerzaPodaci noviBerzaPodaci;    
    
    private LazyDataModel<BerzaPodaci> lazyModel;     

    /**
     * @return the berzaService
     */
    public BerzaService getBerzaService() {
        return berzaService;
    }

    /**
     * @param berzaService the berzaService to set
     */
    public void setBerzaService(BerzaService berzaService) {
        this.berzaService = berzaService;
    }

    /**
     * @return the selectBerzaId
     */
    public Long getSelectBerzaId() {
        return selectBerzaId;
    }

    /**
     * @param selectBerzaId the selectBerzaId to set
     */
    public void setSelectBerzaId(Long selectBerzaId) {
        this.selectBerzaId = selectBerzaId;
    }

    /**
     * @return the berzaPodaciService
     */
    public BerzaPodaciService getBerzaPodaciService() {
        return berzaPodaciService;
    }

    /**
     * @param berzaPodaciService the berzaPodaciService to set
     */
    public void setBerzaPodaciService(BerzaPodaciService berzaPodaciService) {
        this.berzaPodaciService = berzaPodaciService;
    }

    /**
     * @return the lista
     */
    public List<BerzaPodaci> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<BerzaPodaci> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectBerzaPodaci
     */
    public BerzaPodaci getSelectBerzaPodaci() {
        return selectBerzaPodaci;
    }

    /**
     * @param selectBerzaPodaci the selectBerzaPodaci to set
     */
    public void setSelectBerzaPodaci(BerzaPodaci selectBerzaPodaci) {
        this.selectBerzaPodaci = selectBerzaPodaci;
    }

    /**
     * @return the noviBerzaPodaci
     */
    public BerzaPodaci getNoviBerzaPodaci() {
        return noviBerzaPodaci;
    }

    /**
     * @param noviBerzaPodaci the noviBerzaPodaci to set
     */
    public void setNoviBerzaPodaci(BerzaPodaci noviBerzaPodaci) {
        this.noviBerzaPodaci = noviBerzaPodaci;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<BerzaPodaci> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<BerzaPodaci> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
     @PostConstruct    
    public void init(){     
         setLista(getBerzaPodaciService().findAll());         
         setLazyModel(new LazyDataModelBerzaPodaci(getBerzaPodaciService().findAll())); 
         setNoviBerzaPodaci(new BerzaPodaci());  
         setSelectBerzaPodaci(null); 
         selectBerzaId = null;
    }    
    
    public void dodajNoveBerzaPodatke(){
        noviBerzaPodaci.setBerza((getBerzaService().findById(getSelectBerzaId()).get()));  
        berzaPodaciService.save(noviBerzaPodaci);
        init();
    }
    
    public void azurirajBerzaPodatke() {
        if (getSelectBerzaId() != null)
        selectBerzaPodaci.setBerza(getBerzaService().findById(getSelectBerzaId()).get());
        
        berzaPodaciService.save(selectBerzaPodaci);         
        selectBerzaId = null; 
    }
    
    public void brisiBerzaPodatke() {        
        berzaPodaciService.delete(selectBerzaPodaci);
        init();
    }    
    
}
