
function exam(id) {
    window.location="toExam?id=" + id;
}

// 查看考试详情
function detail(themeId) {
    $.ajax({
        url : "student/examination/paper/detail",
        data : {"id":themeId},
        type : "get",
        success : function(data){
            var html = '';
            $("#head").hide();
            $.each(data.items, function(i, n){
                if (n.code == 'Y') {
                    html += '<div class="form-group" name="itemDiv"><br/>' +
                        '题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +' style="color:green">';
                } else {
                    html += '<div class="form-group" name="itemDiv"><br/>' +
                        '题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +' style="color:red">';
                }


                var correct = [];
                var choose = [];

                $.each(n.options, function (a, z) {

                    var tag = '';
                    if (a == 0) {
                        tag = 'A';
                    } else if (a == 1) {
                        tag = "B";
                    } else if (a == 2) {
                        tag = "C";
                    } else if (a == 3) {
                        tag = "D";
                    } else if (a == 4) {
                        tag = "E";
                    } else if (a == 5) {
                        tag = "F";
                    }

                    html += tag + '、' + z.name + '   ';

                    if (z.answer == 'Y') {
                        correct.push(tag);
                    }
                    if (z.choice == 'Y') {
                        choose.push(tag);
                    }
                });

                html += '<br/><br/>答案 :';

                $.each(choose, function (i, n) {
                    html += n + '   ';
                });

                html += '<br/><br/>正确答案 :';

                $.each(correct, function (i, n) {
                    html += n + '   ';
                });

                html += '<br/><br/>';
            });

            $("#score").html(html);

        },
        error : function(){
            alert("错误");
        }
    });
}

// 查询所有考试记录
function select_exam(pageNumber) {
    // 查询所有考试记录
    $.ajax({
        url : "student/examination/paper/search",
        data : JSON.stringify({"pageNumber":pageNumber,"pageSize":10}),
        type : "post",
        contentType : "application/json",
        success : function(data){
            var html = '';
            $("#head").show();
            $.each(data.papers, function(i, n){
                html += '<tr><td>'+ n.themeName +'</td><td>'+ n.subjectName +'</td><td>'+ n.totalScore +'</td><td>'+ n.score +'</td><td><a href=javascript:detail('+ n.themeId +');>查看</a></td></tr>';
            });

            $("#score").html(html);

            $("#page").paging({
                pageNo:data.pageNumber,
                totalPage: data.totalPage,
                totalSize: data.totalSize,
                callback: function(num) {
                    select_exam(num);
                }
            });

        },
        error : function(){
            alert("错误");
        }
    });
}

$(function(){

    select_exam(1);
});