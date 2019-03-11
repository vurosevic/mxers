/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Bilans;
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
@Repository("bilansDAO")
public interface BilansDAO extends CrudRepository<Bilans, Long>{

    @Override
    public List<Bilans> findAll();

    @Override
    public Optional<Bilans> findById(Long id);

    @Override
    public <S extends Bilans> S save(S s);

    @Override
    public void delete(Bilans t);        
    
    @Query("SELECT SUM(b.ostvarenaProizvodnja) FROM Bilans b WHERE godina = :godina")
    public Double ukupnoOstvarenoPoGodini(@Param("godina") Integer godina);    
    
    @Query("SELECT b FROM Bilans b WHERE godina = :godina")
    public List<Bilans> listaMesecnihOstvarenjaUGodini(@Param("godina") Integer godina);        
    
    @Query("SELECT b FROM Bilans b WHERE godina BETWEEN :godinaOd AND :godinaDo")
    public List<Bilans> findByPeriod(@Param("godinaOd") Integer godinaOd, @Param("godinaDo") Integer godinaDo);
    
}
