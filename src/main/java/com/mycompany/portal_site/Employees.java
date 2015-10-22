/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rksuser
 */
@Entity
@Table(name="employees")
@NamedQueries({
    @NamedQuery(name=Employees.findByEmail, query="SELECT c FROM Employees c WHERE c.email = :email")
})
public class Employees implements Serializable {
    
    public static final String findByEmail = "findByEmail";
    
    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "staff_id")
    private Integer staffId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "authority_id")
    private Integer authorityId;
    @Column(name = "password")
    private String password;
    
    public Employees(){}
//    public Employee(String name, String email, Integer authorityId, String password){
//        this.name = name;
//        this.email = email;
//        this.authorityId = authorityId;
//        this.password = password;
//    }
    public Employees(Integer staffId, String name, String email, Integer authorityId, String password){
        this.staffId = staffId;
        this.name = name;
        this.email = email;
        this.authorityId = authorityId;
        this.password = password;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
