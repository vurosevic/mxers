/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Periodi;
import deloitte.mxers.metvp.repository.PeriodiDAO;
import deloitte.mxers.metvp.service.PeriodiService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("periodiService") 
@Transactional
public class PeriodiServiceImpl implements PeriodiService {

    @Autowired
    PeriodiDAO periodiDAO;
    
    @Override
    public Optional<Periodi> findById(Long id) {
        return periodiDAO.findById(id);
    }

    @Override
    public List<Periodi> findAll() {
        return periodiDAO.findAll();
    }

    @Override
    public void deleteById(Long id) {
        periodiDAO.deleteById(id);
    }

    @Override
    public <S extends Periodi> S save(S s) {
        return periodiDAO.save(s);
    }

    @Override
    public List<Periodi> findBySifra(String sifraPerioda) {
        return periodiDAO.findBySifra(sifraPerioda);
    }

    @Override
    public List<String> findAllSifra() {
        return periodiDAO.findAllSifra();
    }

    @Override
    public List<String> findAllSifraKvartal() {
        return periodiDAO.findAllSifraKvartal();
    }
    
    
    
}
