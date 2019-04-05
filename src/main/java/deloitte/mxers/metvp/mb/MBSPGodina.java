/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodAvg;
import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodNorm;
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
@Component("MBSPGodina")
@SessionScoped
public class MBSPGodina {
    
    @Autowired
    private SatnaPotrosnjaPeriodAvgService satnaPotrosnjaPeriodAvgService;
    
    @Autowired
    private SatnaPotrosnjaPeriodNormService satnaPotrosnjaPeriodNormService;    
    
    private Integer selectGodina=2006;
    
    private String selectPeriod="YR";
    
    private List<SatnaPotrosnjaPeriodAvg> listaPeriodAvg;
    
    private List<SatnaPotrosnjaPeriodNorm> listaPeriodNorm;
       
    private List<Integer> listaGodina;
    
    private LineChartModel lineModel1 = null;
    private LineChartModel lineModel2 = null;    

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
     * @return the selectPeriod
     */
    public String getSelectPeriod() {
        return selectPeriod;
    }

    /**
     * @param selectPeriod the selectPeriod to set
     */
    public void setSelectPeriod(String selectPeriod) {
        this.selectPeriod = selectPeriod;
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
    
public SatnaPotrosnjaPeriodAvg getPeriodAvgData(int i){   
    SatnaPotrosnjaPeriodAvg sm = listaPeriodAvg.get(i);
    return sm;    
    }
    
    public SatnaPotrosnjaPeriodNorm getPeriodNormData(){
        for (SatnaPotrosnjaPeriodNorm sm : listaPeriodNorm){
            if ((sm.getSifraPerioda().equals(selectPeriod)) &&
                (sm.getGodina().intValue() == selectGodina.intValue())){
            return sm;
            }
        }        
        return new SatnaPotrosnjaPeriodNorm();         
    }
    
    @PostConstruct
    public void init(){ 
         try {
         setListaGodina(getSatnaPotrosnjaPeriodAvgService().findAllGodina());          
         setListaPeriodAvg(getSatnaPotrosnjaPeriodAvgService().findByGodina(selectGodina));
         setListaPeriodNorm(getSatnaPotrosnjaPeriodNormService().findByGodinaPeriod(selectGodina, selectPeriod));
         setLineModel1(initLinearModel());
         lineModel1.setTitle("Типски дијаграм за " + selectPeriod + " у апсолутним јединицама");
         lineModel1.setLegendPosition("e");
         Axis yAxis = lineModel1.getAxis(AxisType.Y);
         Axis xAxis = lineModel1.getAxis(AxisType.X);
         yAxis.setMin(800);
         yAxis.setMax(2000);
//         xAxis.setTickCount(6);
         xAxis.setMin(1);
//         xAxis.setMax(24);
         
         setLineModel2(initLinearModel2());
         lineModel2.setTitle("Типски дијаграм за " + selectPeriod + " у релативним јединицама");
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

private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();        
        LineChartSeries series[] = new LineChartSeries[5];
        series[0] = new LineChartSeries();
        series[1] = new LineChartSeries();
        series[2] = new LineChartSeries();
        series[3] = new LineChartSeries();
        series[4] = new LineChartSeries();
//        series[5] = new LineChartSeries();
        
        for (int i=0; i<5; i++) {
            series[i].set(1, getPeriodAvgData(i).getOpAvg00());
            series[i].set(2, getPeriodAvgData(i).getOpAvg01());
            series[i].set(3, getPeriodAvgData(i).getOpAvg02());
            series[i].set(4, getPeriodAvgData(i).getOpAvg03());
            series[i].set(5, getPeriodAvgData(i).getOpAvg04());
            series[i].set(6, getPeriodAvgData(i).getOpAvg05());
            series[i].set(7, getPeriodAvgData(i).getOpAvg06());
            series[i].set(8, getPeriodAvgData(i).getOpAvg07());
            series[i].set(9, getPeriodAvgData(i).getOpAvg08());
            series[i].set(10, getPeriodAvgData(i).getOpAvg09());
            series[i].set(11, getPeriodAvgData(i).getOpAvg10());
            series[i].set(12, getPeriodAvgData(i).getOpAvg11());
            series[i].set(13, getPeriodAvgData(i).getOpAvg12());
            series[i].set(14, getPeriodAvgData(i).getOpAvg13());
            series[i].set(15, getPeriodAvgData(i).getOpAvg14());
            series[i].set(16, getPeriodAvgData(i).getOpAvg15());
            series[i].set(17, getPeriodAvgData(i).getOpAvg16());
            series[i].set(18, getPeriodAvgData(i).getOpAvg17());
            series[i].set(19, getPeriodAvgData(i).getOpAvg18());
            series[i].set(20, getPeriodAvgData(i).getOpAvg19());
            series[i].set(21, getPeriodAvgData(i).getOpAvg20());
            series[i].set(22, getPeriodAvgData(i).getOpAvg21());
            series[i].set(23, getPeriodAvgData(i).getOpAvg22());
            series[i].set(24, getPeriodAvgData(i).getOpAvg23());
            series[i].setLabel(getPeriodAvgData(i).getSifraPerioda());
        }
        
//        series[5].set(1, getPeriodNormData().getOpNorm00());
//        series[5].set(2, getPeriodNormData().getOpNorm01());
//        series[5].set(3, getPeriodNormData().getOpNorm02());
//        series[5].set(4, getPeriodNormData().getOpNorm03());
//        series[5].set(5, getPeriodNormData().getOpNorm04());
//        series[5].set(6, getPeriodNormData().getOpNorm05());
//        series[5].set(7, getPeriodNormData().getOpNorm06());
//        series[5].set(8, getPeriodNormData().getOpNorm07());
//        series[5].set(9, getPeriodNormData().getOpNorm08());
//        series[5].set(10, getPeriodNormData().getOpNorm09());
//        series[5].set(11, getPeriodNormData().getOpNorm10());
//        series[5].set(12, getPeriodNormData().getOpNorm11());
//        series[5].set(13, getPeriodNormData().getOpNorm12());
//        series[5].set(14, getPeriodNormData().getOpNorm13());
//        series[5].set(15, getPeriodNormData().getOpNorm14());
//        series[5].set(16, getPeriodNormData().getOpNorm15());
//        series[5].set(17, getPeriodNormData().getOpNorm16());
//        series[5].set(18, getPeriodNormData().getOpNorm17());
//        series[5].set(19, getPeriodNormData().getOpNorm18());
//        series[5].set(20, getPeriodNormData().getOpNorm19());
//        series[5].set(21, getPeriodNormData().getOpNorm20());
//        series[5].set(22, getPeriodNormData().getOpNorm21());
//        series[5].set(23, getPeriodNormData().getOpNorm22());
//        series[5].set(24, getPeriodNormData().getOpNorm23());        
//                
//        series[5].setLabel(selectPeriod);
 
        model.addSeries(series[0]);
        model.addSeries(series[1]);
        model.addSeries(series[2]);
        model.addSeries(series[3]);
        model.addSeries(series[4]);
//        model.addSeries(series[5]);
 
        return model;
    }

    private LineChartModel initLinearModel2() {
        LineChartModel model = new LineChartModel();        
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
                
        series.setLabel(selectPeriod);
 
        model.addSeries(series);
 
        return model;
    }  
    
}
