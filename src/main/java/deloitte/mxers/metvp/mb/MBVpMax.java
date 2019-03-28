/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import deloitte.mxers.metvp.domen.viewclasses.VpMaxIzlazniSet;
import deloitte.mxers.metvp.domen.viewclasses.VpMaxUlazniSet;
import deloitte.mxers.metvp.service.VpMaxFinalSetService;
import deloitte.mxers.metvp.service.VpMaxIzlazniSetService;
import deloitte.mxers.metvp.service.VpMaxUlazniSetService;
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
    
    @Autowired
    private VpMaxIzlazniSetService vpMaxIzlazniSetService;
 
    @Autowired
    private VpMaxUlazniSetService vpMaxUlazniSetService;
    
    private List<VpMaxFinalSet> listaVpMaxFinal;
    private List<VpMaxFinalSet> listaVpMaxFinalView;
    
    private List<VpMaxIzlazniSet> listaVpMaxIzlazni;
    private List<VpMaxIzlazniSet> listaVpMaxIzlazniView;   
    
    private List<VpMaxUlazniSet> listaVpMaxUlazni;
    private List<VpMaxUlazniSet> listaVpMaxUlazniView;  

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
         setListaVpMaxIzlazni(getVpMaxIzlazniSetService().findAll()); 
         setListaVpMaxIzlazniView(getDataForIzlazniSet());
         setListaVpMaxUlazni(getVpMaxUlazniSetService().findAll());
         setListaVpMaxUlazniView(getDataForUlazniSet());
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

    private List<VpMaxIzlazniSet> getDataForIzlazniSet(){
        List<VpMaxIzlazniSet> res = new ArrayList<VpMaxIzlazniSet>();
        Integer broj = listaVpMaxIzlazni.size();
        
        // uzmi prva 4 kvartala za BL
        res.add(listaVpMaxIzlazni.get(0));
        res.add(listaVpMaxIzlazni.get(1));
        res.add(listaVpMaxIzlazni.get(2));
        res.add(listaVpMaxIzlazni.get(3));
        
        // uzmi prvu godinu za BL
        for (VpMaxIzlazniSet v : listaVpMaxIzlazni){
            if ((v.getPeriod().equals("YR")) && (v.getVrstaOpterecenja().equals("BL"))){
            res.add(v);
            break;
            }
        }
 
        // uzmi prva 4 kvartala za PL
        res.add(listaVpMaxIzlazni.get((broj/2) + 0));
        res.add(listaVpMaxIzlazni.get((broj/2) + 1));
        res.add(listaVpMaxIzlazni.get((broj/2) + 2));
        res.add(listaVpMaxIzlazni.get((broj/2) + 3));        
        
        // uzmi prvu godinu za PL
        
        for (VpMaxIzlazniSet v : listaVpMaxIzlazni){
            if ((v.getPeriod().equals("YR")) && (v.getVrstaOpterecenja().equals("PL"))){
            res.add(v);
            break;
            }
        }        
        return res;
    }    
    
    private List<VpMaxUlazniSet> getDataForUlazniSet(){
        List<VpMaxUlazniSet> res = new ArrayList<VpMaxUlazniSet>();
        Integer broj = listaVpMaxUlazni.size();
        
        // uzmi prva 4 kvartala za BL
        res.add(listaVpMaxUlazni.get(0));
        res.add(listaVpMaxUlazni.get(1));
        res.add(listaVpMaxUlazni.get(2));
        res.add(listaVpMaxUlazni.get(3));
        
        // uzmi prvu godinu za BL
        for(VpMaxUlazniSet v : listaVpMaxUlazni){
            if ((v.getPeriod().equals("YR")) && (v.getVrstaOpterecenja().equals("BL"))){
            res.add(v);
            break;
            }
        }
 
        // uzmi prva 4 kvartala za PL
        res.add(listaVpMaxUlazni.get((broj/2) + 0));
        res.add(listaVpMaxUlazni.get((broj/2) + 1));
        res.add(listaVpMaxUlazni.get((broj/2) + 2));
        res.add(listaVpMaxUlazni.get((broj/2) + 3));        
        
        // uzmi prvu godinu za PL
        
        for (VpMaxUlazniSet v : listaVpMaxUlazni){
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
    
    public VpMaxIzlazniSet getIzlazniSetData(int i){
        return listaVpMaxIzlazniView.get(i);
    }

    public VpMaxUlazniSet getUlazniSetData(int i){
        return listaVpMaxUlazniView.get(i);
    }    

    /**
     * @return the vpMaxIzlazniSetService
     */
    public VpMaxIzlazniSetService getVpMaxIzlazniSetService() {
        return vpMaxIzlazniSetService;
    }

    /**
     * @param vpMaxIzlazniSetService the vpMaxIzlazniSetService to set
     */
    public void setVpMaxIzlazniSetService(VpMaxIzlazniSetService vpMaxIzlazniSetService) {
        this.vpMaxIzlazniSetService = vpMaxIzlazniSetService;
    }

    /**
     * @return the vpMaxUlazniSetService
     */
    public VpMaxUlazniSetService getVpMaxUlazniSetService() {
        return vpMaxUlazniSetService;
    }

    /**
     * @param vpMaxUlazniSetService the vpMaxUlazniSetService to set
     */
    public void setVpMaxUlazniSetService(VpMaxUlazniSetService vpMaxUlazniSetService) {
        this.vpMaxUlazniSetService = vpMaxUlazniSetService;
    }

    /**
     * @return the listaVpMaxIzlazni
     */
    public List<VpMaxIzlazniSet> getListaVpMaxIzlazni() {
        return listaVpMaxIzlazni;
    }

    /**
     * @param listaVpMaxIzlazni the listaVpMaxIzlazni to set
     */
    public void setListaVpMaxIzlazni(List<VpMaxIzlazniSet> listaVpMaxIzlazni) {
        this.listaVpMaxIzlazni = listaVpMaxIzlazni;
    }

    /**
     * @return the listaVpMaxIzlazniView
     */
    public List<VpMaxIzlazniSet> getListaVpMaxIzlazniView() {
        return listaVpMaxIzlazniView;
    }

    /**
     * @param listaVpMaxIzlazniView the listaVpMaxIzlazniView to set
     */
    public void setListaVpMaxIzlazniView(List<VpMaxIzlazniSet> listaVpMaxIzlazniView) {
        this.listaVpMaxIzlazniView = listaVpMaxIzlazniView;
    }

    /**
     * @return the listaVpMaxUlazni
     */
    public List<VpMaxUlazniSet> getListaVpMaxUlazni() {
        return listaVpMaxUlazni;
    }

    /**
     * @param listaVpMaxUlazni the listaVpMaxUlazni to set
     */
    public void setListaVpMaxUlazni(List<VpMaxUlazniSet> listaVpMaxUlazni) {
        this.listaVpMaxUlazni = listaVpMaxUlazni;
    }

    /**
     * @return the listaVpMaxUlazniView
     */
    public List<VpMaxUlazniSet> getListaVpMaxUlazniView() {
        return listaVpMaxUlazniView;
    }

    /**
     * @param listaVpMaxUlazniView the listaVpMaxUlazniView to set
     */
    public void setListaVpMaxUlazniView(List<VpMaxUlazniSet> listaVpMaxUlazniView) {
        this.listaVpMaxUlazniView = listaVpMaxUlazniView;
    }
    
}
