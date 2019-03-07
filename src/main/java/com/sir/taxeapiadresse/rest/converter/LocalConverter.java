/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.rest.converter;

import com.sir.taxeapiadresse.bean.Local;
import com.sir.taxeapiadresse.rest.vo.LocalVo;
import com.sir.taxeapiadresse.util.NumberUtil;
import org.springframework.stereotype.Component;



/**
 *
 * @author YOUNES
 */
@Component
public class LocalConverter extends AbstractConverter<Local, LocalVo>{

    @Override
    public Local toItem(LocalVo vo) {
          
        if (vo != null) {
            Local item = new Local();
             
              if(vo.getId()!=null){
                item.setId(vo.getId());
            }
            if (vo.getReference()!= null) {
                item.setReference(vo.getReference());
            }
           
            if (vo.getDernierMontantPaye()!= null) {
                item.setDernierMontantPaye(NumberUtil.toBigDecimal(vo.getDernierMontantPaye()));
            }
            if (vo.getDernierAnneePaye()!= null) {
                item.setDernierAnneePaye(NumberUtil.toBigDecimal(vo.getDernierAnneePaye()));
            } 
            if (vo.getDernierTrimestrePaye()!= null) {
                item.setDernierTrimestrePaye(NumberUtil.toBigDecimal(vo.getDernierTrimestrePaye()));
            }
            if(vo.getCategorieVo()!= null){
                item.setCategorie(new CategorieConverter().toItem(vo.getCategorieVo()));
              
            }  
             if(vo.getRueVo()!= null){
                item.setRue(new RueConverter().toItem(vo.getRueVo()));
              
            }    
             if(vo.getRedevableVo()!= null){
                item.setRedevable(new RedevableConverter().toItem(vo.getRedevableVo()));
              
            }    
            if(vo.getSurface()!= null){
                item.setSurface(NumberUtil.toBigDecimal(vo.getSurface()));
            }
            return item;
        }
        return null;
    }

    @Override
    public LocalVo toVo(Local item) {
          if (item != null) {
            LocalVo vo = new LocalVo();
             
              if(item.getId()!=null){
                vo.setId(vo.getId());
            }
            if (item.getReference()!= null) {
                vo.setReference(item.getReference());
            }
           
            if (item.getDernierMontantPaye()!= null) {
                vo.setDernierMontantPaye(NumberUtil.toString(item.getDernierMontantPaye()));
            }
            if (item.getDernierAnneePaye()!= null) {
                vo.setDernierAnneePaye(NumberUtil.toString(item.getDernierAnneePaye()));
            } 
            if (item.getDernierTrimestrePaye()!= null) {
                vo.setDernierTrimestrePaye(NumberUtil.toString(item.getDernierTrimestrePaye()));
            }
            if(item.getCategorie()!= null){
                vo.setCategorieVo(new CategorieConverter().toVo(item.getCategorie()));
            }     
              if(item.getRue()!= null){
                vo.setRueVo(new RueConverter().toVo(item.getRue()));
            }    
              if(item.getRedevable()!= null){
                vo.setRedevableVo(new RedevableConverter().toVo(item.getRedevable()));
            }    
            if(item.getSurface()!= null){
                vo.setSurface(NumberUtil.toString(item.getSurface()));
            }
            return vo;
        }
        return null;
    }

    

}
