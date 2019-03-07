/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.service.impl;

import com.sir.taxeapiadresse.bean.Quartier;
import com.sir.taxeapiadresse.bean.Secteur;
import com.sir.taxeapiadresse.dao.QuartierDao;
import com.sir.taxeapiadresse.service.QuartierService;
import com.sir.taxeapiadresse.service.SecteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class QuartierServiceImpl implements QuartierService{
    
    @Autowired
    QuartierDao quartierDao;
    @Autowired
    SecteurService secteurService;
    

    @Override
    public Quartier creer(Quartier quartier) {
             Secteur s = quartier.getSecteur();
              
             if(secteurService.existsById(s.getId())== false){
                 return null;
             }else{
                 quartierDao.save(quartier);
                 return quartier;
             }
            
    }

    @Override
    public List<Quartier> findBySecteurReference(String reference) {
        return quartierDao.findBySecteurReference(reference);
    }

    @Override
    public Quartier findByReference(String reference) {
        return quartierDao.findByReference(reference);
    }
      @Override
    public List<Quartier> findAll() {
       return quartierDao.findAll();
    }
      @Override
    public boolean existsById(Long id) {
        return quartierDao.existsById(id);
    }

    public QuartierDao getQuartierDao() {
        return quartierDao;
    }

    public void setQuartierDao(QuartierDao quartierDao) {
        this.quartierDao = quartierDao;
    }

    public SecteurService getSecteurService() {
        return secteurService;
    }

    public void setSecteurService(SecteurService secteurService) {
        this.secteurService = secteurService;
    }

  
  
    
}
