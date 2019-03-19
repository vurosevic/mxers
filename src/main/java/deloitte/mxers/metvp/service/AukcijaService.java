/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Aukcija;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface AukcijaService {
    
    public List<Aukcija> findAll();
    public Optional<Aukcija> findById(Long id);
    public <S extends Aukcija> S save(S s);
    public void delete(Aukcija t);     
    
}
