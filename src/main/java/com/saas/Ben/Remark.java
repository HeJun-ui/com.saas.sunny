package com.saas.Ben;

import javax.persistence.*;

@Entity
@Table(name = "remark")
public class Remark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "userid")
    private int userid;
    @Column(name = "postid")
    private Integer postid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }


}

