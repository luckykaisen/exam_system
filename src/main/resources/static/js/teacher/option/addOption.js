
function add() {
    var divs = $(".form-group[name='itemDiv']");


    var options = [];
    $.each(divs, function(i, n){

        var item = $(this).children("[name=item]");
        var answer = $(this).children("[name='answer']").is(":checked");

        var option = new Object();
        option.name = item.val();
        if (answer) {
            option.answer = "Y";
        } else {
            option.answer = "N";
        }
        options.push(option);
    });

    var status = $("#itemStatus option:selected").val();
    var itemName = $("#itemName").val();
    var sectionId = "${sectionId}";

    $.ajax({
        url : "teacher/item/create",
        data : JSON.stringify({"name" : itemName, "status" : status, "sectionId" : sectionId, "options" : options}),
        type : "post",
        contentType : "application/json",
        success : function(data){
            window.location = "toSection";
        },
        error : function(){
            alert("错误");
        }
    });
}

function select_item(status) {

    if (status.value == 1) {
        $("#addItem").html("");
        $("#addItem").append('<div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="0"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="1"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="2"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="3"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="4"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="checkbox" name="answer" value="5"/>' +
            '</div>');
    }

    if (status.value == 2){
        $("#addItem").html("");
        $("#addItem").append('<div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div><div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div>');
    }

    if (status.value == 3){
        $("#addItem").html("");
        $("#addItem").append('<div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div>' +
            '<div class="form-group" name="itemDiv">' +
            '<input type="text" class="form-control" name="item" placeholder="答案" >' +
            '<input type="radio" name="answer"/>' +
            '</div>');
    }
}

$(function(){

    // 查询已录试题
    $.ajax({
        url : "resource/service/item/status",
        data : "",
        type : "get",
        success : function(data){
            $.each(data, function(i, n) {
                $("#itemStatus").append('<option value='+ n.id +'>'+ n.label +'</option>');
            });
        },
        error : function(){
            alert("错误");
        }
    });
});