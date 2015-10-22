/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rksuser
 */
@Stateless
public class EmployeesDb {
    @PersistenceContext
    private EntityManager em;
    public void create(Employees employee){
//        Query q = em.createNamedQuery("Employee.Regist");
//        q.setParameter("name", employee.getName());
//        q.setParameter("email", employee.getEmail());
//        q.setParameter("authorityId", employee.getAuthorityId());
//        q.setParameter("password", employee.getPassword());
//        q.executeUpdate();
        em.persist(employee);
    }
    public void update(Employees employee){
        em.merge(employee);
    }
    public Employees find(Integer staffId){
        return em.find(Employees.class, staffId);
    }
    public Employees findByEmail(String email){
        Query q = em.createNamedQuery(Employees.findByEmail);
        q.setParameter("email", email);
        Employees emp = (Employees)q.getSingleResult();
        return emp;
    }
    public void delete(Employees employee){
        em.remove(em.merge(employee));
    }
    public List<Employees> getAll(){
        return em.createQuery("SELECT c FROM Employees c").getResultList();
    }
}
