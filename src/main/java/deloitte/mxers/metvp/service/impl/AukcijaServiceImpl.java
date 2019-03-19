/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Aukcija;
import deloitte.mxers.metvp.repository.AukcijaDAO;
import deloitte.mxers.metvp.service.AukcijaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("aukcijaService")
@Transactional
public class AukcijaServiceImpl implements AukcijaService {

    @Autowired
    AukcijaDAO aukcijaDAO;
    
    @Override
    public List<Aukcija> findAll() {
        return aukcijaDAO.findAll();
    }

    @Override
    public Optional<Aukcija> findById(Long id) {
        return aukcijaDAO.findById(id);
    }

    @Override
    public <S extends Aukcija> S save(S s) {
        return aukcijaDAO.save(s);
    }

    @Override
    public void delete(Aukcija t) {
        aukcijaDAO.delete(t);
    }
    
}
