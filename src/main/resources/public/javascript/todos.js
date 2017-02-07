/**
 * We use this to make sure we're not trying to do stuff with the
 * elements on the page before the page is even loaded.
 *
 * The use of window.onload is slightly controversial these days, so
 * feel free to google around and replace this with a more
 * up-to-date solution if you think that would be interesting.
 */
window.onload = function() {
    console.log("The page is loaded now!");

    var element = document.getElementById('getAll');
    element.addEventListener("click", getAllTodos, true);

    var ID = document.getElementById('_id');
    ID.addEventListener("click",getTodosByID, true);

    var limitElement = document.getElementById('getLimitOfTodos');
    limitElement.addEventListener("click",getTodosByLimit, true);


}


/**
 * Function to get all the users!
 */
var getAllTodos = function() {
    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos", function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var getTodosByID = function() {
    var text = document.getElementById('input1').value;
    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos/" + text, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var getTodosByLimit = function() {
    var limitText = document.getElementById('input2').value;
    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos?limit=" + limitText, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
    // We'll take a URL string, and a callback function.
    this.get = function(aUrl, aCallback){
        var anHttpRequest = new XMLHttpRequest();

        // Set a callback to be called when the ready state of our request changes.
        anHttpRequest.onreadystatechange = function(){

            /**
             * Only call our 'aCallback' function if the ready state is 'DONE' and
             * the request status is 200 ('OK')
             *
             * See https://httpstatuses.com/ for HTTP status codes
             * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
             *  for XMLHttpRequest ready state documentation.
             *
             */
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        }

        anHttpRequest.open("GET", aUrl, true);
        anHttpRequest.send(null);
    }
}
