package com.saas.Service.imp;
import com.saas.Ben.Remark;
import com.saas.Dao.RemarkDao;
import com.saas.Service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    private RemarkDao remarkDao;

    /**
     * 保存评论
     * @param remark
     */
    public void SaveRemark(Remark remark)
    {
       remarkDao.save(remark);
    }

    @Override
    public List<Remark> findRemark(int id) {
        return remarkDao.findByPostid(id);
    }






}
