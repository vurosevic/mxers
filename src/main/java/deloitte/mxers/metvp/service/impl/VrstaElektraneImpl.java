/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.VrstaElektrane;
import deloitte.mxers.metvp.repository.VrstaElektraneDAO;
import deloitte.mxers.metvp.service.VrstaElektraneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("vrstaElektraneService")
@Transactional
public class VrstaElektraneImpl implements VrstaElektraneService {

    @Autowired 
    VrstaElektraneDAO vrstaElektraneDAO;
    
    @Override
    public List<VrstaElektrane> findAll() {
        return vrstaElektraneDAO.findAll();
    }

    @Override
    public Optional<VrstaElektrane> findById(Long id) {
        return vrstaElektraneDAO.findById(id);
    }

    @Override
    public <S extends VrstaElektrane> S save(S s) {
        return vrstaElektraneDAO.save(s);
    }

    @Override
    public void delete(VrstaElektrane t) {
        vrstaElektraneDAO.delete(t); 
    }
    
    
    
}
