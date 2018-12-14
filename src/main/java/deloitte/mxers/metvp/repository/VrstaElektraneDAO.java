/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.VrstaElektrane;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("vrstaElektraneDAO")
public interface VrstaElektraneDAO extends CrudRepository<VrstaElektrane, Long>{

    @Override
    @Query("SELECT ve FROM VrstaElektrane ve")
    public List<VrstaElektrane> findAll();

    @Override
    public Optional<VrstaElektrane> findById(Long id);

    @Override
    public <S extends VrstaElektrane> S save(S s);

    @Override
    public void delete(VrstaElektrane t);
 
    
    
}
