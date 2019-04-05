/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetGodinaJc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface VpFinalSetGodinaJcService {
    public List<VpFinalSetGodinaJc> findAll();
    public Optional<VpFinalSetGodinaJc> findById(Long id);
    public List<VpFinalSetGodinaJc> findByPeriod(String period);     
}
