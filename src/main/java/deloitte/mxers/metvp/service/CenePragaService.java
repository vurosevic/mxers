/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.CenaPraga;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface CenePragaService {

    public List<CenaPraga> findAll();
    public Optional<CenaPraga> findById(Long id);
    public <S extends CenaPraga> S save(S s);
    public void delete(CenaPraga t);
    public List<CenaPraga> findByDate(Date dateCP);    
    
}
