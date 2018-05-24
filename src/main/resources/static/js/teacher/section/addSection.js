
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
    var sectionName = $("#sectionName").val();

    if (subjectId == "请选择...") {
        alert("请选择学科");
        return false;
    }
    $.ajax({
        url : "teacher/section/create",
        data : {"sectionName":sectionName,"subjectId":subjectId},
        type : "post",
        success : function(data){
            window.location="toSection";
        },
        error : function() {
            window.location="toSection";
        }
    });
    return false;
}

$(function(){
    select_subject();
});