function logout() {
    $.ajax({
        url : "logout",
        data : "",
        type : "post",
        success : function(data){
            if (data.message == '成功') {
                window.location="toLogin";
            } else {
                alert(data.message);
            }
        },
        error : function(){
            alert("错误");
        }
    });
}