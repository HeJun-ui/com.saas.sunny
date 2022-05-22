package com.saas.Utils;

import com.saas.Ben.Post;
import com.saas.Ben.Remark;
import com.saas.Service.imp.PostServiceImpl;
import com.saas.Service.imp.RemarkServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDeam {
    @Autowired
    RemarkServiceImpl remarkService;
    @Autowired
    PostServiceImpl postService;
    @Test
    public void Test01()
    {
//        Remark remark=new Remark();
//        remark.setUser_id(2);
//        remark.setComment("testtest");
//        remark.setPostid(2);
//        remarkService.SaveRemark(remark);
//
//        List<Remark> remarkList=remarkService.findRemark(2);
//        for (Remark re : remarkList ) {
//            System.out.println(re.getComment());
        Post postList=postService.findById(7);
//        }
        System.out.println(postList.getCreatetime());
    }
}
