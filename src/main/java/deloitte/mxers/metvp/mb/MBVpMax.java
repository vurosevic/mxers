/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import deloitte.mxers.metvp.service.VpMaxFinalSetService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */

@Component("MBVpMax")
@SessionScoped
public class MBVpMax {
    
    @Autowired
    private VpMaxFinalSetService vpMaxFinalSetService;    
    
    private List<VpMaxFinalSet> listaVpMaxFinal;
    private List<VpMaxFinalSet> listaVpMaxFinalView;

    /**
     * @return the vpMaxFinalSetService
     */
    public VpMaxFinalSetService getVpMaxFinalSetService() {
        return vpMaxFinalSetService;
    }

    /**
     * @param vpMaxFinalSetService the vpMaxFinalSetService to set
     */
    public void setVpMaxFinalSetService(VpMaxFinalSetService vpMaxFinalSetService) {
        this.vpMaxFinalSetService = vpMaxFinalSetService;
    }

    /**
     * @return the listaVpMaxFinal
     */
    public List<VpMaxFinalSet> getListaVpMaxFinal() {
        return listaVpMaxFinal;
    }

    /**
     * @param listaVpMaxFinal the listaVpMaxFinal to set
     */
    public void setListaVpMaxFinal(List<VpMaxFinalSet> listaVpMaxFinal) {
        this.listaVpMaxFinal = listaVpMaxFinal;
    }
    
    @PostConstruct
    public void init(){     
         setListaVpMaxFinal(getVpMaxFinalSetService().findAll()); 
         setListaVpMaxFinalView(getDataForFinalSet());
    } 
    
    private List<VpMaxFinalSet> getDataForFinalSet(){
        List<VpMaxFinalSet> res = new ArrayList<VpMaxFinalSet>();
        Integer broj = listaVpMaxFinal.size();
        
        // uzmi prva 4 kvartala za BL
        res.add(listaVpMaxFinal.get(0));
        res.add(listaVpMaxFinal.get(1));
        res.add(listaVpMaxFinal.get(2));
        res.add(listaVpMaxFinal.get(3));
        
        // uzmi prvu godinu za BL
        for (VpMaxFinalSet v : listaVpMaxFinal){
            if ((v.getPeriod().equals("YR")) && (v.getVrstaOpterecenja().equals("BL"))){
            res.add(v);
            break;
            }
        }
 
        // uzmi prva 4 kvartala za PL
        res.add(listaVpMaxFinal.get((broj/2) + 0));
        res.add(listaVpMaxFinal.get((broj/2) + 1));
        res.add(listaVpMaxFinal.get((broj/2) + 2));
        res.add(listaVpMaxFinal.get((broj/2) + 3));        
        
        // uzmi prvu godinu za PL
        
        for (VpMaxFinalSet v : listaVpMaxFinal){
            if ((v.getPeriod().equals("YR")) && (v.getVrstaOpterecenja().equals("PL"))){
            res.add(v);
            break;
            }
        }        
        
        return res;
    }

    /**
     * @return the listaVpMaxFinalView
     */
    public List<VpMaxFinalSet> getListaVpMaxFinalView() {
        return listaVpMaxFinalView;
    }

    /**
     * @param listaVpMaxFinalView the listaVpMaxFinalView to set
     */
    public void setListaVpMaxFinalView(List<VpMaxFinalSet> listaVpMaxFinalView) {
        this.listaVpMaxFinalView = listaVpMaxFinalView;
    }
    
    public VpMaxFinalSet getFinalData(int i){
        return listaVpMaxFinalView.get(i);
    }
    
}
