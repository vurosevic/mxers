/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.PutanjaDetalj;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("putanjaDetaljDAO")
public interface PutanjaDetaljDAO extends CrudRepository<PutanjaDetalj, Long>{

    @Override
    public List<PutanjaDetalj> findAll();

    @Override
    public Optional<PutanjaDetalj> findById(Long id);

    @Override
    public <S extends PutanjaDetalj> S save(S s);

    @Override
    public void delete(PutanjaDetalj t);
    
       
}
