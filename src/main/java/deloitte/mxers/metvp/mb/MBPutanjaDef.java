/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.AukcijaCena;
import deloitte.mxers.metvp.domen.PutanjaDef;
import deloitte.mxers.metvp.domen.PutanjaDetalj;
import deloitte.mxers.metvp.lazyViews.LazyDataModelPutanjaDef;
import deloitte.mxers.metvp.service.AukcijaCenaService;
import deloitte.mxers.metvp.service.BerzaService;
import deloitte.mxers.metvp.service.PutanjaDefService;
import deloitte.mxers.metvp.service.PutanjaDetaljService;
import java.text.DecimalFormat;
import java.util.Date;
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
    
    @Autowired  
    private PutanjaDetaljService putanjaDetaljService;   
    
    @Autowired  
    private AukcijaCenaService aukcijaCenaService;      
    
    @Autowired
    private MBPutanjaDetalj mBPutanjaDetalj;    
    
//    @Autowired
//    private MBAukcijaCene mBAukcijaCene;
    
    private List<PutanjaDef> lista;    
    private PutanjaDef selectPutanjaDef;
    private PutanjaDef novaPutanjaDef;    
    
    private LazyDataModel<PutanjaDef> lazyModel;      

    // za proracun cena
    
    private List<Integer> listaGodina;
    
    private Integer godinaZaProracun;
    private Long smerIdZaProracun;
    
    @PostConstruct
    public void init(){     
         setLista(getPutanjaDefService().findAll());
         setListaGodina(aukcijaCenaService.listaGodina());
         setLazyModel(new LazyDataModelPutanjaDef(getPutanjaDefService().findAll())); 
         setNovaPutanjaDef(new PutanjaDef());
         setSelectPutanjaDef(null);
         selectBerzaId = null;
//         godinaZaProracun = 2019;
//         smerIdZaProracun = 1L;
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
    
    public void refreshPutanjuDef(){
        mBPutanjaDetalj.setSelectPutanjaDefId(selectPutanjaDef.getId());
        mBPutanjaDetalj.refresh();
    }
    
    public void refresh(){
         setLista(getPutanjaDefService().findAll());
         setLazyModel(new LazyDataModelPutanjaDef(getPutanjaDefService().findAll())); 
    }
    
    public Double racunajCenuZaPravac(Long pravacId){
        Double rez = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        List<PutanjaDetalj> detalji = getPutanjaDetaljService().listaPutanjaDetaljaPoDef(pravacId);
        
        for (PutanjaDetalj pd : detalji){
            List<AukcijaCena> cene = aukcijaCenaService.listaCenaPoAukcijiZaGodinuPoSmeru(pd.getAukcija().getId(), getGodinaZaProracun(), getSmerIdZaProracun());
            for (AukcijaCena ac : cene) {
                rez += ac.getCena();
            }            
        }
        return Double.valueOf(df.format(rez));
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
     * @return the listaGodina
     */
    public List<Integer> getListaGodina() {
        return listaGodina;
    }

    /**
     * @param listaGodina the listaGodina to set
     */
    public void setListaGodina(List<Integer> listaGodina) {
        this.listaGodina = listaGodina;
    }

    /**
     * @return the godinaZaProracun
     */
    public Integer getGodinaZaProracun() {
        return godinaZaProracun;
    }

    /**
     * @param godinaZaProracun the godinaZaProracun to set
     */
    public void setGodinaZaProracun(Integer godinaZaProracun) {
        this.godinaZaProracun = godinaZaProracun;
    }

    /**
     * @return the smerIdZaProracun
     */
    public Long getSmerIdZaProracun() {
        return smerIdZaProracun;
    }

    /**
     * @param smerIdZaProracun the smerIdZaProracun to set
     */
    public void setSmerIdZaProracun(Long smerIdZaProracun) {
        this.smerIdZaProracun = smerIdZaProracun;
    }
    
}
