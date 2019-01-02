/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.Debalans;
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
@Repository("debalansDAO")
public interface DebalansDAO extends CrudRepository<Debalans, Long>{

    @Override
    public List<Debalans> findAll();

    @Override
    public Optional<Debalans> findById(Long id);

    @Override
    public <S extends Debalans> S save(S s);
        
    @Override
    public void delete(Debalans t);    
    
    @Query("SELECT SUM(d.visakCena) + ABS(SUM(d.visakCena + d.visakNcCena + d.manjakCena)) FROM Debalans d WHERE godina = :godina")
    public Double ukupniTroskoviDebalansaPoGodini(@Param("godina") Integer godina);      
    
}
