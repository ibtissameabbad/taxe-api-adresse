/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.service;

import com.sir.taxeapiadresse.bean.Rue;
import java.util.List;

/**
 *
 * @author user
 */
public interface RueService {
    
    public List<Rue> findByQuartierReference(String reference);
    public Rue findByReference(String reference);
    public Rue creer(Rue rue);
    public List<Rue> findAll();
    
    public boolean existsById(Long id);
}
