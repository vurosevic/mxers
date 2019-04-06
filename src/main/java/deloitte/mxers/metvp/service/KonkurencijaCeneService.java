/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.KonkurencijaCene;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface KonkurencijaCeneService {
    
    public List<KonkurencijaCene> findAll();
    public Optional<KonkurencijaCene> findById(Long id);
    public <S extends KonkurencijaCene> S save(S s);
    public void delete(KonkurencijaCene t);   
    public List<KonkurencijaCene> findByProizvod(String period, String godinaPerioda);
    public Double minCenaByProizvod(String period, String godinaPerioda);        
    
}
