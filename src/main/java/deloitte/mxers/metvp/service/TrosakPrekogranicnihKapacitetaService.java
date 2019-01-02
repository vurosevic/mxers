/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface TrosakPrekogranicnihKapacitetaService {

    public List<TrosakPrekogranicnihKapaciteta> findAll();       
    public Optional<TrosakPrekogranicnihKapaciteta> findById(Long id);    
    public void delete(TrosakPrekogranicnihKapaciteta t);    
    public <S extends TrosakPrekogranicnihKapaciteta> S save(S s);        
    public Double ukupanTrosakPoGodini(Integer godina);      
    
}
