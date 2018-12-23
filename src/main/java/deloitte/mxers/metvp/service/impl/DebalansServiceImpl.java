/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Debalans;
import deloitte.mxers.metvp.repository.DebalansDAO;
import deloitte.mxers.metvp.service.DebalansService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("debalansService")
@Transactional
public class DebalansServiceImpl implements DebalansService {

    @Autowired
    DebalansDAO debalansDAO;
    
    @Override
    public List<Debalans> findAll() {
        return debalansDAO.findAll();
    }

    @Override
    public Optional<Debalans> findById(Long id) {
        return debalansDAO.findById(id);
    }

    @Override
    public <S extends Debalans> S save(S s) {
        return debalansDAO.save(s);
    }

    @Override
    public void delete(Debalans t) {
        debalansDAO.delete(t); 
    }
    
}
