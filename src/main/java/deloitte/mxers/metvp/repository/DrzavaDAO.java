/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Drzava;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("drzavaDAO")
public interface DrzavaDAO extends CrudRepository<Drzava, Long>{

    @Override
    public List<Drzava> findAll();

    @Override
    public Optional<Drzava> findById(Long id);

    @Override
    public <S extends Drzava> S save(S s);

    @Override
    public void delete(Drzava t);
    
    
    
}
