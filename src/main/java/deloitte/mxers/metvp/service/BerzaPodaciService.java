/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.BerzaPodaci;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface BerzaPodaciService {

    public List<BerzaPodaci> findAll();
    public Optional<BerzaPodaci> findById(Long id);
    public <S extends BerzaPodaci> S save(S s);
    public void delete(BerzaPodaci t);    
    
}
