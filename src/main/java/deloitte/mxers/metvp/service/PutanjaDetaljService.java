/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service;

import deloitte.mxers.metvp.domen.PutanjaDetalj;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface PutanjaDetaljService {

    public List<PutanjaDetalj> findAll();
    public Optional<PutanjaDetalj> findById(Long id);
    public <S extends PutanjaDetalj> S save(S s);
    public void delete(PutanjaDetalj t);
    public List<PutanjaDetalj> listaPutanjaDetaljaPoDef(Long putanjaDef_id);    
}
