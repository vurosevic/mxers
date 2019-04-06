/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.KonkurencijaCene;
import deloitte.mxers.metvp.repository.KonkurencijaCeneDAO;
import deloitte.mxers.metvp.service.KonkurencijaCeneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("konkurencijaCeneService")
@Transactional
public class KonkurencijaCeneServiceImpl implements KonkurencijaCeneService{

    @Autowired
    KonkurencijaCeneDAO konkurencijaCeneDAO;
    
    @Override
    public List<KonkurencijaCene> findAll() {
        return konkurencijaCeneDAO.findAll();
    }

    @Override
    public Optional<KonkurencijaCene> findById(Long id) {
        return konkurencijaCeneDAO.findById(id);
    }

    @Override
    public <S extends KonkurencijaCene> S save(S s) {
        return konkurencijaCeneDAO.save(s);
    }

    @Override
    public void delete(KonkurencijaCene t) {
        konkurencijaCeneDAO.delete(t);
    }

    @Override
    public List<KonkurencijaCene> findByProizvod(String period, String godinaPerioda) {
        return konkurencijaCeneDAO.findByProizvod(period, godinaPerioda);
    }

    @Override
    public Double minCenaByProizvod(String period, String godinaPerioda) {
        return konkurencijaCeneDAO.minCenaByProizvod(period, godinaPerioda);
    }
    
    
    
}
