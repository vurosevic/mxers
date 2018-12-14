/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Elektrana;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("elektraneDAO")
public interface ElektraneDAO extends CrudRepository<Elektrana, Long>{

    @Override
    @Query("SELECT e FROM Elektrana e")
    public List<Elektrana> findAll();

    @Override
    public Optional<Elektrana> findById(Long id);

    @Override
    public <S extends Elektrana> S save(S s);

    @Override
    public void delete(Elektrana t);
   
}
