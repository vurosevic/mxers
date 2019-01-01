/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Bilans;
import deloitte.mxers.metvp.repository.BilansDAO;
import deloitte.mxers.metvp.service.BilansService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("bilansService")
@Transactional
public class BilansServiceImpl implements BilansService {

    @Autowired
    BilansDAO bilansDAO;
    
    @Override
    public List<Bilans> findAll() {
        return bilansDAO.findAll();
    }

    @Override
    public Optional<Bilans> findById(Long id) {
        return bilansDAO.findById(id);
    }

    @Override
    public <S extends Bilans> S save(S s) {
        return bilansDAO.save(s);
    }

    @Override
    public void delete(Bilans t) {
        bilansDAO.delete(t); 
    }
    
    public Double ukupnoOstvarenoPoGodini(Integer godina) {
        return bilansDAO.ukupnoOstvarenoPoGodini(godina);
    }
}
