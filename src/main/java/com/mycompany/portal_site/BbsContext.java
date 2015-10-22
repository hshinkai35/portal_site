/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.portal_site;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hiroshishinkai
 */
@Entity
@Table(name = "bbs_context")
@NamedQueries({
    @NamedQuery(name=BbsContext.findByBbsId, query="SELECT c FROM BbsContext c WHERE c.bbsId = :bbsId")
})
public class BbsContext implements Serializable{
    
    public static final String findByBbsId = "findByBbsId";
    
    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bbs_context_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "bbs_id")
    private Long bbsId;
    @Column(name = "context")
    private String context;
//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="bbs_id", referencedColumnName = "id")
//    private Bbs bbs;
    
    public BbsContext(){}
//    public BbsContext(Long id, String context, Bbs bbs){
//        this.id = id;
//        this.bbsId = bbsId;
//        this.context = context;
//        this.bbs = bbs;
//    }
    public BbsContext(Long id, Long bbsId, String context){
        this.id = id;
        this.bbsId = bbsId;
        this.context = context;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Bbs getBbs() {
//        return bbs;
//    }
//
//    public void setBbs(Bbs bbs) {
//        this.bbs = bbs;
//    }

   


    public Long getBbsId() {
        return bbsId;
    }

    public void setBbsId(Long bbsId) {
        this.bbsId = bbsId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
