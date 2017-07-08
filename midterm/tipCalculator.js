var $=function(id)
{
	return document.getElementById(id);
}

var calculateClick = function()
{
	var billamt=parseFloat($("bill_amount").value);
	var percenttip=parseFloat($("percentage").value);

	var tip=billamt*(percenttip/100);
	var total=tip+billamt;
	$("tip").value=tip.toFixed(2);
	$("totalamount").value=total.toFixed(2);
}

window.onload=function()
{
	$("calculate").onclick=calculateClick;
	$("billamt").focus();
}