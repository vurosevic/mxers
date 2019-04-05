/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetGodinaJc;
import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetJc;
import deloitte.mxers.metvp.service.VpFinalSetGodinaJcService;
import deloitte.mxers.metvp.service.VpFinalSetJcService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBVpFinalSetJc")
@SessionScoped
public class MBVpFinalSetJc {
    
    @Autowired
    private VpFinalSetJcService vpFinalSetJcService;
    
    @Autowired
    private VpFinalSetGodinaJcService vpFinalSetGodinaJcService;
    
    private List<VpFinalSetJc> listaVpFinalSetJc;
    
    private List<VpFinalSetGodinaJc> listaVpFinalSetGodinaJc;

    /**
     * @return the vpFinalSetJcService
     */
    public VpFinalSetJcService getVpFinalSetJcService() {
        return vpFinalSetJcService;
    }

    /**
     * @param vpFinalSetJcService the vpFinalSetJcService to set
     */
    public void setVpFinalSetJcService(VpFinalSetJcService vpFinalSetJcService) {
        this.vpFinalSetJcService = vpFinalSetJcService;
    }

    /**
     * @return the vpFinalSetGodinaJcService
     */
    public VpFinalSetGodinaJcService getVpFinalSetGodinaJcService() {
        return vpFinalSetGodinaJcService;
    }

    /**
     * @param vpFinalSetGodinaJcService the vpFinalSetGodinaJcService to set
     */
    public void setVpFinalSetGodinaJcService(VpFinalSetGodinaJcService vpFinalSetGodinaJcService) {
        this.vpFinalSetGodinaJcService = vpFinalSetGodinaJcService;
    }

    /**
     * @return the listaVpFinalSetJc
     */
    public List<VpFinalSetJc> getListaVpFinalSetJc() {
        return listaVpFinalSetJc;
    }

    /**
     * @param listaVpFinalSetJc the listaVpFinalSetJc to set
     */
    public void setListaVpFinalSetJc(List<VpFinalSetJc> listaVpFinalSetJc) {
        this.listaVpFinalSetJc = listaVpFinalSetJc;
    }

    /**
     * @return the listaVpFinalSetGodinaJc
     */
    public List<VpFinalSetGodinaJc> getListaVpFinalSetGodinaJc() {
        return listaVpFinalSetGodinaJc;
    }

    /**
     * @param listaVpFinalSetGodinaJc the listaVpFinalSetGodinaJc to set
     */
    public void setListaVpFinalSetGodinaJc(List<VpFinalSetGodinaJc> listaVpFinalSetGodinaJc) {
        this.listaVpFinalSetGodinaJc = listaVpFinalSetGodinaJc;
    }
    
    @PostConstruct
    public void init(){     
         setListaVpFinalSetJc(getVpFinalSetJcService().findAll()); 
         setListaVpFinalSetGodinaJc(getVpFinalSetGodinaJcService().findAll());
    }
    
    public VpFinalSetJc getFinalSetJcData(int i){
         return listaVpFinalSetJc.get(i);
    }
    
    public VpFinalSetGodinaJc getFinalSetGodinaJcData(int i){
         return listaVpFinalSetGodinaJc.get(i);
    }    
}
