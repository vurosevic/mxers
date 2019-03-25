/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.VpMaxIzlazniSet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("vpMaxIzlazniSetDAO")
public interface VpMaxIzlazniSetDAO extends CrudRepository<VpMaxIzlazniSet, Long>{

    @Override
    public List<VpMaxIzlazniSet> findAll();

    @Override
    public Optional<VpMaxIzlazniSet> findById(Long id);    
    
}
