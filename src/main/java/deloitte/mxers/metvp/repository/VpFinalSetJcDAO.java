/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetJc;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("vpFinalSetJcDAO")
public interface VpFinalSetJcDAO extends CrudRepository<VpFinalSetJc, Long>{

    @Override
    public List<VpFinalSetJc> findAll();

    @Override
    public Optional<VpFinalSetJc> findById(Long id);
    
    @Query("SELECT p FROM VpFinalSetJc p WHERE period = :period")
    public List<VpFinalSetJc> findByPeriod(@Param("period") String period);     
    
}
