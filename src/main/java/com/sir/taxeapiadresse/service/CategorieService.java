/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.service;

import com.sir.taxeapiadresse.bean.Categorie;
import java.util.List;

/**
 *
 * @author user
 */
public  interface CategorieService {
     public int creer(Categorie categorie);
   // public List<Categorie> findAll();
      public Categorie findByRefCategorie(String refCategorie);
     
        
}
