/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Trgovina;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface TrgovinaService {
      
    public List<Trgovina> findAll();
    
    public Optional<Trgovina> findById(Long id);
    
    public void delete(Trgovina t);
    
    public <S extends Trgovina> S save(S s);       
    
}
