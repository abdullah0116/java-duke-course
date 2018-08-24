function textUpload() {
  var input = document.getElementById("textInput");
  var inputValue = input.value;
  
  if (inputValue.length == 0) {
      alert("nothing was entered");
  } else {
    alert(inputValue);
  }

}
