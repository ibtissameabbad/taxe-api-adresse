/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.service.impl;

import com.sir.taxeapiadresse.bean.Categorie;
import com.sir.taxeapiadresse.bean.Local;
import com.sir.taxeapiadresse.bean.Redevable;
import com.sir.taxeapiadresse.bean.Rue;
import com.sir.taxeapiadresse.dao.LocalDao;
import com.sir.taxeapiadresse.service.CategorieService;
import com.sir.taxeapiadresse.service.LocalService;
import com.sir.taxeapiadresse.service.RedevableService;
import com.sir.taxeapiadresse.service.RueService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalDao localDao;
    @Autowired
    RedevableService redevableService;
    @Autowired
    RueService rueService;
    @Autowired
    CategorieService categorieService;

    @Override
    public List<Local> findByRedevableCin(String cin) {
        return localDao.findByRedevableCin(cin);
    }

    @Override
    public Local findByReference(String reference) {
        return localDao.findByReference(reference);
    }

//    @Override
//    public Object[] creer(Local local) {
//        Redevable r= local.getRedevable();
//         Redevable p= local.getProprietaire();
//        Rue rue=local.getRue();
////        Categorie c= local.getCategorie();
//        if(redevableService.existsById(r.getId())==false){
//            return  new Object[]{-1,null};
//        }else if(redevableService.existsById(p.getId())==false){
//            return  new Object[]{-2,null};
//        }
//        else if(rueService.existsById(rue.getId())==false){
//            return  new Object[]{-3,null};
//        }
////        else if(categorieService.existsById(c.getId())==false){
////            return -4;
////        }
//        else {
//            local.setDernierAnneePaye(BigDecimal.ZERO);
//            local.setDernierTrimestrePaye(BigDecimal.ZERO);
//              localDao.save(local);
//        return  new Object[]{1,local};
//        }
//      
//    }
    @Override
    public Local creer(Local local) {
        Local l = findByReference(local.getReference());
        if (l != null) {
            return null;
        } else {
//            local.setDernierAnneePaye(BigDecimal.ZERO);
//            local.setDernierTrimestrePaye(BigDecimal.ZERO);
            localDao.save(local);
            System.out.println("local "+local);;
            return local;
        }
    }

    @Override
    public List<Local> findAll() {
        return localDao.findAll();
    }

    public LocalDao getLocalDao() {
        return localDao;
    }

    public void setLocalDao(LocalDao localDao) {
        this.localDao = localDao;
    }

    public RedevableService getRedevableService() {
        return redevableService;
    }

    public void setRedevableService(RedevableService redevableService) {
        this.redevableService = redevableService;
    }

    public RueService getRueService() {
        return rueService;
    }

    public void setRueService(RueService rueService) {
        this.rueService = rueService;
    }

}
