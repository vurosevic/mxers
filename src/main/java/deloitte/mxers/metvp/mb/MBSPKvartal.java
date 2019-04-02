/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Meseci;
import deloitte.mxers.metvp.domen.Periodi;
import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaMesecAvg;
import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodAvg;
import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodNorm;
import deloitte.mxers.metvp.repository.PeriodiDAO;
import deloitte.mxers.metvp.service.MeseciService;
import deloitte.mxers.metvp.service.PeriodiService;
import deloitte.mxers.metvp.service.SatnaPotrosnjaMesecAvgService;
import deloitte.mxers.metvp.service.SatnaPotrosnjaPeriodAvgService;
import deloitte.mxers.metvp.service.SatnaPotrosnjaPeriodNormService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBSPKvartal")
@SessionScoped
public class MBSPKvartal {
    
    @Autowired
    private SatnaPotrosnjaMesecAvgService satnaPotrosnjaMesecAvgService;
    
    @Autowired
    private SatnaPotrosnjaPeriodAvgService satnaPotrosnjaPeriodAvgService;
    
    @Autowired
    private SatnaPotrosnjaPeriodNormService satnaPotrosnjaPeriodNormService;
    
    @Autowired 
    private PeriodiService periodiService;
    
    @Autowired
    private MeseciService meseciService;
    
    private Integer selectGodina=2006;
    
    private String selectKvartal="Q1";
    
    private List<SatnaPotrosnjaMesecAvg> listaMesecAvg;
    
    private List<SatnaPotrosnjaPeriodAvg> listaPeriodAvg;
    
    private List<SatnaPotrosnjaPeriodNorm> listaPeriodNorm;
    
    private List<String> listaKvartala;
    
    private List<Integer> listaGodina;
    
    private LineChartModel lineModel1 = null;
    private LineChartModel lineModel2 = null;

    /**
     * @return the satnaPotrosnjaMesecAvgService
     */
    public SatnaPotrosnjaMesecAvgService getSatnaPotrosnjaMesecAvgService() {
        return satnaPotrosnjaMesecAvgService;
    }

    /**
     * @param satnaPotrosnjaMesecAvgService the satnaPotrosnjaMesecAvgService to set
     */
    public void setSatnaPotrosnjaMesecAvgService(SatnaPotrosnjaMesecAvgService satnaPotrosnjaMesecAvgService) {
        this.satnaPotrosnjaMesecAvgService = satnaPotrosnjaMesecAvgService;
    }

    /**
     * @return the satnaPotrosnjaPeriodAvgService
     */
    public SatnaPotrosnjaPeriodAvgService getSatnaPotrosnjaPeriodAvgService() {
        return satnaPotrosnjaPeriodAvgService;
    }

    /**
     * @param satnaPotrosnjaPeriodAvgService the satnaPotrosnjaPeriodAvgService to set
     */
    public void setSatnaPotrosnjaPeriodAvgService(SatnaPotrosnjaPeriodAvgService satnaPotrosnjaPeriodAvgService) {
        this.satnaPotrosnjaPeriodAvgService = satnaPotrosnjaPeriodAvgService;
    }

    /**
     * @return the satnaPotrosnjaPeriodNormService
     */
    public SatnaPotrosnjaPeriodNormService getSatnaPotrosnjaPeriodNormService() {
        return satnaPotrosnjaPeriodNormService;
    }

    /**
     * @param satnaPotrosnjaPeriodNormService the satnaPotrosnjaPeriodNormService to set
     */
    public void setSatnaPotrosnjaPeriodNormService(SatnaPotrosnjaPeriodNormService satnaPotrosnjaPeriodNormService) {
        this.satnaPotrosnjaPeriodNormService = satnaPotrosnjaPeriodNormService;
    }

    /**
     * @return the selectGodina
     */
    public Integer getSelectGodina() {
        return selectGodina;
    }

    /**
     * @param selectGodina the selectGodina to set
     */
    public void setSelectGodina(Integer selectGodina) {
        this.selectGodina = selectGodina;
    }

    /**
     * @return the selectKvartal
     */
    public String getSelectKvartal() {
        return selectKvartal;
    }

    /**
     * @param selectKvartal the selectKvartal to set
     */
    public void setSelectKvartal(String selectKvartal) {
        this.selectKvartal = selectKvartal;
    }

    /**
     * @return the listaMesecAvg
     */
    public List<SatnaPotrosnjaMesecAvg> getListaMesecAvg() {
        return listaMesecAvg;
    }

    /**
     * @param listaMesecAvg the listaMesecAvg to set
     */
    public void setListaMesecAvg(List<SatnaPotrosnjaMesecAvg> listaMesecAvg) {
        this.listaMesecAvg = listaMesecAvg;
    }

    /**
     * @return the listaPeriodAvg
     */
    public List<SatnaPotrosnjaPeriodAvg> getListaPeriodAvg() {
        return listaPeriodAvg;
    }

    /**
     * @param listaPeriodAvg the listaPeriodAvg to set
     */
    public void setListaPeriodAvg(List<SatnaPotrosnjaPeriodAvg> listaPeriodAvg) {
        this.listaPeriodAvg = listaPeriodAvg;
    }

    /**
     * @return the listaPeriodNorm
     */
    public List<SatnaPotrosnjaPeriodNorm> getListaPeriodNorm() {
        return listaPeriodNorm;
    }

    /**
     * @param listaPeriodNorm the listaPeriodNorm to set
     */
    public void setListaPeriodNorm(List<SatnaPotrosnjaPeriodNorm> listaPeriodNorm) {
        this.listaPeriodNorm = listaPeriodNorm;
    }
    
    @PostConstruct
    public void init(){ 
         try {
         setListaKvartala(getPeriodiService().findAllSifraKvartal());
         setListaGodina(getSatnaPotrosnjaPeriodAvgService().findAllGodina());          
         setListaMesecAvg(getSatnaPotrosnjaMesecAvgService().findByGodinaKvartal(selectGodina, selectKvartal));
         setListaPeriodAvg(getSatnaPotrosnjaPeriodAvgService().findByGodinaPeriod(selectGodina, selectKvartal));
         setListaPeriodNorm(getSatnaPotrosnjaPeriodNormService().findByGodinaPeriod(selectGodina, selectKvartal));
         setLineModel1(initLinearModel());
         lineModel1.setTitle("Типски дијаграм за " + selectKvartal + " у апсолутним јединицама");
         lineModel1.setLegendPosition("e");
         Axis yAxis = lineModel1.getAxis(AxisType.Y);
         Axis xAxis = lineModel1.getAxis(AxisType.X);
         yAxis.setMin(800);
         yAxis.setMax(2000);
//         xAxis.setTickCount(6);
         xAxis.setMin(1);
//         xAxis.setMax(24);
         
         setLineModel2(initLinearModel2());
         lineModel2.setTitle("Типски дијаграм за " + selectKvartal + " у релативним јединицама");
         lineModel2.setLegendPosition("e");
         Axis yAxis2 = lineModel2.getAxis(AxisType.Y);
         Axis xAxis2 = lineModel2.getAxis(AxisType.X);
         yAxis2.setMin(0.8);
         yAxis2.setMax(1.8);
         xAxis2.setMin(1);         
             
         } catch (Exception ex) {
             System.out.println("Problem kod inicijalizacije. MBSPKvartal");
         }
    }     

    /**
     * @return the listaKvartala
     */
    public List<String> getListaKvartala() {
        return listaKvartala;
    }

    /**
     * @param listaKvartala the listaKvartala to set
     */
    public void setListaKvartala(List<String> listaKvartala) {
        this.listaKvartala = listaKvartala;
    }

    /**
     * @return the periodiService
     */
    public PeriodiService getPeriodiService() {
        return periodiService;
    }

    /**
     * @param periodiService the periodiService to set
     */
    public void setPeriodiService(PeriodiService periodiService) {
        this.periodiService = periodiService;
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
    
    public String getNazivMeseca(int i) {
        if (selectKvartal == null) return "";
        List<Periodi> listaPeriodi = periodiService.findBySifra(selectKvartal);
        Periodi p = listaPeriodi.get(i);
        Meseci m = meseciService.findById(p.getMesec().longValue()).get();  
        return m.getNaziv();
    }
    
    public SatnaPotrosnjaMesecAvg getMesecAvgData(int i){
        
        List<Periodi> listaPeriodi = periodiService.findBySifra(selectKvartal);
        Periodi p = listaPeriodi.get(i);
        
        for (SatnaPotrosnjaMesecAvg sm : listaMesecAvg){
            if ((p.getMesec().intValue() == sm.getMesec().intValue()) && 
                  (sm.getKvartal().equals(selectKvartal)) &&
                  (sm.getGodina().intValue() == selectGodina.intValue())){
            return sm;
            }
        }    

        return new SatnaPotrosnjaMesecAvg();
    }
    
    public SatnaPotrosnjaPeriodAvg getPeriodAvgData(){        
        for (SatnaPotrosnjaPeriodAvg sm : listaPeriodAvg){
            if ((sm.getSifraPerioda().equals(selectKvartal)) &&
                (sm.getGodina().intValue() == selectGodina.intValue())){
            return sm;
            }
        }        
        return new SatnaPotrosnjaPeriodAvg();        
        
    }
    
    public SatnaPotrosnjaPeriodNorm getPeriodNormData(){
        for (SatnaPotrosnjaPeriodNorm sm : listaPeriodNorm){
            if ((sm.getSifraPerioda().equals(selectKvartal)) &&
                (sm.getGodina().intValue() == selectGodina.intValue())){
            return sm;
            }
        }        
        return new SatnaPotrosnjaPeriodNorm();         
    }

    /**
     * @return the meseciService
     */
    public MeseciService getMeseciService() {
        return meseciService;
    }

    /**
     * @param meseciService the meseciService to set
     */
    public void setMeseciService(MeseciService meseciService) {
        this.meseciService = meseciService;
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();        
        List<Periodi> listaPeriodi = periodiService.findBySifra(selectKvartal);
        LineChartSeries series[] = new LineChartSeries[4];
        series[0] = new LineChartSeries();
        series[1] = new LineChartSeries();
        series[2] = new LineChartSeries();
        series[3] = new LineChartSeries();
        
        for (int i=0; i<3; i++) {
            series[i].set(1, getMesecAvgData(i).getOpAvg00());
            series[i].set(2, getMesecAvgData(i).getOpAvg01());
            series[i].set(3, getMesecAvgData(i).getOpAvg02());
            series[i].set(4, getMesecAvgData(i).getOpAvg03());
            series[i].set(5, getMesecAvgData(i).getOpAvg04());
            series[i].set(6, getMesecAvgData(i).getOpAvg05());
            series[i].set(7, getMesecAvgData(i).getOpAvg06());
            series[i].set(8, getMesecAvgData(i).getOpAvg07());
            series[i].set(9, getMesecAvgData(i).getOpAvg08());
            series[i].set(10, getMesecAvgData(i).getOpAvg09());
            series[i].set(11, getMesecAvgData(i).getOpAvg10());
            series[i].set(12, getMesecAvgData(i).getOpAvg11());
            series[i].set(13, getMesecAvgData(i).getOpAvg12());
            series[i].set(14, getMesecAvgData(i).getOpAvg13());
            series[i].set(15, getMesecAvgData(i).getOpAvg14());
            series[i].set(16, getMesecAvgData(i).getOpAvg15());
            series[i].set(17, getMesecAvgData(i).getOpAvg16());
            series[i].set(18, getMesecAvgData(i).getOpAvg17());
            series[i].set(19, getMesecAvgData(i).getOpAvg18());
            series[i].set(20, getMesecAvgData(i).getOpAvg19());
            series[i].set(21, getMesecAvgData(i).getOpAvg20());
            series[i].set(22, getMesecAvgData(i).getOpAvg21());
            series[i].set(23, getMesecAvgData(i).getOpAvg22());
            series[i].set(24, getMesecAvgData(i).getOpAvg23());
            Meseci m = meseciService.findById(new Long(listaPeriodi.get(i).getMesec())).get();
            series[i].setLabel(m.getNaziv());
        }
        
        series[3].set(1, getPeriodAvgData().getOpAvg00());
        series[3].set(2, getPeriodAvgData().getOpAvg01());
        series[3].set(3, getPeriodAvgData().getOpAvg02());
        series[3].set(4, getPeriodAvgData().getOpAvg03());
        series[3].set(5, getPeriodAvgData().getOpAvg04());
        series[3].set(6, getPeriodAvgData().getOpAvg05());
        series[3].set(7, getPeriodAvgData().getOpAvg06());
        series[3].set(8, getPeriodAvgData().getOpAvg07());
        series[3].set(9, getPeriodAvgData().getOpAvg08());
        series[3].set(10, getPeriodAvgData().getOpAvg09());
        series[3].set(11, getPeriodAvgData().getOpAvg10());
        series[3].set(12, getPeriodAvgData().getOpAvg11());
        series[3].set(13, getPeriodAvgData().getOpAvg12());
        series[3].set(14, getPeriodAvgData().getOpAvg13());
        series[3].set(15, getPeriodAvgData().getOpAvg14());
        series[3].set(16, getPeriodAvgData().getOpAvg15());
        series[3].set(17, getPeriodAvgData().getOpAvg16());
        series[3].set(18, getPeriodAvgData().getOpAvg17());
        series[3].set(19, getPeriodAvgData().getOpAvg18());
        series[3].set(20, getPeriodAvgData().getOpAvg19());
        series[3].set(21, getPeriodAvgData().getOpAvg20());
        series[3].set(22, getPeriodAvgData().getOpAvg21());
        series[3].set(23, getPeriodAvgData().getOpAvg22());
        series[3].set(24, getPeriodAvgData().getOpAvg23());        
                
        series[3].setLabel(selectKvartal);
 
        model.addSeries(series[0]);
        model.addSeries(series[1]);
        model.addSeries(series[2]);
        model.addSeries(series[3]);
 
        return model;
    }    

    private LineChartModel initLinearModel2() {
        LineChartModel model = new LineChartModel();        
        List<Periodi> listaPeriodi = periodiService.findBySifra(selectKvartal);
        LineChartSeries series = new LineChartSeries();
        
        series.set(1, getPeriodNormData().getOpNorm00());
        series.set(2, getPeriodNormData().getOpNorm01());
        series.set(3, getPeriodNormData().getOpNorm02());
        series.set(4, getPeriodNormData().getOpNorm03());
        series.set(5, getPeriodNormData().getOpNorm04());
        series.set(6, getPeriodNormData().getOpNorm05());
        series.set(7, getPeriodNormData().getOpNorm06());
        series.set(8, getPeriodNormData().getOpNorm07());
        series.set(9, getPeriodNormData().getOpNorm08());
        series.set(10, getPeriodNormData().getOpNorm09());
        series.set(11, getPeriodNormData().getOpNorm10());
        series.set(12, getPeriodNormData().getOpNorm11());
        series.set(13, getPeriodNormData().getOpNorm12());
        series.set(14, getPeriodNormData().getOpNorm13());
        series.set(15, getPeriodNormData().getOpNorm14());
        series.set(16, getPeriodNormData().getOpNorm15());
        series.set(17, getPeriodNormData().getOpNorm16());
        series.set(18, getPeriodNormData().getOpNorm17());
        series.set(19, getPeriodNormData().getOpNorm18());
        series.set(20, getPeriodNormData().getOpNorm19());
        series.set(21, getPeriodNormData().getOpNorm20());
        series.set(22, getPeriodNormData().getOpNorm21());
        series.set(23, getPeriodNormData().getOpNorm22());
        series.set(24, getPeriodNormData().getOpNorm23());        
                
        series.setLabel(selectKvartal);
 
        model.addSeries(series);
 
        return model;
    }    
    
    
    /**
     * @return the lineModel1
     */
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    /**
     * @param lineModel1 the lineModel1 to set
     */
    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    /**
     * @return the lineModel2
     */
    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    /**
     * @param lineModel2 the lineModel2 to set
     */
    public void setLineModel2(LineChartModel lineModel2) {
        this.lineModel2 = lineModel2;
    }
    
}
