package com.saas.Utils;

import com.saas.Ben.Content;
import com.saas.Dao.RemarkDao;
import com.saas.Service.imp.PostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest


public class TestDeam {
    @Autowired
    private RemarkDao remarkDao;
    @Autowired
    PostServiceImpl postService;
    @Test
    public void Test01()
    {

    List<Content> contentList= remarkDao.queryContent(3);
    for(Content content : contentList)
    {
        System.out.println(content.getComment()+"    111"+content.getPicture_url()+"头像"+content.getPostid()+"  ");
    }
    }

}
