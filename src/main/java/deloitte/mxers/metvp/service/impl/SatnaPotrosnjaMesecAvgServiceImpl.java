/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaMesecAvg;
import deloitte.mxers.metvp.repository.SatnaPotrosnjaMesecAvgDAO;
import deloitte.mxers.metvp.service.SatnaPotrosnjaMesecAvgService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("satnaPotrosnjaMesecAvgService")
@Transactional
public class SatnaPotrosnjaMesecAvgServiceImpl implements SatnaPotrosnjaMesecAvgService {

    @Autowired
    SatnaPotrosnjaMesecAvgDAO satnaPotrosnjaMesecAvgDAO;
    
    @Override
    public List<SatnaPotrosnjaMesecAvg> findAll() {
        return satnaPotrosnjaMesecAvgDAO.findAll();
    }

    @Override
    public Optional<SatnaPotrosnjaMesecAvg> findById(Long id) {
        return satnaPotrosnjaMesecAvgDAO.findById(id);
    }

    @Override
    public List<SatnaPotrosnjaMesecAvg> findByGodinaKvartal(Integer godina, String kvartal) {
        return satnaPotrosnjaMesecAvgDAO.findByGodinaKvartal(godina, kvartal);
    }
    
    
    
}
