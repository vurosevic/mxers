/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.KursnaLista;
import deloitte.mxers.metvp.lazyViews.LazyDataModelKursnaLista;
import deloitte.mxers.metvp.service.KursnaListaService;
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
@Component("MBKursnaLista")
@SessionScoped
public class MBKursnaLista {
    
    @Autowired  
    private KursnaListaService kursnaListaService;    
    private List<KursnaLista> lista;    
    private KursnaLista selectKursnaLista;
    private KursnaLista novaKursnaLista;    
    
    private LazyDataModel<KursnaLista> lazyModel;      
    
    @PostConstruct
    public void init(){     
         setLista(getKursnaListaService().findAll());         
         setLazyModel(new LazyDataModelKursnaLista(getKursnaListaService().findAll())); 
         setNovaKursnaLista(new KursnaLista());
         setSelectKursnaLista(null);
    }      

    /**
     * @return the kursnaListaService
     */
    public KursnaListaService getKursnaListaService() {
        return kursnaListaService;
    }

    /**
     * @param kursnaListaService the kursnaListaService to set
     */
    public void setKursnaListaService(KursnaListaService kursnaListaService) {
        this.kursnaListaService = kursnaListaService;
    }

    /**
     * @return the lista
     */
    public List<KursnaLista> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<KursnaLista> lista) {
        this.lista = lista;
    }

    /**
     * @return the selectKursnaLista
     */
    public KursnaLista getSelectKursnaLista() {
        return selectKursnaLista;
    }

    /**
     * @param selectKursnaLista the selectKursnaLista to set
     */
    public void setSelectKursnaLista(KursnaLista selectKursnaLista) {
        this.selectKursnaLista = selectKursnaLista;
    }

    /**
     * @return the novaKursnaLista
     */
    public KursnaLista getNovaKursnaLista() {
        return novaKursnaLista;
    }

    /**
     * @param novaKursnaLista the novaKursnaLista to set
     */
    public void setNovaKursnaLista(KursnaLista novaKursnaLista) {
        this.novaKursnaLista = novaKursnaLista;
    }

    /**
     * @return the lazyModel
     */
    public LazyDataModel<KursnaLista> getLazyModel() {
        return lazyModel;
    }

    /**
     * @param lazyModel the lazyModel to set
     */
    public void setLazyModel(LazyDataModel<KursnaLista> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNoviKurs(){
        kursnaListaService.save(novaKursnaLista);
        init();
    }
    
    public void azurirajKurs() {
        kursnaListaService.save(selectKursnaLista);
    }
    
    public void brisiKurs() {        
        kursnaListaService.delete(selectKursnaLista); 
        init();
    }    
}
