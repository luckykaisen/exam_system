$(function(){
    // 点击注册按钮
    $("#regist_id").click(function(){
        var username = $("[name='username']").val();
        var password = $("[name='password']").val();
        var email = $("[name='email']").val();
        var phone = $("[name='phone']").val();

        if (username == null || password == null || email == null || phone == null) {
            alert("参数错误");
        }

        $.ajax({
            url : "regist",
            data : {"name" :username,"password":password,"email":email,"mobile":phone},
            success : function(data){
                if(data.message == "成功"){
                    window.location="toLogin";
                }else{
                    alert(data.message);
                }
            },
            type:"post",
            error : function(){
                alert("发送错误");
            }
        });
        return false;
    });
})