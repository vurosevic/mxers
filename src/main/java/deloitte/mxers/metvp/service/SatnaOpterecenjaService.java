/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.SatnaOpterecenja;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface SatnaOpterecenjaService {

    public List<SatnaOpterecenja> findAll();
    public Optional<SatnaOpterecenja> findById(Long id);
    public <S extends SatnaOpterecenja> S save(S s);
    public void delete(SatnaOpterecenja t);
    public List<SatnaOpterecenja> listaSatnihOpterecenjaPoDatumu(Date datum_ul);  
    
}
