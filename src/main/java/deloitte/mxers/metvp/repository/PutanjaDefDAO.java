/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.PutanjaDef;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("putanjaDefDAO")
public interface PutanjaDefDAO extends CrudRepository<PutanjaDef, Long>{

    @Override
    public List<PutanjaDef> findAll();

    @Override
    public Optional<PutanjaDef> findById(Long id);

    @Override
    public <S extends PutanjaDef> S save(S s);

    @Override
    public void delete(PutanjaDef t);
    
}
