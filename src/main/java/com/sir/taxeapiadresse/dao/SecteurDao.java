/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.dao;

import com.sir.taxeapiadresse.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface SecteurDao extends JpaRepository<Secteur,Long>{
    
    public Secteur findByReference(String reference);
}
