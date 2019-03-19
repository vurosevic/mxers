/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Berza;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("berzaDAO") 
public interface BerzaDAO extends CrudRepository<Berza, Long>{

    @Override
    public List<Berza> findAll();

    @Override
    public Optional<Berza> findById(Long id);

    @Override
    public <S extends Berza> S save(S s);

    @Override
    public void delete(Berza t);        
        
}
