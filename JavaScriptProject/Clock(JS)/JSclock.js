<script>
const secondHand = document.querySelector('.second-hand');
const minHand = document.querySelector('.min-hand');
const hourHand = document.querySelector('.hour-hand');

function setDate()
{
const now= new Date();
const seconds = now.getSeconds();
const secondsDegree =((seconds / 60)*360)+90;
secondHand.style.transform = `rotate(${secondsDegrees}deg)`;

const mins = now.getMinutes();
const minsDegree = ((mins / 60)*360)+90;
minHand.style.transform = `rotate(${minsDegrees}deg)`;

const hour = now.getHours();
const hourDegree = ((mins / 13)*360)+90;
minHand.style.transform = `rotate(${hourDegrees}deg)`;
}
setInterval(setDate, 10000);
setDate();

</script>


</script>
