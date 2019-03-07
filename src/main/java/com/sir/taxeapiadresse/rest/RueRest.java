/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.rest;

import com.sir.taxeapiadresse.bean.Quartier;
import com.sir.taxeapiadresse.bean.Rue;
import com.sir.taxeapiadresse.rest.converter.RueConverter;
import com.sir.taxeapiadresse.rest.vo.RueVo;
import com.sir.taxeapiadresse.service.QuartierService;
import com.sir.taxeapiadresse.service.RueService;
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
@RequestMapping({"/taxe-api-souk/rue"})
public class RueRest {
    @Autowired
    RueService rueService;

    @GetMapping("/qua/{reference}")
    public List<RueVo> findByQuartierReference(@PathVariable String reference) {
        return new RueConverter().toVo(rueService.findByQuartierReference(reference));
    }

    @GetMapping("/reference/{reference}")
    public RueVo findByReference(@PathVariable String reference) {
        return new RueConverter().toVo(rueService.findByReference(reference));
    }

    @PostMapping("/")
    public RueVo creer(@RequestBody RueVo rueVo) {
        RueConverter rueConverter =new RueConverter();
        Rue myRue = rueConverter.toItem(rueVo);
        Rue rue =rueService.creer(myRue);
        return rueConverter.toVo(rue);
    }
      @GetMapping("/all")
    public List<RueVo> findAll() {
        return new RueConverter().toVo(rueService.findAll());
    }

    

    
}
