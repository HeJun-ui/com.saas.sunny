package com.saas.Dao;

import com.saas.Ben.Remark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemarkDao extends JpaRepository<Remark,Integer> {
     List<Remark> findByPostid(int id);
}
