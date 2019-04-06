/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.BerzaPodaci;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("berzaPodaciDAO") 
public interface BerzaPodaciDAO extends CrudRepository<BerzaPodaci, Long>{

    @Override
    public List<BerzaPodaci> findAll();

    @Override
    public Optional<BerzaPodaci> findById(Long id);

    @Override
    public <S extends BerzaPodaci> S save(S s);

    @Override
    public void delete(BerzaPodaci t);
    
    @Query("SELECT DISTINCT bp.godinaPerioda FROM BerzaPodaci bp ORDER BY bp.godinaPerioda")
    public List<String> findAllGodinePerioda();         
            
}
