/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import deloitte.mxers.metvp.domen.viewclasses.VpMaxUlazniSet;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface VpMaxUlazniSetService {
     public List<VpMaxUlazniSet> findAll();
     public Optional<VpMaxUlazniSet> findById(Long id);  
    
}
