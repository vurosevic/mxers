/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.PutanjaDef;
import deloitte.mxers.metvp.repository.PutanjaDefDAO;
import deloitte.mxers.metvp.service.PutanjaDefService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("putanjaDefService")
@Transactional
public class PutanjaDefServiceImpl implements PutanjaDefService {

    @Autowired
    PutanjaDefDAO putanjaDefDAO;
    
    @Override
    public List<PutanjaDef> findAll() {
        return putanjaDefDAO.findAll();
    }

    @Override
    public Optional<PutanjaDef> findById(Long id) {
        return putanjaDefDAO.findById(id);
    }

    @Override
    public <S extends PutanjaDef> S save(S s) {
        return putanjaDefDAO.save(s);
    }

    @Override
    public void delete(PutanjaDef t) {
        putanjaDefDAO.delete(t);
    }
    
}
