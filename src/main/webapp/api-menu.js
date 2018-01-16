

function generateMenu() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            
            var yamlFiles = JSON.parse(this.responseText);  
            for (var i in yamlFiles) { 
               if(yamlFiles[i].endsWith(".yaml")) { 
                  processYamlFileURL(yamlFiles[i]); 
               }
            }  
       }
    };
    xhttp.open("GET", "./definitions/index.jsp", true);
    xhttp.send(); 
}

function processYamlFileURL(fileURL) {

   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            
            var yamlContent = this.responseText;  
            
            var ids = yamlContent.match(/(apiId:).*/g);
            if(ids && ids[0])
            {
               var idElements = ids[0].split(':');
               if(idElements.length > 1)
               {
                  var yamlId = idElements[1].trim();
                  addItemToMenu(yamlId);
               }
               
            }
            
            
       }
    };
    xhttp.open("GET", fileURL, true);
    xhttp.send(); 
}

function addItemToMenu(itemName, itemURL) {

   var apiSelect = document.getElementById("select_baseUrl");
   
   var item = document.createElement("option");
   item.setAttribute("value", itemURL);
   var textnode = document.createTextNode(itemName);
   item.appendChild(textnode); 
   
   apiSelect.appendChild(item);                   
}