package com.saas.Service;

import com.saas.Ben.Content;
import com.saas.Ben.Remark;

import java.util.List;

public interface RemarkService {
    void SaveRemark(Remark remark);
    List<Remark> findRemark(int id);
    List<Content> findAllRemark(Integer id);
}
