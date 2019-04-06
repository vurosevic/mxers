/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.KursnaLista;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface KursnaListaService {
   
    public List<KursnaLista> findAll();
    public Optional<KursnaLista> findById(Long id);
    public void delete(KursnaLista t);
    public <S extends KursnaLista> S save(S s);
    public Double kursNaDan(Date datum);     
    
}
