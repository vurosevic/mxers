/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.mb;

import deloitte.mxers.metvp.domen.Bilans;
import deloitte.mxers.metvp.lazyViews.LazyDataModelBilans;
import deloitte.mxers.metvp.service.BilansService;
import deloitte.mxers.metvp.service.ElektraneService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBBilans")
@SessionScoped
public class MBBilans {
    
    @Autowired
    private ElektraneService elektraneService;     
    
    private Long selectElektranaId;   
    
    @Autowired      
    private BilansService bilansService;
    
    @Autowired
    private DataSource dataSource;    
    
    private List<Bilans> lista;    
    private Bilans selectBilans;
    private Bilans noviBilans;    
    
    private LazyDataModel<Bilans> lazyModel;       

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

    public BilansService getBilansService() {
        return bilansService;
    }

    public void setBilansService(BilansService bilansService) {
        this.bilansService = bilansService;
    }

    public List<Bilans> getLista() {
        return lista;
    }

    public void setLista(List<Bilans> lista) {
        this.lista = lista;
    }

    public Bilans getSelectBilans() {
        return selectBilans;
    }

    public void setSelectBilans(Bilans selectBilans) {
        this.selectBilans = selectBilans;
    }

    public Bilans getNoviBilans() {
        return noviBilans;
    }

    public void setNoviBilans(Bilans noviBilans) {
        this.noviBilans = noviBilans;
    }

    public LazyDataModel<Bilans> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Bilans> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    @PostConstruct    
    public void init(){     
         setLista(getBilansService().findAll());         
         setLazyModel(new LazyDataModelBilans(getBilansService().findAll())); 
         setNoviBilans(new Bilans());  
         setSelectBilans(null); 
         selectElektranaId = null;
    }  

    public void dodajNoviBilans(){
        noviBilans.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());  
        bilansService.save(noviBilans);
        init();
    }
    
    public void azurirajBilans() {
        if (getSelectElektranaId() != null)
        selectBilans.setElektrana(getElektraneService().findById(getSelectElektranaId()).get());   
        
        bilansService.save(selectBilans);         
        selectElektranaId = null; 
    }
    
    public void brisiBilans() {        
        bilansService.delete(selectBilans);
        init();
    }    
 
    public void bilansReportPDF(ActionEvent actionEvent) throws JRException, IOException, SQLException{
        String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/bilans.jasper");
        JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(jrxmlFile);
        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource.getConnection());

        HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=bilans.pdf");       
        FacesContext.getCurrentInstance().responseComplete();
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
        FacesContext.getCurrentInstance().responseComplete();                  
    }     
    
}
