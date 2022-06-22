package com.saas.Ben;

import lombok.Data;

import javax.persistence.Entity;


@Data
public class Content extends Remark{

    /**
     * 自定义评论返回类
     */
    private String name;


    private String picture_url;
    private String comment;


    public Content(String name,String picture_url,String comment,Integer postid)
    {



        this.name=name;
        this.picture_url=picture_url;
        this.comment=comment;
        this.setPostid(postid);
    }
    public Content()
    {

    }
}
