/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodAvg;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface SatnaPotrosnjaPeriodAvgService {
    
    public List<SatnaPotrosnjaPeriodAvg> findAll();
    public Optional<SatnaPotrosnjaPeriodAvg> findById(Long id);    
    public List<SatnaPotrosnjaPeriodAvg> findByGodinaPeriod(Integer godina, String sifraPerioda); 
    public List<Integer> findAllGodina();
}
