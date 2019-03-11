/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.TrosakPrekogranicnihKapaciteta;
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
@Repository("trosakPrekogranicnihKapacitetaDAO") 
public interface TrosakPrekogranicnihKapacitetaDAO  extends CrudRepository<TrosakPrekogranicnihKapaciteta, Long>{

    @Override
    public List<TrosakPrekogranicnihKapaciteta> findAll();   

    @Override
    public Optional<TrosakPrekogranicnihKapaciteta> findById(Long id);

    @Override
    public void delete(TrosakPrekogranicnihKapaciteta t);

    @Override
    public <S extends TrosakPrekogranicnihKapaciteta> S save(S s);
    
    @Query("SELECT SUM(t.trosak) FROM TrosakPrekogranicnihKapaciteta t WHERE godina = :godina")
    public Double ukupanTrosakPoGodini(@Param("godina") Integer godina);  
    
    @Query("SELECT t FROM TrosakPrekogranicnihKapaciteta t WHERE godina = :godina")
    public List<TrosakPrekogranicnihKapaciteta> listaTroskovaPoGodini(@Param("godina") Integer godina);      
    
}
