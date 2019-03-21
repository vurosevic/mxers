/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.PutanjaDetalj;
import deloitte.mxers.metvp.repository.PutanjaDetaljDAO;
import deloitte.mxers.metvp.service.PutanjaDetaljService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("putanjaDetaljService")
@Transactional
public class PutanjaDetaljServiceImpl implements PutanjaDetaljService {

    @Autowired
    PutanjaDetaljDAO putanjaDetaljDAO;
    
    @Override
    public List<PutanjaDetalj> findAll() {
        return putanjaDetaljDAO.findAll();
    }

    @Override
    public Optional<PutanjaDetalj> findById(Long id) {
        return putanjaDetaljDAO.findById(id);
    }

    @Override
    public <S extends PutanjaDetalj> S save(S s) {
        return putanjaDetaljDAO.save(s);
    }

    @Override
    public void delete(PutanjaDetalj t) {
        putanjaDetaljDAO.delete(t);
    }

    @Override
    public List<PutanjaDetalj> listaPutanjaDetaljaPoDef(Long putanjaDef_id) {
        return putanjaDetaljDAO.listaPutanjaDetaljaPoDef(putanjaDef_id);
    }
    
}
