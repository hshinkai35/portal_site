/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hiroshishinkai@
 */
@Entity
@Table(name="bbs")
//@NamedQueries({
//    @NamedQuery(name="Bbs.Insert", query="INSERT INTO bbs (title) VALUES(:title) returning id;")
//})
public class Bbs implements Serializable{
    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bbs_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
//    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinColumn(name="id", referencedColumnName = "bbsId")
//    private List<BbsContext> bbsContextList = new ArrayList<>();
//    @Column(name = "context")
//    private String context;
    
    public Bbs(){}
    public Bbs(Long id, String title){
        this.id = id;
        this.title = title;
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


//    public List<BbsContext> getBbsContextList() {
//        return bbsContextList;
//    }
//
//    public void setBbsContextList(List<BbsContext> bbsContextList) {
//        this.bbsContextList = bbsContextList;
//    }
//    
}
