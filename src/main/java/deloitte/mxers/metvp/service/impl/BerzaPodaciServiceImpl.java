/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.BerzaPodaci;
import deloitte.mxers.metvp.repository.BerzaPodaciDAO;
import deloitte.mxers.metvp.service.BerzaPodaciService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("berzaPodaciService")
@Transactional
public class BerzaPodaciServiceImpl implements BerzaPodaciService {

    @Autowired
    BerzaPodaciDAO berzaPodaciDAO;
    
    @Override
    public List<BerzaPodaci> findAll() {
        return berzaPodaciDAO.findAll();
    }

    @Override
    public Optional<BerzaPodaci> findById(Long id) {
        return berzaPodaciDAO.findById(id);
    }

    @Override
    public <S extends BerzaPodaci> S save(S s) {
        return berzaPodaciDAO.save(s);
    }

    @Override
    public void delete(BerzaPodaci t) {
        berzaPodaciDAO.delete(t);
    }
    
}
