/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Trgovina;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("trgovinaDAO")
public interface TrgovinaDAO extends CrudRepository<Trgovina, Long>{

    @Override
    public List<Trgovina> findAll();

    @Override
    public Optional<Trgovina> findById(Long id);

    @Override
    public void delete(Trgovina t);

    @Override
    public <S extends Trgovina> S save(S s);        
    
}
