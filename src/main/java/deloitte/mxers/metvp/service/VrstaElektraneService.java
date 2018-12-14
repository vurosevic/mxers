/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.VrstaElektrane;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface VrstaElektraneService {
   
    public List<VrstaElektrane> findAll();
    public Optional<VrstaElektrane> findById(Long id);
    public <S extends VrstaElektrane> S save(S s);
    public void delete(VrstaElektrane t);    
    
}
