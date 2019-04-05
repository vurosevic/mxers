/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.viewclasses.VpFinalSetJc;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Vladimir
 */
public interface VpFinalSetJcService {

    public List<VpFinalSetJc> findAll();
    public Optional<VpFinalSetJc> findById(Long id);    
    public List<VpFinalSetJc> findByPeriod(String period);    
}
