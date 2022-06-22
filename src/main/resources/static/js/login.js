function foLogin() {
    var oUname = document.getElementById("username");
    var oError = document.getElementById("error_box");
    var oUpass = document.getElementById("password");
    oError.innerHTML = "<br>";

    if (oUname.value.length < 6 || oUname.value.length > 12) {
        alert("用户名要6-12位")
        oError.innerHTML = "用户名要6-12位";

        return false;
    } else for (var i = 0; i < oUname.value.length; i++) {
        if ((oUname.value.charCodeAt(i) < 48) || (oUname.value.charCodeAt(i) > 57) && (oUname.value.charCodeAt(i) < 58) && (oUname.value.charCodeAt(i) > 97)) {
            alert("只能为数字和字母")
            oError.innerHTML = "只能为数字和字母";
            return false;
        }
    }
    if (oUpass.value.length < 6 || oUpass.value.length > 12) {
        alert("密码要6-12位")
        oError.innerHTML = "密码要6-12位";
        return false;
    }
    var formData = {
        username: oUname.value,
        password: oUpass.value
    };

    $.ajax({
        url: "http://localhost:8080/user/login",
        type: "POST",
        data: formData,
        success: function (res) {
          if(res.message=="ok")
          {
              alert("登录成功")
           $(".showPic").attr("src",res.url)
              alert("修改头像样式")
              $("#uname").attr("text",res.name)
              $("#show").hide();
              $(".login").hide();
              $('.mask').hide();
              $("#user_show").show();
          }else if(res.message=="false")
          {
              $("#error_box").html("账号或密码不正确")
          }
        },
        error: function (err) {

            alert("网络或系统内部异常,请稍后重试")


        }
    })


}


