/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.AukcijaCena;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("aukcijaCenaDAO")
public interface AukcijaCenaDAO extends CrudRepository<AukcijaCena, Long>{

    @Override
    public List<AukcijaCena> findAll();

    @Override
    public Optional<AukcijaCena> findById(Long id);

    @Override
    public <S extends AukcijaCena> S save(S s);

    @Override
    public void delete(AukcijaCena t);
    
    @Query("SELECT ac FROM AukcijaCena ac WHERE aukcija.id = :aukcija_id")
    public List<AukcijaCena> listaCenaPoAukciji(@Param("aukcija_id") Long aukcija_id); 
    
    @Query("SELECT ac FROM AukcijaCena ac WHERE aukcija.id = :aukcija_id AND godina = :godina")
    public List<AukcijaCena> listaCenaPoAukcijiZaGodinu(@Param("aukcija_id") Long aukcija_id, @Param("godina") Integer godina); 
    
    @Query("SELECT ac FROM AukcijaCena ac WHERE aukcija.id = :aukcija_id AND godina = :godina AND smer.id = :smer_id")
    public List<AukcijaCena> listaCenaPoAukcijiZaGodinuPoSmeru(@Param("aukcija_id") Long aukcija_id, @Param("godina") Integer godina, @Param("smer_id") Long smer_id); 
    
}
