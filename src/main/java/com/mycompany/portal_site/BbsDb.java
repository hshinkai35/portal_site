/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hiroshishinkai
 */
@Stateless
public class BbsDb {
    @PersistenceContext
    private EntityManager em;
    public Bbs create(Bbs bbs){
        em.persist(bbs);
        System.err.println(bbs);
        em.flush();
        System.err.println(bbs);
        return bbs;
    }
    public List<Bbs> getAll(){
        return em.createQuery("SELECT b FROM Bbs b").getResultList();
    }
    public Long getCreatebbsId(String title){
        Query q = em.createNamedQuery("Bbs.Insert");
        q.setParameter("title", title);
        Long bbsId = (Long)q.getSingleResult();
        return bbsId;
    }
}
