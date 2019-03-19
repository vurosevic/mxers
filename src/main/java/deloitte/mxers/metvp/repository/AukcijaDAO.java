/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Aukcija;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("aukcijaDAO")
public interface AukcijaDAO extends CrudRepository<Aukcija, Long>{

    @Override
    public List<Aukcija> findAll();

    @Override
    public Optional<Aukcija> findById(Long id);

    @Override
    public <S extends Aukcija> S save(S s);

    @Override
    public void delete(Aukcija t);       
    
}
