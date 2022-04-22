package com.saas.Service.imp;

import com.saas.Ben.Post;
import com.saas.Dao.PostDao;
import com.saas.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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
     * 保存发帖
     * @param post
     * @return
     */
    public Map<Integer,String> SavePost(Post post,Map map)
    {

        try {
            postDao.save(post);
            map.put(0,"success");
           return  map;
        }catch(Exception e)
        {
            map.put(1,"failed");
            e.printStackTrace();
            return  map;

        }
    }
}
