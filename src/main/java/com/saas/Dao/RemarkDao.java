package com.saas.Dao;

import com.saas.Ben.Content;
import com.saas.Ben.Remark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RemarkDao extends JpaRepository<Remark,Integer> {
     List<Remark> findByPostid(int id);

     @Query(value = "select new com.saas.Ben.Content(u.name,u.picture_url,r.comment,r.postid) from Remark AS r INNER JOIN Users AS u ON r.userid=u.id AND r.postid=?1")
     List<Content> queryContent(Integer postid);
}
