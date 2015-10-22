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
import javax.persistence.TypedQuery;

/**
 *
 * @author hiroshishinkai
 */
@Stateless
public class BbsContextDb {
    @PersistenceContext
    private EntityManager em;
    
    public void create(BbsContext bbsContext){
        em.persist(bbsContext);
    }
    public List<BbsContext> findByBbsId(Long bbsId){
        TypedQuery tq = em.createNamedQuery(BbsContext.findByBbsId, BbsContext.class);
        tq.setParameter("bbsId", bbsId);
        List<BbsContext> bbsContextList = tq.getResultList();
        return bbsContextList;
    }
}
