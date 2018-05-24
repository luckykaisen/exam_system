
function showRank(id) {
    window.location="toExamRank?id=" + id;
}

function search (pageNumber) {
    // 查询所有考试记录
    $.ajax({
        url : "teacher/examination/theme/search",
        data : {"pageNumber":pageNumber,"pageSize":10},
        type : "post",
        success : function(data){
            var html = '';
            $.each(data.themes, function(i, n){
                html += '<tr><td>'+ n.id +'</td><td>'+ n.themeName +'</td><td>'+ n.subjectName +'</td><td><a href=toModifyPaper?id='+ n.id +'>修改</a></td></tr>';
            });

            $("#rank").html(html);

            $("#page").paging({
                pageNo:data.pageNumber,
                totalPage: data.totalPage,
                totalSize: data.totalSize,
                callback: function(num) {
                    search(num);
                }
            });
        },
        error : function(){
            alert("错误");
        }
    });
}

$(function(){
    search(1);

});