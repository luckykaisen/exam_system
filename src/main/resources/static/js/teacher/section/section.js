function search(value, pageNumber) {
    var subjectId = value.value;
    if (subjectId=="请选择...") {
        return false;
    }

    $.ajax({
        url : "teacher/section/search",
        data : {"subjectId" : subjectId, "pageNumber":pageNumber, "pageSize" : 10},
        type : "post",
        success : function(data){
            $("#section").html("");
            $.each(data.sections, function(i, n){
                $("#section").append('<tr><td>' + n.id + '</td><td>'+ n.sectionName +'</td><td><a href=javascript:deleteSection('+ n.id +');>删除</a></td>' +
                    '<td><a href=javascript:modifySection('+ n.id +',"'+ n.sectionName +'");>修改</a></td><td><a href=toOption?id='+ n.id +'>试题录入</a></td></tr>');
            });
            $("#page").paging({
                pageNo:data.pageNumber,
                totalPage: data.totalPage,
                totalSize: data.totalSize,
                callback: function(num) {
                    search(value,num);
                }
            });
        },
        error : function(){
            alert("错误");
        }
    });
}

// 点击学科下拉菜单
function subject_onchange(value) {
    search(value, 1);
}

// 修改章节
function modifySection(id, name) {
    window.location="toModifySection?id=" + id + "&name=" + name;
}

// 根据id删除 章节
function deleteSection(id) {
    $.ajax({
        url : "teacher/section/delete",
        data : {"id" : id},
        type : "get",
        success : function(data){
            window.location="toSection";
        },
        error : function(){
            alert("错误");
        }
    });
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

// 添加章节
function addSection(){
    window.location="toAddSection";
}

$(function(){

    select_subject();

});
