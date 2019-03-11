/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Bilans;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface BilansService {
    
    public List<Bilans> findAll();
    public Optional<Bilans> findById(Long id);
    public <S extends Bilans> S save(S s);
    public void delete(Bilans t);   
    public Double ukupnoOstvarenoPoGodini(Integer godina);  
    public List<Bilans> listaMesecnihOstvarenjaUGodini(Integer godina);
    public List<Bilans> findByPeriod(Integer godinaOd, Integer godinaDo);      
}
