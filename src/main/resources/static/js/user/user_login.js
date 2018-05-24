$(function(){
    // 用户异步登录
    $("#login").click(function(){

        $.ajax({
            url : "/login",
            data : $("#id_form_login").serialize(),
            type : "post",
            success : function(data){
                if (data.message == '成功') {
                    window.location="toMenu";
                } else {
                    alert(data.message);
                }
            },
            error : function(){
                alert("错误");
            }
        });
        return false;
    });
})