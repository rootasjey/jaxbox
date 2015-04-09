/**
 * 
 */
//document.addEventListener("touchstart", function(){}, true);

console.log("toto");

//This function is fired as soon as this file is loaded
(function () {
	clickMediaType();
})();

function clickMediaType() {
	var buttons = $("button");
	
	$(".albums").click(function () {
		console.log("albums");
		buttonClicked($(this), buttons);
		$(".search-container").attr("action", "search");
	});
	
	$(".artists").click(function () {
		console.log("artists");
		buttonClicked($(this), buttons);
		$(".search-container").attr("action", "searchartist");
	});
	
	$(".tracks").click(function () {
		console.log("tracks");
		buttonClicked($(this), buttons);
		$(".search-container").attr("action", "track");
	});
}

function buttonClicked(button, buttonsGroup) {
	buttonsGroup.each(function () {
		$(this).css({
			color: "black",
			background: "#fff"
		});
	});
	
	button.css({
		color: "white",
		background: "#3498DB"
	});
}

// Send an ajax request to get the repport in a html format
function sendInputRequest() {
    $.get('search?q=helloooooooooooo', function (data) {
        console.log(data);
    });
}