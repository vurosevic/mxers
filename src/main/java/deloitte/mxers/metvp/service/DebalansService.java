/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Debalans;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface DebalansService {
 
    public List<Debalans> findAll();

    public Optional<Debalans> findById(Long id);

    public <S extends Debalans> S save(S s);
    
    public void delete(Debalans t);     
    
}
