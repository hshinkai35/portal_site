/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import java.time.Clock;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rksuser
 */
@Named("bb")
@RequestScoped
public class Bb implements Serializable {
    @Id
    private Integer staffId;
    private String name;
    private String email;
    private String password;
    private String confirmedPassword;
    private Integer authorityId;
    private static final Map<String, Integer> authorities;
    static{
        authorities = new LinkedHashMap<>();
        authorities.put("エンジニア", 1);
        authorities.put("管理者", 2);
    }
    
    @EJB
    EmployeesDb db;
    @Inject
    transient Logger log;
    public Map<String, Integer> getAuthorities(){
        return authorities;
    }
    public String next(){
        if(password.equals(confirmedPassword)){
        create();
        }
        return null;
    }
    
    public void create(){
        Employees emp = new Employees(staffId, name, email, authorityId, password);
        try{
            db.create(emp);
            clear();
        }catch(Exception e){
            log.fine("新規登録できない/" + name);
        }
    }
    public void clear(){
        staffId = null;
        name = null;
        email = null;
        password = null;
        confirmedPassword = null;
        authorityId = null;
    }
    public String update(){
              
        if(password.equals(confirmedPassword)){
        Employees emp = new Employees(staffId, name, email, authorityId, password);
        try{
            db.update(emp);
            clear();
        }catch(Exception e){
            log.fine("■" + name + "|" + e.getMessage());
        }
        }
        return null;
    }
    
    public String find(){
        Employees emp = db.find(staffId);
        if(emp != null){
            this.staffId = emp.getStaffId();
            this.name = emp.getName();
            this.email = emp.getEmail();
            this.authorityId = emp.getAuthorityId();
            this.password = emp.getPassword();
        }
        return null;
    }
    public String delete(Employees emp){
        db.delete(emp);
        return null;
    }
    public String edit(Employees emp){
        staffId = emp.getStaffId();
        name = emp.getName();
        email = emp.getEmail();
        authorityId = emp.getAuthorityId();
        password = emp.getPassword();
        return null;
    }
    public String login(){
        Employees emp = db.findByEmail(email);
        if(password.equals(emp.getPassword())){
            return "index.xhtml";
        }
        return "login.xhtml";
    }
    public List<Employees> getAll(){
        return db.getAll();
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

    public EmployeesDb getDb() {
        return db;
    }

    public void setDb(EmployeesDb db) {
        this.db = db;
    }
    
    

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
    
}
