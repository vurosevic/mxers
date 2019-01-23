/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.CenaPraga;
import deloitte.mxers.metvp.repository.CenePragaDAO;
import deloitte.mxers.metvp.service.CenePragaService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("cenePragaService")
@Transactional
public class CenePragaImpl implements CenePragaService {

    @Autowired
    CenePragaDAO cenePragaDAO;
    
    @Override
    public List<CenaPraga> findAll() {
        return cenePragaDAO.findAll();
    }

    @Override
    public Optional<CenaPraga> findById(Long id) {
        return cenePragaDAO.findById(id);
    }

    @Override
    public <S extends CenaPraga> S save(S s) {
        return cenePragaDAO.save(s);
    }

    @Override
    public void delete(CenaPraga t) {
        cenePragaDAO.delete(t);
    }

    @Override
    public List<CenaPraga> findByDate(Date dateCP) {
        return cenePragaDAO.findByDate(dateCP); 
    }
    
    
    
}
