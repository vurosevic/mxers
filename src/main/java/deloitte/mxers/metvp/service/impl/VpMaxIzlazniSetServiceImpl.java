/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import deloitte.mxers.metvp.domen.viewclasses.VpMaxIzlazniSet;
import deloitte.mxers.metvp.repository.VpMaxIzlazniSetDAO;
import deloitte.mxers.metvp.service.VpMaxIzlazniSetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vpMaxIzlazniSetService")
@Transactional
public class VpMaxIzlazniSetServiceImpl implements VpMaxIzlazniSetService {

    @Autowired
    VpMaxIzlazniSetDAO vpMaxIzlazniSetDAO;
    
    @Override
    public List<VpMaxIzlazniSet> findAll() {
        return vpMaxIzlazniSetDAO.findAll();
    }

    @Override
    public Optional<VpMaxIzlazniSet> findById(Long id) {
        return vpMaxIzlazniSetDAO.findById(id);
    }
    
}
