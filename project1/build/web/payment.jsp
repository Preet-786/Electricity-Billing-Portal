<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>

<h1 align="center" >Payment Page</h1>
<p>Online Electricity Bill Payment</p>
<div class="row">
  <div class="col-75">
      <div class="container" style="background-image: url('https://th.bing.com/th/id/R8c9d24a38f8c5977a48f2f44a8a4d3a9?rik=3iymnHDl4fn7qQ&riu=http%3a%2f%2fgetwallpapers.com%2fwallpaper%2ffull%2f9%2f4%2f8%2f101416.jpg&ehk=6ZILO2EUxpt5XDrYRSBLD1T%2bkr4Ctpb%2bYuvstKUfJsc%3d&risl=&pid=ImgRaw')" >
      <form action="servlett" method="post">
      
        <div class="row">
          <div class="col-50">
        
          

            <div class="row">
              <div class="col-50">
              
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Debit Card</label>
            <input type="text" name="name" placeholder="Name as exactly on debit card" required>
            <label for="ccnum">Debit card number</label>
            <input type="text" name="debitNumber" placeholder="Should be 16 digits" required>
           
            <div>
               <label for="cvv">CVV</label>
               <input type="text" name="cvv" placeholder="352" required>
            </div>
            </div>
          </div>
          
          <div align="center"> <input  style="width:30%" type="submit" value="Continue to checkout" class="btn"> </div>
      </form>
    </div>
  </div>

</div>
<div><a href="about.jsp">about us</a></div>
</body>
</html>