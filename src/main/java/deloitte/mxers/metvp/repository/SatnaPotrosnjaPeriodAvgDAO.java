/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaPeriodAvg;
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
@Repository("satnaPotrosnjaPeriodAvgDAO")
public interface SatnaPotrosnjaPeriodAvgDAO extends CrudRepository<SatnaPotrosnjaPeriodAvg, Long>{

    @Override
    public List<SatnaPotrosnjaPeriodAvg> findAll();

    @Override
    public Optional<SatnaPotrosnjaPeriodAvg> findById(Long id);

    @Query("SELECT sa FROM SatnaPotrosnjaPeriodAvg sa WHERE godina = :godina AND sifraPerioda = :sifraPerioda")  
    public List<SatnaPotrosnjaPeriodAvg> findByGodinaPeriod(@Param("godina") Integer godina, @Param("sifraPerioda") String sifraPerioda); 
    
    @Query("SELECT sa FROM SatnaPotrosnjaPeriodAvg sa WHERE godina = :godina ORDER BY sifraPerioda")  
    public List<SatnaPotrosnjaPeriodAvg> findByGodina(@Param("godina") Integer godina);     
    
    @Query("SELECT DISTINCT sa.godina FROM SatnaPotrosnjaPeriodAvg sa ORDER BY sa.godina")
    public List<Integer> findAllGodina();             
}
