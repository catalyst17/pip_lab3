/*function checkPic(ev){
    let $div = $(ev.target);
    let $display = $div.find('.canvas');
    let offset = $div.offset();
    let x = ev.clientX - offset.left;
    let y = ev.clientY - offset.top;
    let xInp = document.getElementById("xPic"),
        yInp = document.getElementById("yPic");
    xInp = x;
    yInp = y;
    document.getElementById("hdnBtn").click();
}*/

$('.canvas').bind('click', function (ev) {
    let $div = $(ev.target);
    let $display = $div.find('.canvas');
    let offset = $div.offset();
    let x = ev.clientX - offset.left;
    let y = ev.clientY - offset.top;
    /*let xInp = document.getElementById("xPic"),
        yInp = document.getElementById("yPic");
    xInp.value = x;
    yInp.value = y;*/
    alert(x);
    myCommand();
});
