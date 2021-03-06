/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaMesecAvg;
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
@Repository("satnaPotrosnjaMesecAvgDAO")
public interface SatnaPotrosnjaMesecAvgDAO extends CrudRepository<SatnaPotrosnjaMesecAvg, Long>{

    @Override
    public List<SatnaPotrosnjaMesecAvg> findAll();

    @Override
    public Optional<SatnaPotrosnjaMesecAvg> findById(Long id);        
    
    @Query("SELECT sa FROM SatnaPotrosnjaMesecAvg sa WHERE godina = :godina AND kvartal = :kvartal")  
    public List<SatnaPotrosnjaMesecAvg> findByGodinaKvartal(@Param("godina") Integer godina, @Param("kvartal") String kvartal); 
     
}
