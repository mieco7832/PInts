//Sidebar
function toggleMenu() {
    var sidebar = document.getElementById("sidebar");
    var content = document.getElementById("content");
    if (sidebar.style.display === "none") {
        sidebar.style.display = "block";
        content.style.marginLeft = "200px";
    } else {
        sidebar.style.display = "none";
        content.style.marginLeft = "0px";
    }
}

//Tablas
document.getElementByTagName("table").style.zIndex = "1";