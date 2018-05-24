// 添加试题
function addItem(id) {
    window.location="toAddItem?id=" + id;
}

// 隐藏试题
function hideItem(id) {
    $.ajax({
        url : "teacher/item/hide",
        data : {"id" : id},
        type : "get",
        success : function(data){
            location.reload();
        },
        error : function(){
            alert("错误");
        }
    });
}

$(function(){

    // 查询已录试题
    $.ajax({
        url : "teacher/item/search",
        data : {"pageNumber":1,"pageSize":1000,"sectionId":"${sectionId}"},
        type : "post",
        success : function(data){
            var html = '';
            $.each(data.items, function(i, n){
                if (n.delete == 'Y') {
                    html += '<tr><td>题目: '+ n.name +'(已隐藏)</td></tr>';
                } else {
                    html += '<tr><td>题目: '+ n.name +'</td><td><button onclick=hideItem('+n.id+')>隐藏试题</button></td></tr>';
                }

                $.each(n.options, function(i, n) {
                    if (n.answer == 'Y') {
                        html += '<tr><td style="color:green">'+ (i+1)+ ' 、' +n.name+'</td></tr>';
                    } else {
                        html += '<tr><td>'+ (i+1)+ ' 、' + n.name +'</td></tr>';
                    }
                });
                html += '<tr><td>--------------------------------------------------------------------------------</td></tr>';
            });
            $("#option").html(html);

        },
        error : function(){
            alert("错误");
        }
    });
});