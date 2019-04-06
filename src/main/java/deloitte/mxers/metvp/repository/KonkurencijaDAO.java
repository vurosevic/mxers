/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Konkurencija;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("konkurencijaDAO")
public interface KonkurencijaDAO extends CrudRepository<Konkurencija, Long>{

    @Override
    public List<Konkurencija> findAll();

    @Override
    public Optional<Konkurencija> findById(Long id);

    @Override
    public <S extends Konkurencija> S save(S s);

    @Override
    public void delete(Konkurencija t);
    
    
    
}
