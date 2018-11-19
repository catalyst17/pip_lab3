/*function checkPic(ev){
    let $div = $(ev.target);
    let $display = $div.find('.canvas');
    let offset = $div.offset();
    let x = ev.clientX - offset.left;
    let y = ev.clientY - offset.top;
    let xInp = document.getElementById("parentForm:hdnForm:xPic"),
        yInp = document.getElementById("parentForm:hdnForm:yPic");
    xInp.value = x;
    yInp.value = y;
    document.getElementById("parentForm:hdnForm:hdnBtn").click();
    alert(x);
}*/

$("body").delegate(".canvas", "click", function (ev) {
    let $div = $(ev.target);
    let $display = $div.find(".canvas");
    let offset = $div.offset();
    let x = ev.clientX - offset.left;
    let y = ev.clientY - offset.top;
    let xInp = document.getElementById("parentForm:hdnForm:xPic"),
        yInp = document.getElementById("parentForm:hdnForm:yPic");
    xInp.value = x;
    yInp.value = y;
    document.getElementById("parentForm:hdnForm:hdnBtn").click();
    // alert(xInp.value + "   " + yInp.value);
});
