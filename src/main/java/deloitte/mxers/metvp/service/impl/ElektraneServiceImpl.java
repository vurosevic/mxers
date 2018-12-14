/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Elektrana;
import deloitte.mxers.metvp.repository.ElektraneDAO;
import deloitte.mxers.metvp.service.ElektraneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("elektraneService")
@Transactional
public class ElektraneServiceImpl implements ElektraneService {

    @Autowired
    ElektraneDAO elektraneDAO;
    
    
    @Override
    public List<Elektrana> findAll() {
        return elektraneDAO.findAll();
    }

    @Override
    public Optional<Elektrana> findById(Long id) {
        return elektraneDAO.findById(id);
    }

    @Override
    public <S extends Elektrana> S save(S s) {
        return elektraneDAO.save(s);
    }

    @Override
    public void delete(Elektrana t) {
        elektraneDAO.delete(t); 
    }
    
    
    
}
