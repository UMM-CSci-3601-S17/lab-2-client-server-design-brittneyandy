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

}

var mainTodoFunction = function(url) {
    var HttpThingy = new HttpClient();
    HttpThingy.get("/api/todos" + url, function(returned_json){
        document.getElementById('jsonDump').innerHTML = returned_json;
    });
}

var sortByTrue = function() {
    mainTodoFunction("?orderBy=status");
}

var sortByID = function(){
    mainTodoFunction("?orderBy=_id")
}

var sortByCategory = function() {
    mainTodoFunction("?orderBy=category");
}

var sortByOwner = function() {
    mainTodoFunction("?orderBy=owner");
}

var sortByBody = function() {
    mainTodoFunction("?orderBy=Body");
}

var getAllTodos = function () {
    mainTodoFunction("");
}

var getTodosByID = function() {
    var text = document.getElementById('_id').value;
  mainTodoFunction("/" + text);
}

var getTodosByLimit = function() {
    var limitText = document.getElementById('limitNumber').value;
    mainTodoFunction("?limit=" + limitText);
    }

var getTodosByBody = function() {
    var bodyText = document.getElementById('bodyWords').value;
    mainTodoFunction("?contains=" + bodyText);
}

var getTodosByOwner = function() {
    var ownerText = document.getElementById('OwnerName').value;
    mainTodoFunction("?owner=" + ownerText);
}

var getTodosByCategory = function() {
    var categoryText = document.getElementById('categorizing').value;
    mainTodoFunction("?category=" + categoryText);
}

var getTodosByComplete = function() {
    mainTodoFunction("?status=complete");
}

var getTodosByIncomplete = function() {
    mainTodoFunction("?status=incomplete");
}

var combination = function() {
    var statusComb = document.getElementById('statusComb').value;
    var OwnerNameComb = document.getElementById('OwnerNameComb').value;
    var CategoryNameComb = document.getElementById('CategoryNameComb').value;
    var bodyComb = document.getElementById('bodyComb').value;
    var LimitComb = document.getElementById('LimitComb').value;
    var urlForOwner = "&owner=";
    var urlForCategory = "&category=";
    var urlForBody = "&body=";
    var urlForLimit = "&limit=";

    if(OwnerNameComb == ("")){
        urlForOwner= "";
    }

    if(CategoryNameComb == ("")){
        urlForCategory= "";
    }

    if( bodyComb == ("")){
        urlForBody= "";
    }

    if(LimitComb == ("")){
        urlForLimit= "";
    }

    mainTodoFunction("?status=" + statusComb + urlForOwner + OwnerNameComb + urlForCategory + CategoryNameComb + urlForBody + bodyComb + urlForLimit + LimitComb);
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
