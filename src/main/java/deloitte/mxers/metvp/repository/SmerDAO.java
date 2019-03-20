/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Smer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("smerDAO") 
public interface SmerDAO extends CrudRepository<Smer, Long>{

    @Override
    public List<Smer> findAll();

    @Override
    public Optional<Smer> findById(Long id);
    
}
