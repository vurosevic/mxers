/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.PutanjaDef;
import deloitte.mxers.metvp.domen.PutanjaDetalj;
import deloitte.mxers.metvp.lazyViews.LazyDataModelPutanjaDetalj;
import deloitte.mxers.metvp.service.AukcijaService;
import deloitte.mxers.metvp.service.PutanjaDefService;
import deloitte.mxers.metvp.service.PutanjaDetaljService;
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
@Component("MBPutanjaDetalj")
@SessionScoped
public class MBPutanjaDetalj {
    
    @Autowired
    private PutanjaDetaljService putanjaDetaljService;
    
    private Long selectPutanjaDefId;   
    private Long selectAukcijaId;
    
    private Long novaPutanjaDefId;   
    private Long novaAukcijaId;    
    
    @Autowired  
    private AukcijaService aukcijaService;
 
    @Autowired  
    private PutanjaDefService putanjaDefService;
    
    private List<PutanjaDetalj> lista; 
    private PutanjaDetalj selectPutanjaDetalj;
    private PutanjaDetalj novaPutanjaDetalj;    
    
    private LazyDataModel<PutanjaDetalj> lazyModel;     

    @PostConstruct
    public void init(){     
         //setLista(getAukcijaCenaService().findAll());  
         //setLazyModel(new LazyDataModelAukcijaCena(getAukcijaCenaService().findAll())); 
         setNovaPutanjaDetalj(new PutanjaDetalj());
         setSelectPutanjaDetalj(null);
         selectAukcijaId = null;
         //selectAukcijaId = null;
          
         refresh();
    }    
    
    
    /**
     * @return the putanjaDetaljService
     */
    public PutanjaDetaljService getPutanjaDetaljService() {
        return putanjaDetaljService;
    }

    /**
     * @param putanjaDetaljService the putanjaDetaljService to set
     */
    public void setPutanjaDetaljService(PutanjaDetaljService putanjaDetaljService) {
        this.putanjaDetaljService = putanjaDetaljService;
    }

    /**
     * @return the selectPutanjaDefId
     */
    public Long getSelectPutanjaDefId() {
        return selectPutanjaDefId;
    }

    /**
     * @param selectPutanjaDefId the selectPutanjaDefId to set
     */
    public void setSelectPutanjaDefId(Long selectPutanjaDefId) {
        this.selectPutanjaDefId = selectPutanjaDefId;
    }

    /**
     * @return the selectAukcijaId
     */
    public Long getSelectAukcijaId() {
        return selectAukcijaId;
    }

    /**
     * @param selectAukcijaId the selectAukcijaId to set
     */
    public void setSelectAukcijaId(Long selectAukcijaId) {
        this.selectAukcijaId = selectAukcijaId;
    }

    /**
     * @return the novaPutanjaDefId
     */
    public Long getNovaPutanjaDefId() {
        return novaPutanjaDefId;
    }

    /**
     * @param novaPutanjaDefId the novaPutanjaDefId to set
     */
    public void setNovaPutanjaDefId(Long novaPutanjaDefId) {
        this.novaPutanjaDefId = novaPutanjaDefId;
    }

    /**
     * @return the novaAukcijaId
     */
    public Long getNovaAukcijaId() {
        return novaAukcijaId;
    }

    /**
     * @param novaAukcijaId the novaAukcijaId to set
     */
    public void setNovaAukcijaId(Long novaAukcijaId) {
        this.novaAukcijaId = novaAukcijaId;
    }

    /**
     * @return the aukcijaService
     */
    public AukcijaService getAukcijaService() {
        return aukcijaService;
    }

    /**
     * @param aukcijaService the aukcijaService to set
     */
    public void setAukcijaService(AukcijaService aukcijaService) {
        this.aukcijaService = aukcijaService;
    }

    /**
     * @return the putanjaDefService
     */
    public PutanjaDefService getPutanjaDefService() {
        return putanjaDefService;
    }

    /**
     * @param putanjaDefService the putanjaDefService to set
     */
    public void setPutanjaDefService(PutanjaDefService putanjaDefService) {
        this.putanjaDefService = putanjaDefService;
    }

    /**
     * @return the lista
     */
    public List<PutanjaDetalj> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<PutanjaDetalj> lista) {
        this.lista = lista;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<PutanjaDetalj> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<PutanjaDetalj> lazyModel) {
        this.lazyModel = lazyModel;
    }

    /**
     * @return the selectPutanjaDetalj
     */
    public PutanjaDetalj getSelectPutanjaDetalj() {
        return selectPutanjaDetalj;
    }

    /**
     * @param selectPutanjaDetalj the selectPutanjaDetalj to set
     */
    public void setSelectPutanjaDetalj(PutanjaDetalj selectPutanjaDetalj) {
        this.selectPutanjaDetalj = selectPutanjaDetalj;
    }

    /**
     * @return the novaPutanjaDetalj
     */
    public PutanjaDetalj getNovaPutanjaDetalj() {
        return novaPutanjaDetalj;
    }

    /**
     * @param novaPutanjaDetalj the novaPutanjaDetalj to set
     */
    public void setNovaPutanjaDetalj(PutanjaDetalj novaPutanjaDetalj) {
        this.novaPutanjaDetalj = novaPutanjaDetalj;
    }
    
    //dodati insert, update, delete, refresh
    public void dodajNovuPutanjuDetalj(){
        novaPutanjaDetalj.setPutanjaDef(getPutanjaDefService().findById(getSelectPutanjaDefId()).get()); // dodaje se selektovana putanja 
        novaPutanjaDetalj.setAukcija(getAukcijaService().findById(getNovaAukcijaId()).get()); 
        putanjaDetaljService.save(novaPutanjaDetalj);
        init();
        novaPutanjaDefId = null;
        novaAukcijaId = null;
    }
    
    public void azurirajPutanjuDetalj() {
        if (getSelectPutanjaDefId() != null)
        selectPutanjaDetalj.setPutanjaDef(getPutanjaDefService().findById(getSelectPutanjaDefId()).get());  
        
        if (getSelectAukcijaId() != null)
        selectPutanjaDetalj.setAukcija(getAukcijaService().findById(getSelectAukcijaId()).get());          
        
        putanjaDetaljService.save(selectPutanjaDetalj);         
    }
    
    public void brisiPutanjuDetalj() {        
        putanjaDetaljService.delete(selectPutanjaDetalj);
        init();
    }    
    
    public void refresh(){
         setLista(putanjaDetaljService.listaPutanjaDetaljaPoDef(getSelectPutanjaDefId()));
         setLazyModel(new LazyDataModelPutanjaDetalj(putanjaDetaljService.listaPutanjaDetaljaPoDef(getSelectPutanjaDefId())));
         selectPutanjaDetalj = null;
    }
    
    public PutanjaDef getParentPutanjaDef(){
        if (getSelectPutanjaDefId() != null)
            return getPutanjaDefService().findById(getSelectPutanjaDefId()).get();
        else return null;
    }
    
}
