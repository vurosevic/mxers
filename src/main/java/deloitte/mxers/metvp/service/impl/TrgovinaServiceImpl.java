/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Trgovina;
import deloitte.mxers.metvp.repository.TrgovinaDAO;
import deloitte.mxers.metvp.service.TrgovinaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("trgovinaService")
@Transactional
public class TrgovinaServiceImpl implements TrgovinaService {

    @Autowired
    TrgovinaDAO trgovinaDAO;
    
    @Override
    public List<Trgovina> findAll() {
        return trgovinaDAO.findAll();
    }

    @Override
    public Optional<Trgovina> findById(Long id) {
        return trgovinaDAO.findById(id);
    }

    @Override
    public void delete(Trgovina t) {
        trgovinaDAO.delete(t); 
    }

    @Override
    public <S extends Trgovina> S save(S s) {
        return trgovinaDAO.save(s);
    }
    
}
