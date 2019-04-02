/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Periodi;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface PeriodiService {

    public Optional<Periodi> findById(Long id);    
    public List<Periodi> findAll();
    public void deleteById(Long id);
    public <S extends Periodi> S save(S s);
    public List<Periodi> findBySifra(String sifraPerioda);    
    public List<String> findAllSifra();    
    public List<String> findAllSifraKvartal(); 
}
