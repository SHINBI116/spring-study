
const saleForm = document.getElementById("sale-form");

const getRandomFruitSaleCount = 
	remainQty => Math.floor(Math.random() * remainQty + 1);

const saleBtnHandler = (e) => {
	const clickedBtn = e.target;
	const fid = clickedBtn.dataset.fid;
	const remainQty = clickedBtn.dataset.remainQty;
	const saleCount = remainQty != 0 ? getRandomFruitSaleCount(remainQty) : 0;
	
	console.dir(saleForm);
	
	saleForm.elements.fid.value = fid;
	saleForm.elements.qty.value = saleCount;
	
	saleForm.submit();
};

Array.from(document.getElementsByClassName("sale-btn"))
	.forEach(saleBtn => {
		saleBtn.addEventListener("click", saleBtnHandler);
	});