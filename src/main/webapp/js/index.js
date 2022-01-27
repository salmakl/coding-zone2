function next() {
    var item = document.querySelector("#select").value;
    localStorage.setItem('id', item);
}
function load () {
    let question = document.querySelector("#question").value = localStorage.getItem('id');
}