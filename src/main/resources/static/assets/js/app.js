

function copyToClipboard(element)
{
	 
	let $temp = $("<input>");
	$("body").append($temp);
	$temp.val($(element).text()).select();
	document.execCommand("copy");
	$temp.remove();
}


function unblur(e){
	
	let reference = e.name;
	
	let element = document.querySelector("#"+reference)
	
	if(element.className == 'blur')
	{
		
		$("#"+reference).addClass('unblur');
		$("#"+reference).removeClass('blur')
		
	}else
	{
		
		$("#"+reference).addClass('blur');
		$("#"+reference).removeClass('unblur')
	}
	
	
	
}