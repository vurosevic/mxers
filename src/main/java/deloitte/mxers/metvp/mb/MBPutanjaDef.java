/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.PutanjaDef;
import deloitte.mxers.metvp.lazyViews.LazyDataModelPutanjaDef;
import deloitte.mxers.metvp.service.BerzaService;
import deloitte.mxers.metvp.service.PutanjaDefService;
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
@Component("MBPutanjaDef")
@SessionScoped
public class MBPutanjaDef {
    
    @Autowired
    private PutanjaDefService putanjaDefService;
    
    private Long selectBerzaId;
    private Long novaBerzaId;   
    
    @Autowired  
    private BerzaService berzaService;
    
//    @Autowired
//    private MBAukcijaCene mBAukcijaCene;
    
    private List<PutanjaDef> lista;    
    private PutanjaDef selectPutanjaDef;
    private PutanjaDef novaPutanjaDef;    
    
    private LazyDataModel<PutanjaDef> lazyModel;      

    @PostConstruct
    public void init(){     
         setLista(getPutanjaDefService().findAll());         
         setLazyModel(new LazyDataModelPutanjaDef(getPutanjaDefService().findAll())); 
         setNovaPutanjaDef(new PutanjaDef());
         setSelectPutanjaDef(null);
         selectBerzaId = null;
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
     * @return the novaBerzaId
     */
    public Long getNovaBerzaId() {
        return novaBerzaId;
    }

    /**
     * @param novaBerzaId the novaBerzaId to set
     */
    public void setNovaBerzaId(Long novaBerzaId) {
        this.novaBerzaId = novaBerzaId;
    }

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
     * @return the lista
     */
    public List<PutanjaDef> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<PutanjaDef> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectPutanjaDef
     */
    public PutanjaDef getSelectPutanjaDef() {
        return selectPutanjaDef;
    }

    /**
     * @param selectPutanjaDef the selectPutanjaDef to set
     */
    public void setSelectPutanjaDef(PutanjaDef selectPutanjaDef) {
        this.selectPutanjaDef = selectPutanjaDef;
    }

    /**
     * @return the novaPutanjaDef
     */
    public PutanjaDef getNovaPutanjaDef() {
        return novaPutanjaDef;
    }

    /**
     * @param novaPutanjaDef the novaPutanjaDef to set
     */
    public void setNovaPutanjaDef(PutanjaDef novaPutanjaDef) {
        this.novaPutanjaDef = novaPutanjaDef;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<PutanjaDef> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<PutanjaDef> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuPutanjuDef(){ 
        novaPutanjaDef.setBerza(getBerzaService().findById(getNovaBerzaId()).get());  
        putanjaDefService.save(novaPutanjaDef);
        init();
        novaBerzaId = null;
    }
    
    public void azurirajPutanjuDef() {
        if (getSelectBerzaId() != null)
        selectPutanjaDef.setBerza(getBerzaService().findById(getSelectBerzaId()).get());   
        putanjaDefService.save(selectPutanjaDef);
        
    }
    
    public void brisiPutanjuDef() {        
        putanjaDefService.delete(selectPutanjaDef);
        init();
    }    
    
    
}
