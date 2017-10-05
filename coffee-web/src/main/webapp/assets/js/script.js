function enabledInput (id){

    var allCheckboxes = document.getElementsByTagName('input');
    var button = document.getElementById('button');
    var checkbox = document.getElementById('checkbox' + id);
    var text = document.getElementById('text' + id);
    var span = document.getElementById('span' + id);

    var checked = 0;

    for(var i = 0; i < allCheckboxes.length; i++){
        if(allCheckboxes[i].type == 'checkbox' && allCheckboxes[i].checked == true)
            checked++;
    }

    if(checked == 0){
        button.disabled = true;
    } else button.disabled = false;


    if(checkbox.checked == true){
        text.disabled = false;
    } else {
        text.disabled = true;
        span.innerHTML = "";
    }
}