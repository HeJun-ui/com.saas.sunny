package com.saas.Dao;
import com.saas.Ben.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String name);
    User findByUsernameAndPassword(String name,String password);

    /**
     * 修改头像存储路径
     * @param username 用户名
     * @param picture_url 路径
     * @return
     */
    @Query(value = "update users SET picture_url=?2  where username=?1",nativeQuery = true)
    @Modifying
    @Transactional
    int  updateByPricturl(String username,String picture_url);

}
