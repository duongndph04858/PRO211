var hourEle = document.getElementById("hrMin")
var secEle = document.getElementById("sec")
var dateEle = document.getElementById("date")
var pause = false;

setInterval(function () {
    if (pause) {
        return;
    }
    var dt = new Date();
    hourEle.innerHTML = toTwoDigit(dt.getHours() % 12) + ":" + toTwoDigit(dt.getMinutes());
    secEle.innerHTML = "<span>" + toTwoDigit(dt.getSeconds()) + "</span>" + (dt.getHours() / 12 > 1 ? " P" : " A") + "M";
    var d  = dt.toString().slice(0,15);
    dateEle.innerHTML = d.slice(0,4) + "<span>" + d.slice(4,10) + "</span>" + d.slice(10,15);
}, 1000)

function toTwoDigit(num) {
    return (num < 10 ? "0" : "") + num;
}