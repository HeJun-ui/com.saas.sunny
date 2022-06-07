
function upload() {
    $(function () {
            $("#fileid").click();
            $("#fileid").unbind().change(function () {
                uploadfile();
                $("#fileid").attr("type","text");
                $("#fileid").attr("value","");
                $("#fileid").attr("type","file");
            })

        }
    )
}



function uploadfile() {
    var uname= document.getElementById("uname").innerHTML;
    var form=document.getElementById("up");
    formData=new FormData(form);
    formData.append("username",uname)
   $.ajax({
            url:"http://localhost:8080/user/upload",
            type:"POST",
            data:formData,
            processData:false,
            contentType:false,
            dataType:"json",
             success:function(res) {

                if(res.message=='ok')
                 {
                     $('.showPic').attr('src',res.url);
                 }else if(res.message=='false'){
                     alert("请选择图片")
                 }else
                 {
                     alert(res.message)
                 }
                },
            error:function () {
                alert("网络异常,系统内部错误")

            }
        })
}


function showhide() {
    if (document.getElementById("load").style.display=="none"){

        document.getElementById("load").style.display="block";
    }else
    {
        document.getElementById("load").style.display="none";
    }

}
function paging(index)
{
    alert(index);


}