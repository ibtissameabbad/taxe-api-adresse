/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.dao;

import com.sir.taxeapiadresse.bean.Categorie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long>{
 
     public Categorie findByRefCategorie(String refCategorie);
}
