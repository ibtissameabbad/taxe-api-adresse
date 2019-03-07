/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.rest;

import com.sir.taxeapiadresse.bean.Local;
import com.sir.taxeapiadresse.rest.converter.LocalConverter;
import com.sir.taxeapiadresse.rest.vo.LocalVo;
import com.sir.taxeapiadresse.service.LocalService;
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
@RequestMapping({"/taxe-api/local"})
public class LocalRest {
    
    @Autowired
    LocalService localService;

    @GetMapping("/red/{cin}")
    public List<LocalVo> findByRedevableCin(@PathVariable String cin) {
        return new LocalConverter().toVo(localService.findByRedevableCin(cin));
    }
   
    @GetMapping("/reference/{reference}")
    public LocalVo findByReference(@PathVariable("reference") String reference) {
       return new LocalConverter().toVo(localService.findByReference(reference));
    }

    @PostMapping("/")
    public LocalVo creer(@RequestBody LocalVo localVo) {
        LocalConverter localConverter =new LocalConverter();
        Local myLocal = localConverter.toItem(localVo);
        Local local =localService.creer(myLocal);
        return localConverter.toVo(local);
       
    }
    @GetMapping("/all")
    public List<LocalVo> findAll() {
        return new LocalConverter().toVo(localService.findAll());
    }

    
    public LocalService getLocalService() {
        return localService;
    }

    public void setLocalService(LocalService LocalService) {
        this.localService = LocalService;
    }
    
}
