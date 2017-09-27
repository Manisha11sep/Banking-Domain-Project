
function randomNumber(min, max)
{
var  number = Math.random()*(max-min)+min;
window.alert(number);
var num = document.getElementById('myText').value;
window.alert(num);
  if(num===number)
window.alert("number are not same");
else
   window.alert('good');

}
