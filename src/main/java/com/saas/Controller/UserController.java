package com.saas.Controller;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
     /**
     * 用户注册新增用户
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/insert")
    public ResponseUtil UserSave(String username, String password, char sex, int age, String name) {
        try {
            if (userService.finduser(username) == null) {
                User users = new User(sex, age, name, username, password);
                userService.saveUser(users);
            } else {
                return new ResponseUtil().requfailed("该用户名已经使用");
            }
            return new ResponseUtil().requsuccess("注册成功");
        } catch (Exception E) {
            E.printStackTrace();
            return new ResponseUtil().requfailed("失败");
        }
 }

    /**
     * 管理员查询所有用户信息
     *
     * @return
     */
    @RequestMapping("/finduser")
    public ResponseUtil findUser(HttpServletRequest request) {
        //获取headers头部信息
        String token = request.getHeader("Authorization");
        //验证token
        if (token != null) {
            DecodedJWT chack = null;
            try {
                chack = JWT.require(Algorithm.HMAC256("12306")).build().verify(token);
                List<User> userList = userService.findUser();
                return new ResponseUtil().requsuccess(userList);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseUtil().requfailed("token无效");
            }
            //以json格式返回所有用户信息
        }
        return new ResponseUtil().requfailed("token不能为空");
    }


    @Value("${file.upload.path}")
    private String filePath;
    @Value("${file.url.prefix}")
    private String uploadPath;
    @RequestMapping("/upload")
    public JSONObject upload(String username, MultipartFile file){
        System.out.println("11111111");
        //判断文件是否为空,是否超过大小
       if (file.isEmpty()) {
        return JSONObject.parseObject("{'message':'false'}");
       }else if (file.getSize()>2097152)
       {
           return JSONObject.parseObject("{'message':'图片太大,限制图片大小为2M'}");
       }
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 新建文件
        File filepath = new File(filePath, filename);
        // 判断路径是否存在，如果不存在就创建
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        JSONObject object = new JSONObject();
        // 写入文件
        try {
            file.transferTo(new File(filePath + File.separator + filename));
            userService.updateurl(username, uploadPath + filename);
            object.put("message", "ok");
            object.put("url", uploadPath + filename);
          }catch(Exception ex)
          {
             ex.printStackTrace();
            object.put("message", "系统错误");
            System.out.println("进入异常");
          return JSONObject.parseObject("{'message':'false'}");
          }

          return object;
          }
}
