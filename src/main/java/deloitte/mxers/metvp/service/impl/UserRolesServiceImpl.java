/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.service.impl;

import deloitte.mxers.metvp.domen.User;
import deloitte.mxers.metvp.domen.UserRoles;
import deloitte.mxers.metvp.repository.UserRolesDAO;
import deloitte.mxers.metvp.service.UserRolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("userRolesService")
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    UserRolesDAO userRolesDAO;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED) 
    public <S extends UserRoles> S save(S s) {
        return userRolesDAO.save(s);
    }

    @Override
    public void deleteAll(Iterable<? extends UserRoles> itrbl) {
        userRolesDAO.deleteAll(itrbl);
    }

    @Override
    public List<String> findListRolesByUser(User user) {
        return userRolesDAO.findListRolesByUser(user);
    }

    @Override
    public List<UserRoles> findByUser(User user) {
        return userRolesDAO.findByUser(user);
    }
    
}
