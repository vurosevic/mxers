/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.KursnaLista;
import deloitte.mxers.metvp.repository.KursnaListaDAO;
import deloitte.mxers.metvp.service.KursnaListaService;
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
@Service("kursnaListaService")
@Transactional
public class KursnaListaServiceImpl implements KursnaListaService {

    @Autowired
    KursnaListaDAO kursnaListaDAO;    
    
    @Override
    public List<KursnaLista> findAll() {
        return kursnaListaDAO.findAll();
    }

    @Override
    public Optional<KursnaLista> findById(Long id) {
        return kursnaListaDAO.findById(id);
    }

    @Override
    public void delete(KursnaLista t) {
        kursnaListaDAO.delete(t);
    }

    @Override
    public <S extends KursnaLista> S save(S s) {
        return kursnaListaDAO.save(s);
    }

    @Override
    public Double kursNaDan(Date datum) {
        return kursnaListaDAO.kursNaDan(datum);
    }
    
}
