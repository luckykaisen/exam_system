
function update_paper() {
    var id = $("#id_paper_id").val();
    var name = $("#id_paper_name").val();
    var minute = $("#id_minute").val();

    var sectionIds = [];
    var check = $("[type='checkbox']:checked");

    $.each(check, function (i, n) {
        sectionIds.push($(this).val());
    });

    $.ajax({
        url : "teacher/examination/theme/modify",
        data : JSON.stringify({"id" : id, "themeName" : name, "minute" : minute, "sectionIds" : sectionIds}),
        type : "post",
        contentType : "application/json",
        success : function(data){
            if (data.message == '成功') {
                window.location="toPaper";
            } else {
                alert(data.message);
            }
        },
        error : function(){
            alert("错误");
        }
    });
}

function searchPaperDetail(id) {
    $.ajax({
        url : "teacher/examination/theme/detail",
        data : {"id" : id},
        type : "get",
        success : function(data){
            var detail = data.detail;
            $("#id_paper_id").val(detail.id);
            $("#id_paper_name").val(detail.themeName);
            $("#id_subject").val(detail.subjectName);
            $("#id_minute").val(detail.minute);

            var sectionIds = data.detail.sections;
            $.ajax({
                url : "teacher/section/search",
                data : {"subjectId" : detail.subjectId, "pageSize":1000, "pageNumber":1},
                type : "post",
                success : function(data){
                    $.each(data.sections, function(i, n) {
                        if (jQuery.inArray(n.id, sectionIds) != -1) {
                            $("#section").append('<div class="checkbox">' +
                                '<label>'+
                                '<input type="checkbox" value="'+ n.id +'" checked="checked">'+
                                n.sectionName +
                                '</label>'+
                                '</div>');
                        } else {
                            $("#section").append('<div class="checkbox">' +
                                '<label>'+
                                '<input type="checkbox" value="'+ n.id +'">'+
                                n.sectionName +
                                '</label>'+
                                '</div>');
                        }

                    });
                }
            });

            $.each(sections, function(i, n){
                $("#section").append('<div class="checkbox">' +
                    '<label>'+
                    '<input type="checkbox" value="'+ n.id +'">'+
                    n.sectionName +
                    '</label>'+
                    '</div>');
            });


        },
        error : function(){
            alert("错误");
        }
    });
}

$(function(){
    searchPaperDetail("${id}");
});