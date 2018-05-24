
// 交卷
function end_paper() {
    var divs = $("div[name='itemDiv']");



    var options = [];
    $.each(divs, function(i, n) {

        var result = new Object();

        // 选项
        var option = [];
        var paperOptionId = $(this).children("[name='paperOptionId']").val();

        var results = $(this).children("[name^='options']:checked");

        $.each(results, function(i, n){
            option.push($(this).val());
        });

        result.optionId=option;
        result.paperOptionId=paperOptionId;

        options.push(result);
    });



    var examinationPaperId = $("#examinationPaperId").val();

    if (examinationPaperId == null) {
        return false;
    } else {
        $.ajax({
            url : "student/examination/paper/option/create",
            data : JSON.stringify({"options":options,"examinationPaperId":examinationPaperId}),
            type : "post",
            contentType : "application/json",
            success : function(data){

                alert("交卷成功");
                window.location = "toMenu";
            }
        });
    }
}

// 随机出题
function create_item() {
    var themeId = "${themeId}";
    $.ajax({
        url : "student/examination/paper/create",
        data : {"themeId" : themeId},
        type : "get",
        success : function(data){

            $("#examinationPaperId").val(data.examinationPaperId);

            var html = '';
            $.each(data.items, function(i, n) {
                // 多选题
                if (n.itemStatus == 'MULTIPLE_CHOICE') {
                    html += '<div class="form-group" name="itemDiv">' +
                        '<input type="hidden" name="itemId" value='+ n.itemId +'>' +
                        i + '、题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +'>' +
                        '<input type="hidden" name="paperOptionId" value='+ n.paperOptionId +'>';


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

                        html += tag + '、' + z.name + ' <input type="checkbox" name="options'+ n.itemId +'" value='+ z.id +'>&nbsp;';
                    });

                    html += '</div>';
                }

                if (n.itemStatus == 'SINGLE_CHOICE' || n.itemStatus == 'TRUE_OR_FALSE') {
                    html += '<div class="form-group" name="itemDiv">' +
                        '<input type="hidden" name="itemId" value='+ n.itemId +'>' +
                        '题目： <input type="text" class="form-control" name="itemName" placeholder="题目" readonly="true" value='+ n.itemName +'>' +
                        '<input type="hidden" name="paperOptionId" value='+ n.paperOptionId +'>';

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
                        }

                        html += tag + '、' + z.name + ' <input type="radio" name="options'+ n.itemId +'" value='+ z.id +'>&nbsp;';
                    });

                    html += '</div>';
                }
            });

            $("#item").html(html);
        },
        error : function(){
            alert("该试卷已完成");
            window.location="exam";
        }
    });
}

$(function(){

    create_item();

});