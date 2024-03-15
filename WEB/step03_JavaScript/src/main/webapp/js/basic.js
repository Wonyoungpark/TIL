document.write("<h2 style='color:blue'>출력</h2>");

document.write("<h4>출력2</h4>");

function mouseOver(th) {
    console.log("마우스 오버 th=" + th);
    th.style.backgroundColor = 'red';
    th.style.color = 'white';
}

function mouseOut(th) {
    console.log("마우스 아웃 th=" + th)
    th.style.backgroundColor = 'black';
    th.style.color = 'white';
}