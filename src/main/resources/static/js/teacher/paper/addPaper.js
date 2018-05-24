
// 改变学科
function subjectChange(subject){
    if (subject.value == null) {
        $("#section_form").html("");
    } else{
        $.ajax({
            url : "teacher/section/search",
            data : {"subjectId" : subject.value, "pageSize":1000, "pageNumber":1},
            type : "post",
            success : function(data){
                var html = '';
                $.each(data.sections, function(i, n) {
                    html += n.sectionName + ' <input type="checkbox" name="section_input" value='+ n.id +'><br/>';
                });

                $("#section_form").html(html);
            }
        });
    }

}

function select_subject() {
    $.ajax({
        url : "resource/service/subject",
        data : "",
        type : "get",
        success : function(data){

            $("#id_subject").append("<option>请选择...</option>");
            $.each(data, function(i, n) {

                $("#id_subject").append("<option value="+ n.id +">" + n.label + "</option>");
            });
        }
    });

}

// 提交
function add(){
    var subjectId = $("select option:selected").val();
    var checkbox = $("input[name='section_input']:checked");

    if (subjectId == "请选择...") {
        alert("请选择学科");
        return false;
    }

    // 获取选中的章节
    var sections = [];
    $.each(checkbox, function() {
        var sectionId = $(this).val();
        sections.push(sectionId);
    });

    // 试卷名称
    var paperName = $("#paperName").val();

    // 考试时间
    var paperTime = $("#paper_time").val();

    $.ajax({
        url : "teacher/examination/theme/create",
        data : JSON.stringify({"name":paperName,"subjectId":subjectId, "sections" : sections, "time" : paperTime}),
        type : "post",
        contentType : "application/json",
        success : function(data){
            window.location="toPaper";
        },
        error : function() {
//                    window.location="toPaper";
        }
    });
    return false;
}

$(function(){

    select_subject();

});