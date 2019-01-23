/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.lazyViews;

import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Vladimir
 */
public class LazyDataModelTroskoviPGK extends LazyDataModel<TrosakPrekogranicnihKapaciteta>{
    
    private List<TrosakPrekogranicnihKapaciteta> datasource;

    public LazyDataModelTroskoviPGK(List<TrosakPrekogranicnihKapaciteta> datasource) {
        this.datasource = datasource;
    }

    @Override
    public TrosakPrekogranicnihKapaciteta getRowData(String rowKey) {
        for(TrosakPrekogranicnihKapaciteta gz : datasource) {
            if(gz.getId().toString().equals(rowKey))
                return gz;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(TrosakPrekogranicnihKapaciteta object) {
        return object.getId();
    }    
        
    @Override
    public List<TrosakPrekogranicnihKapaciteta> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<TrosakPrekogranicnihKapaciteta> data = new ArrayList<TrosakPrekogranicnihKapaciteta>();
   //filter
        for(TrosakPrekogranicnihKapaciteta gz : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(gz.getClass().getField(filterProperty).get(gz));
 
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
                data.add(gz);
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
