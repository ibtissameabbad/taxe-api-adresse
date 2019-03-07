/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.rest;

import com.sir.taxeapiadresse.bean.Secteur;
import com.sir.taxeapiadresse.rest.converter.AbstractConverter;
import com.sir.taxeapiadresse.rest.converter.SecteurConverter;
import com.sir.taxeapiadresse.rest.vo.SecteurVo;
import com.sir.taxeapiadresse.service.LocalService;
import com.sir.taxeapiadresse.service.QuartierService;
import com.sir.taxeapiadresse.service.RueService;
import com.sir.taxeapiadresse.service.SecteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping({"/taxe-api-souk/secteur"})
public class SecteurRest {
    @Autowired
    SecteurService secteurService;
    
    @Qualifier("secteurConverter")
    private AbstractConverter<Secteur, SecteurVo> secteurConverter;

    
    @GetMapping("/reference/{reference}")
    public SecteurVo findByReference(@PathVariable String reference) {
        return secteurConverter.toVo(secteurService.findByReference(reference));
    }
    @PostMapping("/")
    public SecteurVo creer(@RequestBody SecteurVo secteurVo) {
        Secteur mySecteur = secteurConverter.toItem(secteurVo);
        Secteur secteur =secteurService.creer(mySecteur);
        return secteurConverter.toVo(secteur);
    }

    @GetMapping("/all")
    public List<SecteurVo> findAll() {
        return secteurConverter.toVo(secteurService.findAll());
    }
//    @PostMapping("/del")
//    public void deleteById(Long id) {
//        secteurService.deleteById(id);
//    }

    public SecteurService getSecteurService() {
        return secteurService;
    }

    public void setSecteurService(SecteurService secteurService) {
        this.secteurService = secteurService;
    }

    public AbstractConverter<Secteur, SecteurVo> getSecteurConverter() {
        return secteurConverter;
    }

    public void setSecteurConverter(AbstractConverter<Secteur, SecteurVo> secteurConverter) {
        this.secteurConverter = secteurConverter;
    }

    
}
