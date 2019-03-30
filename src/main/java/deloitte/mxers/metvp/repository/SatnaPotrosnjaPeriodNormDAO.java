/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodNorm;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("satnaPotrosnjaPeriodNormDAO")
public interface SatnaPotrosnjaPeriodNormDAO extends CrudRepository<SatnaPotrosnjaPeriodNorm, Long>{

    @Override
    public List<SatnaPotrosnjaPeriodNorm> findAll();

    @Override
    public Optional<SatnaPotrosnjaPeriodNorm> findById(Long id);        
    
}
