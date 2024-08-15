/**
 * 
 */
const btn = document.getElementById("btn");
const out = document.getElementById("out");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");

btn.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();

	xhttp.addEventListener("readystatechange", (e) => {
		switch (xhttp.readyState) {
			case 1:
				console.log("open()성공");
				break;
			case 2:
				console.log("요청에 대한 응답이 도착");
				break;
			case 3:
				console.log("응답에 대한 처리를 시작");
				break;
			case 4:
				console.log("모두 완료");
				if (xhttp.status == 200) {
					out.innerText += xhttp.responseText;

					// 이후로는 자바스크립트 문법따라 자유럽게
				}
				break;
		}

	});

	xhttp.open("GET", "/rest/v1");
	xhttp.send();

});