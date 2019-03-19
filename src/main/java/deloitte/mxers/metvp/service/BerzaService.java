/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Berza;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface BerzaService {
    
    public List<Berza> findAll();
    public Optional<Berza> findById(Long id);
    public <S extends Berza> S save(S s);
    public void delete(Berza t);     
    
}
