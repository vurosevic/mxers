/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Berza;
import deloitte.mxers.metvp.repository.BerzaDAO;
import deloitte.mxers.metvp.service.BerzaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("berzaService")
@Transactional
public class BerzaServiceImpl implements BerzaService {

    @Autowired
    BerzaDAO berzaDAO;
    
    @Override
    public List<Berza> findAll() {
        return berzaDAO.findAll();
    }

    @Override
    public Optional<Berza> findById(Long id) {
        return berzaDAO.findById(id);
    }

    @Override
    public <S extends Berza> S save(S s) {
        return berzaDAO.save(s);
    }

    @Override
    public void delete(Berza t) {
        berzaDAO.delete(t); 
    }
           
}
