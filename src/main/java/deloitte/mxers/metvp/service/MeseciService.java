/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.Meseci;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface MeseciService {
    public List<Meseci> findAll();
    public Optional<Meseci> findById(Long id);     
}
