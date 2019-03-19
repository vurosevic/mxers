/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.AukcijaCena;
import deloitte.mxers.metvp.repository.AukcijaCenaDAO;
import deloitte.mxers.metvp.service.AukcijaCenaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("aukcijaCenaService")
@Transactional
public class AukcijaCenaServiceImpl implements AukcijaCenaService {

    @Autowired
    AukcijaCenaDAO aukcijaCenaDAO;
    
    @Override
    public List<AukcijaCena> findAll() {
        return aukcijaCenaDAO.findAll();
    }

    @Override
    public Optional<AukcijaCena> findById(Long id) {
        return aukcijaCenaDAO.findById(id);
    }

    @Override
    public <S extends AukcijaCena> S save(S s) {
        return aukcijaCenaDAO.save(s);
    }

    @Override
    public void delete(AukcijaCena t) {
        aukcijaCenaDAO.delete(t);
    }

    @Override
    public List<AukcijaCena> listaCenaPoAukciji(Long aukcija_id) {
        return aukcijaCenaDAO.listaCenaPoAukciji(aukcija_id);
    }

    @Override
    public List<AukcijaCena> listaCenaPoAukcijiZaGodinu(Long aukcija_id, Integer godina) {
        return aukcijaCenaDAO.listaCenaPoAukcijiZaGodinu(aukcija_id, godina);
    }
    
}
