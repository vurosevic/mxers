/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodAvg;
import deloitte.mxers.metvp.repository.SatnaPotrosnjaPeriodAvgDAO;
import deloitte.mxers.metvp.service.SatnaPotrosnjaPeriodAvgService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("satnaPotrosnjaPeriodAvgService")
@Transactional
public class SatnaPotrosnjaPeriodAvgServiceImpl implements SatnaPotrosnjaPeriodAvgService {

    @Autowired
    SatnaPotrosnjaPeriodAvgDAO satnaPotrosnjaPeriodAvgDAO;
    
    @Override
    public List<SatnaPotrosnjaPeriodAvg> findAll() {
        return satnaPotrosnjaPeriodAvgDAO.findAll();
    }

    @Override
    public Optional<SatnaPotrosnjaPeriodAvg> findById(Long id) {
        return satnaPotrosnjaPeriodAvgDAO.findById(id);
    }

    @Override
    public List<Integer> findAllGodina() {
        return satnaPotrosnjaPeriodAvgDAO.findAllGodina();
    }

    @Override
    public List<SatnaPotrosnjaPeriodAvg> findByGodinaPeriod(Integer godina, String sifraPerioda) {
        return satnaPotrosnjaPeriodAvgDAO.findByGodinaPeriod(godina, sifraPerioda);
    }        
}
