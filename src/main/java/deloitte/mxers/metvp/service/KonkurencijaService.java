/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Konkurencija;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface KonkurencijaService {
    
    public List<Konkurencija> findAll();
    public Optional<Konkurencija> findById(Long id);
    public <S extends Konkurencija> S save(S s);
    public void delete(Konkurencija t);    
    
}
