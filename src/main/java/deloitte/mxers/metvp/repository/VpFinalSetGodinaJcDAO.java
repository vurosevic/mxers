/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetGodinaJc;
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
@Repository("vpFinalSetGodinaJcDAO")
public interface VpFinalSetGodinaJcDAO extends CrudRepository<VpFinalSetGodinaJc, Long>{

    @Override
    public List<VpFinalSetGodinaJc> findAll();

    @Override
    public Optional<VpFinalSetGodinaJc> findById(Long id);
    
    @Query("SELECT p FROM VpFinalSetGodinaJc p WHERE period = :period")
    public List<VpFinalSetGodinaJc> findByPeriod(@Param("period") String period);     
}
