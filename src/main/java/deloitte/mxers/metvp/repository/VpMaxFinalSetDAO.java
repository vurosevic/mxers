/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxFinalSet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("vpMaxFinalSetDAO")
public interface VpMaxFinalSetDAO extends CrudRepository<VpMaxFinalSet, Long>{

    @Override
    public List<VpMaxFinalSet> findAll();

    @Override
    public Optional<VpMaxFinalSet> findById(Long id);
    
}
