package com.saas.Ben;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@EntityListeners(value = AuditingEntityListener.class)
@Entity
@Table(name = "post")
public class Post {
    public void setId(int id) {
        this.id = id;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "type")
    private String type;

    @CreatedDate
    @Column(name = "createtime")
    private Date createtime;
    @LastModifiedBy
    @Column(name = "updatetime")
    private Date updatetime;


    public String getCreatetime() {
        //格式化Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("发布于yyyy年MM月dd日");
        return sdf.format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdate_time(Date update_time) {
        this.updatetime = update_time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getType() {
        return type;
    }


}
