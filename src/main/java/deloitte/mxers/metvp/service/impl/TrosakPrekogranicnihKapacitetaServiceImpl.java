/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
import deloitte.mxers.metvp.repository.TrosakPrekogranicnihKapacitetaDAO;
import deloitte.mxers.metvp.service.TrosakPrekogranicnihKapacitetaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("trosakPrekogranicnihKapacitetaService") 
@Transactional
public class TrosakPrekogranicnihKapacitetaServiceImpl implements TrosakPrekogranicnihKapacitetaService {

    @Autowired
    TrosakPrekogranicnihKapacitetaDAO trosakPrekogranicnihKapacitetaDAO;
    
    @Override
    public List<TrosakPrekogranicnihKapaciteta> findAll() {
        return trosakPrekogranicnihKapacitetaDAO.findAll();
    }

    @Override
    public Optional<TrosakPrekogranicnihKapaciteta> findById(Long id) {
        return trosakPrekogranicnihKapacitetaDAO.findById(id);
    }

    @Override
    public void delete(TrosakPrekogranicnihKapaciteta t) {
        trosakPrekogranicnihKapacitetaDAO.delete(t);
    }

    @Override
    public <S extends TrosakPrekogranicnihKapaciteta> S save(S s) {
        return trosakPrekogranicnihKapacitetaDAO.save(s);
    }

    @Override
    public Double ukupanTrosakPoGodini(Integer godina) {
        return trosakPrekogranicnihKapacitetaDAO.ukupanTrosakPoGodini(godina);
    }
    
}
