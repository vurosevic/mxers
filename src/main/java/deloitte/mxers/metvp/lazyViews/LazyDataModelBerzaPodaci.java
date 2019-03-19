/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.lazyViews;

import deloitte.mxers.metvp.domen.Berza;
import deloitte.mxers.metvp.domen.BerzaPodaci;
import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Vladimir
 */
public class LazyDataModelBerzaPodaci extends LazyDataModel<BerzaPodaci>{
    
    private List<BerzaPodaci> datasource;

    public LazyDataModelBerzaPodaci(List<BerzaPodaci> datasource) {
        this.datasource = datasource;
    }

    @Override
    public BerzaPodaci getRowData(String rowKey) {
        for(BerzaPodaci gz : datasource) {
            if(gz.getId().toString().equals(rowKey))
                return gz;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(BerzaPodaci object) {
        return object.getId();
    }    
        
    @Override
    public List<BerzaPodaci> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<BerzaPodaci> data = new ArrayList<BerzaPodaci>();
   //filter
        for(BerzaPodaci ps : datasource) {
            boolean match = true;
      
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        String filterProperty2 = "";
                        Object filterValue = filters.get(filterProperty);
                        
                           Field field;
                           Field field2;
                           String fieldValue;                      

                           if (filterProperty.indexOf('\'') > 0) {
                            //atribut izvedene klase, uzmi naziv atributa
                            filterProperty = filterProperty.substring(filterProperty.indexOf("'") + 1, filterProperty.indexOf("']"));
                           }
                           
                           if (filterProperty.indexOf('.') > 0) {
                            // postoji slozen atribut
                             filterProperty2 = filterProperty.substring(filterProperty.indexOf(".") + 1, filterProperty.length());  
                             filterProperty = filterProperty.substring(0, filterProperty.indexOf("."));  
                           }

                           try {
                               field = BerzaPodaci.class.getDeclaredField(filterProperty);      
                           } catch (java.lang.NoSuchFieldException ex) {
                               field = BerzaPodaci.class.getDeclaredField(filterProperty);      
                           }
                            field.setAccessible(true);
                            
                            if (field.getType()==java.util.Date.class){
                               Date tmp = (Date)(field.get(ps));
                               SimpleDateFormat sdt = new SimpleDateFormat("dd.MM.yyyy");
                               sdt.setTimeZone(TimeZone.getTimeZone("Europe/Belgrade"));
                               Format formatter = sdt;
                               fieldValue = formatter.format(tmp);
                            } else if (field.getType()== deloitte.mxers.metvp.domen.Berza.class) {
                                field2 = Berza.class.getDeclaredField(filterProperty2);      
                                field2.setAccessible(true);
                                fieldValue = String.valueOf(field2.get(((Berza)(ps.getBerza()))));       
                            } 
                            else                     
                            fieldValue = String.valueOf(field.get(ps));   
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(ps);
            }
        }
 
//        //sort
//        if(sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }           
    }    
    
     
    
}
