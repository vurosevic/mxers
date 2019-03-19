/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.AukcijaCena;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Vladimir
 */
public interface AukcijaCenaService {
  
    public List<AukcijaCena> findAll();
    public Optional<AukcijaCena> findById(Long id);
    public <S extends AukcijaCena> S save(S s);
    public void delete(AukcijaCena t);
    public List<AukcijaCena> listaCenaPoAukciji(Long aukcija_id); 
    public List<AukcijaCena> listaCenaPoAukcijiZaGodinu(Long aukcija_id, Integer godina); 
    public List<AukcijaCena> listaCenaPoAukcijiZaGodinuPoSmeru(Long aukcija_id, Integer godina, Long smer_id);    
}
