// 修改章节
function modifySection() {
    var id = $("#sectionId").val();
    var name = $("#sectionName").val();

    $.ajax({
        url : "teacher/section/modify",
        data : {"id":id,"name":name},
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