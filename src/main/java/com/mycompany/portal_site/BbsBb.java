/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Id;

/**
 *
 * @author hiroshishinkai
 */
@Named
@RequestScoped
public class BbsBb implements Serializable {
    @Id
    private Long id;
    private String title;
    private String context;
    
    @EJB
    BbsDb bbsDb;
    @EJB
    BbsContextDb bbsContextDb;
    @Inject
    BbsContextBb bbsContextBb;
    @Inject
    transient Logger log;
    public String create(){
        Bbs bbs = new Bbs(id, title);
//        BbsContext bbsContext = new BbsContext(id, id, context);
//        System.out.println(bbsContext);
        try{
        Bbs bbsFromdb = bbsDb.create(bbs);
        BbsContext bbsContext = new BbsContext(id, bbsFromdb.getId(), context);
        bbsContextDb.create(bbsContext);
        clear();
        }catch(Exception e){
            log.fine("新規作成できない/" + title);
        }
        return null;
    }
    public void clear(){
        id = null;
        title = null;
        context = null;
    }
    public List<Bbs> getAll(){
        return bbsDb.getAll();
    }
    public void next(Bbs bbs){
        try{
        bbsContextBb.next(bbs);
        }catch(Exception e){
            
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BbsDb getDb() {
        return bbsDb;
    }

    public void setDb(BbsDb db) {
        this.bbsDb = db;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }
    
}
