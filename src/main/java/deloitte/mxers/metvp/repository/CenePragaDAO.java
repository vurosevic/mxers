/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.CenaPraga;
import java.util.Date;
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
@Repository("cenePragaDAO")
public interface CenePragaDAO extends CrudRepository<CenaPraga, Long>{

    @Override
    public List<CenaPraga> findAll();

    @Override
    public Optional<CenaPraga> findById(Long id);

    @Override
    public <S extends CenaPraga> S save(S s);

    @Override
    public void delete(CenaPraga t);
    
    @Query("SELECT cp FROM CenaPraga cp WHERE :dateCP BETWEEN datumOd AND datumDo AND elektrana.id = :id_elektrana")
    public List<CenaPraga> findByDate(@Param("dateCP") Date dateCP, @Param("id_elektrana") Long id_elektrana);
           
}
