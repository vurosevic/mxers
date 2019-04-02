/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.viewclasses.SatnaPotrosnjaMesecAvg;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface SatnaPotrosnjaMesecAvgService {
 
    public List<SatnaPotrosnjaMesecAvg> findAll();
    public Optional<SatnaPotrosnjaMesecAvg> findById(Long id);           
    public List<SatnaPotrosnjaMesecAvg> findByGodinaKvartal(Integer godina, String kvartal); 
}
