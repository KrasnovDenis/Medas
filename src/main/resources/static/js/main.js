function addFilm(){

    var title = document.getElementsByName('title')[0].value;
    var duration = parseInt(document.getElementsByName('duration')[0].value);

    if(title && duration) {
        fetch('/films',
            {method : 'POST', headers: {'Content-Type' : 'application/json'},
            body: JSON.stringify({duration: duration ,title: title})}).then(console.log)
    }
    else {
        console.log("Что то пошло не так");
    }
}

