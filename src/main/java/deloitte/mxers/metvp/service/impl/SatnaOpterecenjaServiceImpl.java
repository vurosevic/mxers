/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.SatnaOpterecenja;
import deloitte.mxers.metvp.repository.SatnaOpterecenjaDAO;
import deloitte.mxers.metvp.service.SatnaOpterecenjaService;
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
@Service("satnaOpterecenjaService")
@Transactional
public class SatnaOpterecenjaServiceImpl implements SatnaOpterecenjaService {

    @Autowired
    SatnaOpterecenjaDAO satnaOpterecenjaDAO;
    
    @Override
    public List<SatnaOpterecenja> findAll() {
        return satnaOpterecenjaDAO.findAll();
    }

    @Override
    public Optional<SatnaOpterecenja> findById(Long id) {
        return satnaOpterecenjaDAO.findById(id);
    }

    @Override
    public <S extends SatnaOpterecenja> S save(S s) {
        return satnaOpterecenjaDAO.save(s);
    }

    @Override
    public void delete(SatnaOpterecenja t) {
        satnaOpterecenjaDAO.delete(t);
    }

    @Override
    public List<SatnaOpterecenja> listaSatnihOpterecenjaPoDatumu(Date datum_ul) {
        return satnaOpterecenjaDAO.listaSatnihOpterecenjaPoDatumu(datum_ul);
    }
    
}
