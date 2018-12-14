/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Elektrana;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface ElektraneService {
    
    public List<Elektrana> findAll();
    public Optional<Elektrana> findById(Long id);
    public <S extends Elektrana> S save(S s);   
    public void delete(Elektrana t);    
    
}
