

function generateMenu() {

   var apiSelect = document.getElementById("select_baseUrl");
   
   var item = document.createElement("option");
   item.setAttribute("value", "definitions/new.yaml");
   var textnode = document.createTextNode("New Core API");
   item.appendChild(textnode); 
   
   apiSelect.appendChild(item);                   
}