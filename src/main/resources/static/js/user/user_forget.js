$(function(){
    // 发送验证码
    $("#get_code_id").click(function(){
        var phone_num = $("[name='phone']").val();
        $.ajax({
            url : "email/send",
            data : {"mobile" :phone_num},
            type : "post",
            success : function(data){
                alert(data.message);
            },
            error : function(){
                alert("错误");
            }
        });
        return false;
    });

    // 点击确认按钮
    $("#regist_id").click(function(){
        var phone = $("[name='phone']").val();
        var code = $("[name='code']").val();

        $.ajax({
            url : "verify",
            data : {"mobile":phone,"code":code}
            ,
            type:"post",
            error : function(){
                alert("发送错误");
            },
            success : function (data) {
                if (data.message == "成功") {
                    window.location="user/toNewPassword";
                } else {
                    alert(data.message)
                }
            }
        });
        return false;
    });
})