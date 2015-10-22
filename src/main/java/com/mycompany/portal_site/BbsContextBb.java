/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Id;

/**
 *
 * @author hiroshishinkai
 */
@Named("bbsContextBb")
@RequestScoped
public class BbsContextBb implements Serializable{
    @Id
    private Long id;
    private String title;
    private List<String> contextList;

    @EJB
    BbsContextDb bbsContextDb;
    
    public String next(Bbs bbs){
        List<BbsContext> bbsContextList = new ArrayList<>();
        try{
        bbsContextList = bbsContextDb.findByBbsId(bbs.getId());
        
        }catch(Exception e){
            
        }
        this.id = bbs.getId();
        this.title = bbs.getTitle();
        for(BbsContext bbsContext: bbsContextList){
            this.contextList.add(bbsContext.getContext());
        }
        return "context.xhtml";
    }
    public void clear(){
        id = null;
        title = null;
        contextList = null;
        
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

    public List<String> getContextList() {
        return contextList;
    }

    public void setContextList(List<String> contextList) {
        this.contextList = contextList;
    }

    public BbsContextDb getBbsContextDb() {
        return bbsContextDb;
    }

    public void setBbsContextDb(BbsContextDb bbsContextDb) {
        this.bbsContextDb = bbsContextDb;
    }
    
    
}
