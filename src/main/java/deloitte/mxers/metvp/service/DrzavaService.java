/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Drzava;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface DrzavaService {
    
    public List<Drzava> findAll();
    public Optional<Drzava> findById(Long id);
    public <S extends Drzava> S save(S s);
    public void delete(Drzava t);    
    
}
