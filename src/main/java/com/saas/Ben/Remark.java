package com.saas.Ben;

import javax.persistence.*;

@Entity
@Table(name = "remark")
public class Remark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer  id;
    @Column(name = "comment")
    private  String comment;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "postid")
    private  Integer  postid;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPostid(int post_id) {
        this.postid = post_id;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPostid() {
        return postid;
    }

}

