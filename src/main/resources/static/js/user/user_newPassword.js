$(function(){
    // 点击注册按钮
    $("#regist_id").click(function(){
        var password1 = $("[name='password1']").val();
        var password2 = $("[name='password2']").val();

        if (password1 != password2) {
            alert("两次密码输入不一致！");
        }

        $.ajax({
            url : "user/password/modify",
            data : {"password1":password1,"password2":password2},
            type:"post",
            error : function(){
                alert("发送错误");
            },
            success : function (data) {
                if (data.message == "成功") {
                    window.location="toLogin";
                } else {
                    alert(data.message);
                }
            }
        });
        return false;
    });
    return false;
})