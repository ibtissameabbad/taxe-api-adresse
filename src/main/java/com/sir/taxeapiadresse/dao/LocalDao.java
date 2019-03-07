/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxeapiadresse.dao;

import com.sir.taxeapiadresse.bean.Local;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface LocalDao extends JpaRepository<Local, Long>{
    public List<Local> findByRedevableCin(String cin);
    public Local findByReference(String reference);

}
