//Fonction qui cache la page et injecte overlay.js qui va insérer l'overlay
function insertOverlay(tab){
    ///*
    chrome.tabs.executeScript(tab.id, {"code":"document.getElementsByTagName('html')[0].style.visibility = 'hidden';", "runAt":"document_start"},function(){
        chrome.tabs.executeScript(tab.id, {"file":'injectedScripts/overlay.js'});
    });
    //*/
}

//Fonction qui envoie un message à overlay.js pour détruire l'overlay et fait réapparaitre la page
function deleteOverlay(tab){
    chrome.tabs.sendMessage(tab.id, {"msg":"deleteOverlay"}, function(response){
        chrome.tabs.executeScript(tab.id, {"code":"document.getElementsByTagName('html')[0].style.visibility='visible';"}, function(){});
    });
}