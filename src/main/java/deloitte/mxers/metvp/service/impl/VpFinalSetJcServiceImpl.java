/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetJc;
import deloitte.mxers.metvp.repository.VpFinalSetJcDAO;
import deloitte.mxers.metvp.service.VpFinalSetJcService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vpFinalSetJcService")
@Transactional
public class VpFinalSetJcServiceImpl implements VpFinalSetJcService{

    @Autowired
    VpFinalSetJcDAO vpFinalSetJcDAO;
    
    @Override
    public List<VpFinalSetJc> findAll() {
        return vpFinalSetJcDAO.findAll();
    }

    @Override
    public Optional<VpFinalSetJc> findById(Long id) {
        return vpFinalSetJcDAO.findById(id);
    }

    @Override
    public List<VpFinalSetJc> findByPeriod(String period) {
        return vpFinalSetJcDAO.findByPeriod(period); 
    }
    
}
