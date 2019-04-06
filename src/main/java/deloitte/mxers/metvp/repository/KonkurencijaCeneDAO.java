/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.KonkurencijaCene;
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
@Repository("konkurencijaCeneDAO")
public interface KonkurencijaCeneDAO extends CrudRepository<KonkurencijaCene, Long>{

    @Override
    public List<KonkurencijaCene> findAll();

    @Override
    public Optional<KonkurencijaCene> findById(Long id);

    @Override
    public <S extends KonkurencijaCene> S save(S s);

    @Override
    public void delete(KonkurencijaCene t);
    
    @Query("SELECT kc FROM KonkurencijaCene kc WHERE kc.period=:period AND kc.godinaPerioda=:godinaPerioda")
    public List<KonkurencijaCene> findByProizvod(@Param("period") String period, @Param("godinaPerioda") String godinaPerioda);

    @Query("SELECT MIN(kc.cena) FROM KonkurencijaCene kc WHERE kc.period=:period AND kc.godinaPerioda=:godinaPerioda")
    public Double minCenaByProizvod(@Param("period") String period, @Param("godinaPerioda") String godinaPerioda);    
}
