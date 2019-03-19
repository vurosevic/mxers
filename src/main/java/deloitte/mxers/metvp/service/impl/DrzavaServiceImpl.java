/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Drzava;
import deloitte.mxers.metvp.repository.DrzavaDAO;
import deloitte.mxers.metvp.service.DrzavaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("drzavaService")
@Transactional
public class DrzavaServiceImpl implements DrzavaService {

    @Autowired
    DrzavaDAO drzavaDAO;
    
    @Override
    public List<Drzava> findAll() {
        return drzavaDAO.findAll();
    }

    @Override
    public Optional<Drzava> findById(Long id) {
        return drzavaDAO.findById(id);
    }

    @Override
    public <S extends Drzava> S save(S s) {
        return drzavaDAO.save(s);
    }

    @Override
    public void delete(Drzava t) {
        drzavaDAO.delete(t);
    }
    
}
