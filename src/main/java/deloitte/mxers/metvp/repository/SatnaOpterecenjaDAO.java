/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.repository;

import deloitte.mxers.metvp.domen.SatnaOpterecenja;
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
@Repository("satnaOpterecenjaDAO")
public interface SatnaOpterecenjaDAO extends CrudRepository<SatnaOpterecenja, Long>{

    @Override
    public List<SatnaOpterecenja> findAll();

    @Override
    public Optional<SatnaOpterecenja> findById(Long id);

    @Override
    public <S extends SatnaOpterecenja> S save(S s);

    @Override
    public void delete(SatnaOpterecenja t);
    
    @Query("SELECT sa FROM SatnaOpterecenja sa WHERE datum = :datum_ul")
    public List<SatnaOpterecenja> listaSatnihOpterecenjaPoDatumu(@Param("datum_ul") Date datum_ul);     
    
}
