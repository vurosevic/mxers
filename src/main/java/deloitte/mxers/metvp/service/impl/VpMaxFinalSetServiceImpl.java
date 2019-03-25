/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import deloitte.mxers.metvp.repository.VpMaxFinalSetDAO;
import deloitte.mxers.metvp.service.VpMaxFinalSetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vpMaxFinalSetService")
@Transactional
public class VpMaxFinalSetServiceImpl implements VpMaxFinalSetService {

    @Autowired 
    VpMaxFinalSetDAO vpMaxFinalSetDAO;
    
    @Override
    public List<VpMaxFinalSet> findAll() {
        return vpMaxFinalSetDAO.findAll();
    }

    @Override
    public Optional<VpMaxFinalSet> findById(Long id) {
        return vpMaxFinalSetDAO.findById(id);
    }
    
}
