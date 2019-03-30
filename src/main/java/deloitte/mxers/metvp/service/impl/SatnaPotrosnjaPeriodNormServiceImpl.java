/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodNorm;
import deloitte.mxers.metvp.repository.SatnaPotrosnjaPeriodNormDAO;
import deloitte.mxers.metvp.service.SatnaPotrosnjaPeriodNormService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("satnaPotrosnjaPeriodNormService")
@Transactional
public class SatnaPotrosnjaPeriodNormServiceImpl implements SatnaPotrosnjaPeriodNormService {

    @Autowired
    SatnaPotrosnjaPeriodNormDAO satnaPotrosnjaPeriodNormDAO;
    
    @Override
    public List<SatnaPotrosnjaPeriodNorm> findAll() {
        return satnaPotrosnjaPeriodNormDAO.findAll();
    }

    @Override
    public Optional<SatnaPotrosnjaPeriodNorm> findById(Long id) {
        return satnaPotrosnjaPeriodNormDAO.findById(id);
    }
    
}
