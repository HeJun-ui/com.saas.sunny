package com.saas.Service.imp;

import com.alibaba.fastjson.JSONObject;
import com.saas.Ben.Post;
import com.saas.Dao.PostDao;
import com.saas.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

   @Autowired
    private PostDao postDao;

    /**
     * 查询全部发帖
     * @return
     */
    public List<Post> findAll() {
        return postDao.findAll();
    }


    /**
     * 查询文章信息
     */
    public Post findById(int id) {
        return postDao.findById(id);

    }

    /**
     * 保存发帖
     * @param post
     * @return
     */

    public JSONObject SavePost(Post post)
    {
          JSONObject jsonObject=new JSONObject();
        try {
            postDao.save(post);
            jsonObject.put("message",200);
           return  jsonObject;
        }catch(Exception e)
        {
            jsonObject.put("message",500);
            e.printStackTrace();
            return  jsonObject;

        }
    }

}
