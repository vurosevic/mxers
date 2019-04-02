/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Meseci;
import deloitte.mxers.metvp.repository.MeseciDAO;
import deloitte.mxers.metvp.service.MeseciService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("meseciService") 
@Transactional
public class MeseciServiceImpl implements MeseciService {

    @Autowired
    MeseciDAO meseciDAO;
    
    @Override
    public List<Meseci> findAll() {
        return meseciDAO.findAll();
    }

    @Override
    public Optional<Meseci> findById(Long id) {
        return meseciDAO.findById(id);
    }
    
}
