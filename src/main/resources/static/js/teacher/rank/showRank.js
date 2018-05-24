
function showRank(id) {
    window.location="toExamRank?id=" + id;
}


$(function(){

    $.ajax({
        url : "teacher/examination/paper/rank",
        data : {"id":"${id}"},
        type : "get",
        success : function(data){
            var html = '';
            $.each(data.rank, function(i, n){
                html += '<tr><td>'+ n.userName +'</td><td>'+ n.score +'</td><td>'+ n.rank +'</td></tr>';
            });

            $("#rank").html(html);

            $("#exam_title").text(data.themeName);
        },
        error : function(){
            alert("错误");
        }
    });
});