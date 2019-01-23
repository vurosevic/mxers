/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.test;

import deloitte.mxers.metvp.config.TransPersistenceJPAConfig;
import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.service.CenePragaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component
@ComponentScan(basePackages = {"deloitte.mxers.metvp", "deloitte.mxers.metvp.repository",
"deloitte.mxers.metvp.service","deloitte.mxers.metvp.service.impl","deloitte.mxers.metvp.domen","deloitte.mxers.metvp.config",
"deloitte.mxers.metvp.mb"})
public class MainTest {
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TransPersistenceJPAConfig.class);
        MainTest main = (MainTest) context.getBean(MainTest.class);
        
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        dateformat.setTimeZone(TimeZone.getTimeZone("CET")); 
        
        Date datum = new Date();
        try {
            datum = dateformat.parse("01.01.2016");
        } catch (ParseException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        main.findByDate(datum); 
                        
        System.out.println("Kraj...");                        
    }
    
    @Autowired
    private CenePragaService cenePragaService;    
    
    private void findByDate(Date dateCP) {                
        List<CenaPraga> ceneP = cenePragaService.findByDate(dateCP);        
        for (CenaPraga cp : ceneP) {
            System.out.println(cp);
        }
    }
    
}

