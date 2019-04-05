/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetGodinaJc;
import deloitte.mxers.metvp.repository.VpFinalSetGodinaJcDAO;
import deloitte.mxers.metvp.service.VpFinalSetGodinaJcService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vpFinalSetGodinaJcService")
@Transactional
public class VpFinalSetGodinaJcServiceImpl implements VpFinalSetGodinaJcService{

    @Autowired
    VpFinalSetGodinaJcDAO vpFinalSetGodinaJcDAO;
    
    @Override
    public List<VpFinalSetGodinaJc> findAll() {
        return vpFinalSetGodinaJcDAO.findAll();
    }

    @Override
    public Optional<VpFinalSetGodinaJc> findById(Long id) {
        return vpFinalSetGodinaJcDAO.findById(id);
    }

    @Override
    public List<VpFinalSetGodinaJc> findByPeriod(String period) {
        return vpFinalSetGodinaJcDAO.findByPeriod(period);
    }
    
}
