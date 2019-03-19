/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.PutanjaDef;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface PutanjaDefService {
    
    public List<PutanjaDef> findAll();
    public Optional<PutanjaDef> findById(Long id);
    public <S extends PutanjaDef> S save(S s);
    public void delete(PutanjaDef t);    
    
}
