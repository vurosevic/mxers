/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Smer;
import deloitte.mxers.metvp.repository.SmerDAO;
import deloitte.mxers.metvp.service.SmerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("smerService")
@Transactional
public class SmerServiceImpl implements SmerService {

    @Autowired
    SmerDAO smerDAO;
    
    @Override
    public List<Smer> findAll() {
        return smerDAO.findAll();
    }

    @Override
    public Optional<Smer> findById(Long id) {
        return smerDAO.findById(id);
    }
    
}
