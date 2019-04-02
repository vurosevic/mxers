/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Meseci;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("meseciDAO")
public interface MeseciDAO extends CrudRepository<Meseci, Long>{

    @Override
    public List<Meseci> findAll();

    @Override
    public Optional<Meseci> findById(Long id);        
    
}
