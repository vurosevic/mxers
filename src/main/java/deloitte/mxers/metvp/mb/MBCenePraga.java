/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.config.TransPersistenceJPAConfig;
import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.lazyViews.LazyDataModelCenePraga;
import deloitte.mxers.metvp.service.CenePragaService;
import deloitte.mxers.metvp.service.ElektraneService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBCenePraga")
@SessionScoped
public class MBCenePraga {
    
    @Autowired
    private ElektraneService elektraneService; 
    
    private Long selectElektranaId;   
    
    @Autowired      
    private CenePragaService cenaPragaService;    
    
    @Autowired
    private DataSource dataSource;
    
    private List<CenaPraga> lista;    
    private CenaPraga selectCenaPraga;
    private CenaPraga novaCenaPraga;    
    
    private LazyDataModel<CenaPraga> lazyModel;      
    
    @PostConstruct    
    public void init(){     
         setLista(getCenaPragaService().findAll());         
         setLazyModel(new LazyDataModelCenePraga(getCenaPragaService().findAll())); 
         setNovaCenaPraga(new CenaPraga());  
         setSelectCenaPraga(null); 
         selectElektranaId = null;
    }     
    
    public ElektraneService getElektraneService() {
        return elektraneService;
    }

    public void setElektraneService(ElektraneService elektraneService) {
        this.elektraneService = elektraneService;
    }

    public Long getSelectElektranaId() {
        return selectElektranaId;
    }

    public void setSelectElektranaId(Long selectElektranaId) {
        this.selectElektranaId = selectElektranaId;
    }

    public List<CenaPraga> getLista() {
        return lista;
    }

    public void setLista(List<CenaPraga> lista) {
        this.lista = lista;
    }

    public CenaPraga getSelectCenaPraga() {
        return selectCenaPraga;
    }

    public void setSelectCenaPraga(CenaPraga selectCenaPraga) {
        this.selectCenaPraga = selectCenaPraga;
    }

    public CenaPraga getNovaCenaPraga() {
        return novaCenaPraga;
    }

    public void setNovaCenaPraga(CenaPraga novaCenaPraga) {
        this.novaCenaPraga = novaCenaPraga;
    }

    public LazyDataModel<CenaPraga> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<CenaPraga> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public CenePragaService getCenaPragaService() {
        return cenaPragaService;
    }

    public void setCenaPragaService(CenePragaService cenaPragaService) {
        this.cenaPragaService = cenaPragaService;
    }

    public void dodajNovuCenuPraga(){
        novaCenaPraga.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());  
        cenaPragaService.save(novaCenaPraga);
        init();
    }
    
    public void azurirajCenuPraga() {
        if (getSelectElektranaId() != null)
        selectCenaPraga.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());   
        
        cenaPragaService.save(selectCenaPraga);
        selectElektranaId = null; 
    }
    
    public void brisiCenuPraga() {        
        cenaPragaService.delete(selectCenaPraga);
        init();
    }
    
    public void cenePragaReportPDF(ActionEvent actionEvent) throws JRException, IOException, SQLException{
        //String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/cenepraga.jrxml");
        String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/cenepraga.jasper");        
//        ArrayList<PromenaSnabdevaca> ps = new ArrayList<>();
//        ps.add(selectPromenaSnabdevaca);
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ps);
        ////JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile); 
        ////JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        //JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, new HashMap(), beanCollectionDataSource);  
        
        JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(jrxmlFile);
        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource.getConnection());
        
        //
        
        HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=cene.pdf");       
        FacesContext.getCurrentInstance().responseComplete();
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
        FacesContext.getCurrentInstance().responseComplete();                  
    }     
      
}
