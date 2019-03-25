/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxUlazniSet;
import deloitte.mxers.metvp.repository.VpMaxUlazniSetDAO;
import deloitte.mxers.metvp.service.VpMaxUlazniSetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vpMaxUlazniSetService")
@Transactional
public class VpMaxUlazniSetServiceImpl implements VpMaxUlazniSetService {

    @Autowired 
    VpMaxUlazniSetDAO vpMaxUlazniSetDAO;
    
    @Override
    public List<VpMaxUlazniSet> findAll() {
        return vpMaxUlazniSetDAO.findAll();
    }

    @Override
    public Optional<VpMaxUlazniSet> findById(Long id) {
        return vpMaxUlazniSetDAO.findById(id);
    }
    
}
