/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Periodi;
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
@Repository("periodiDAO") 
public interface PeriodiDAO extends CrudRepository<Periodi, Long>{

    @Override
    public Optional<Periodi> findById(Long id);    
    
    @Override
    public List<Periodi> findAll();

    @Override
    public void deleteById(Long id);

    @Override
    public <S extends Periodi> S save(S s);

    @Query("SELECT p FROM Periodi p WHERE sifraPerioda = :sifraPerioda")
    public List<Periodi> findBySifra(@Param("sifraPerioda") String sifraPerioda); 
    
    @Query("SELECT DISTINCT p.sifraPerioda FROM Periodi p")
    public List<String> findAllSifra();     
    
}
