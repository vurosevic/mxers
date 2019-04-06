/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.Konkurencija;
import deloitte.mxers.metvp.repository.KonkurencijaDAO;
import deloitte.mxers.metvp.service.KonkurencijaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("konkurencijaService")
@Transactional
public class KonkurencijaServiceImpl implements KonkurencijaService {

    @Autowired
    KonkurencijaDAO konkurencijaDAO;
    
    @Override
    public List<Konkurencija> findAll() {
        return konkurencijaDAO.findAll();
    }

    @Override
    public Optional<Konkurencija> findById(Long id) {
        return konkurencijaDAO.findById(id);
    }

    @Override
    public <S extends Konkurencija> S save(S s) {
        return konkurencijaDAO.save(s);
    }

    @Override
    public void delete(Konkurencija t) {
        konkurencijaDAO.delete(t);
    }
    
}
