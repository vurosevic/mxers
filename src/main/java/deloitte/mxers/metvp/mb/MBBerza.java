/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Berza;
import deloitte.mxers.metvp.lazyViews.LazyDataModelBerza;
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
@Component("MBBerza")
@SessionScoped
public class MBBerza {
    
    @Autowired      
    private BerzaService berzaService;
    
    @Autowired
    private DataSource dataSource;    
    
    private List<Berza> lista;    
    private Berza selectBerza;
    private Berza novaBerza;    
    
    private LazyDataModel<Berza> lazyModel;      

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
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the lista
     */
    public List<Berza> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Berza> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectBerza
     */
    public Berza getSelectBerza() {
        return selectBerza;
    }

    /**
     * @param selectBerza the selectBerza to set
     */
    public void setSelectBerza(Berza selectBerza) {
        this.selectBerza = selectBerza;
    }

    /**
     * @return the novaBerza
     */
    public Berza getNovaBerza() {
        return novaBerza;
    }

    /**
     * @param novaBerza the novaBerza to set
     */
    public void setNovaBerza(Berza novaBerza) {
        this.novaBerza = novaBerza;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<Berza> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<Berza> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    @PostConstruct    
    public void init(){     
         setLista(getBerzaService().findAll());         
         setLazyModel(new LazyDataModelBerza(getBerzaService().findAll())); 
         setNovaBerza(new Berza()); 
         setSelectBerza(null); 
    }
   
    public void dodajNovuBerzu(){        
        berzaService.save(novaBerza);
        init();
    }
    
    public void azurirajBerzu() {    
        berzaService.save(selectBerza);         
    }
    
    public void brisiBerzu() {        
        berzaService.delete(selectBerza);
        init();
    }
    
}
