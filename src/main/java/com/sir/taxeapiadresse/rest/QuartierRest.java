/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.rest;

import com.sir.taxeapiadresse.bean.Quartier;
import com.sir.taxeapiadresse.rest.converter.QuartierConverter;
import com.sir.taxeapiadresse.rest.vo.QuartierVo;
import com.sir.taxeapiadresse.service.QuartierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping({"/taxe-api-souk/quartier"})
public class QuartierRest {
    @Autowired
    QuartierService quartierService;
    
    @GetMapping("/sec/{reference}")
    public List<QuartierVo> findBySecteurReference(@PathVariable String reference) {
        return new QuartierConverter().toVo(quartierService.findBySecteurReference(reference));
    }
    @GetMapping("/reference/{reference}")
    public QuartierVo findByReference(@PathVariable String reference) {
       return new QuartierConverter().toVo(quartierService.findByReference(reference));
    }
   
    @PostMapping("/")
    public QuartierVo creer(@RequestBody QuartierVo quartierVo) {
        QuartierConverter quartierConverter =new QuartierConverter();
        Quartier myquartier = quartierConverter.toItem(quartierVo);
        Quartier  quartier=quartierService.creer(myquartier);
        return quartierConverter.toVo(quartier);
    }
    
    
    @GetMapping("/all")
    public List<QuartierVo> findAll() {
        return new QuartierConverter().toVo(quartierService.findAll());
    }
    

    public QuartierService getQuartierService() {
        return quartierService;
    }

    public void setQuartierService(QuartierService quartierService) {
        this.quartierService = quartierService;
    }
    
   
  
  
    
}
