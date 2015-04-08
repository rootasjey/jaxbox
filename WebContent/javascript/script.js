/**
 * 
 */
document.addEventListener("touchstart", function(){}, true);

console.log("toto");

//This function is fired as soon as this file is loaded
(function () {
	//sendInputRequest();
})();

// Send an ajax request to get the repport in a html format
function sendInputRequest() {
    $.get('search?q=helloooooooooooo', function (data) {
        console.log(data);
    });
}