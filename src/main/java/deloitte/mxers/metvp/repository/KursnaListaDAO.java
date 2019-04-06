/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.KursnaLista;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Vladimir
 */
public interface KursnaListaDAO extends CrudRepository<KursnaLista, Long>{

    @Override
    public List<KursnaLista> findAll();

    @Override
    public Optional<KursnaLista> findById(Long id);

    @Override
    public void delete(KursnaLista t);

    @Override
    public <S extends KursnaLista> S save(S s);
    
    @Query("SELECT kl.kurs FROM KursnaLista kl WHERE kl.datum = :datum")
    public Double kursNaDan(@Param("datum") Date datum);        
    
    
    
}
