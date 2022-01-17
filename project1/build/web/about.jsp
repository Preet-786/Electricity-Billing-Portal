
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>
</head>
<body>
<div class="about-section">
  <h1>About Us Page</h1>
  <p>Hello, This is our project "Electricity Billing Portal" </p>
  <p> 
                <br> Electricity Billing System is a software-based application
                developed in Java programming language. The project aims at serving
                the department of electricity by computerizing the billing system.
                It mainly focuses on the calculation of Units consumed during the
                specified time and the money to be paid to electricity offices. 
                This computerized system will make the overall billing system easy, 
                accessible, comfortable and effective for consumers. <br> <br>
  </p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row" >
  <div class="column" align="center">
    <div class="card" >
      <img src="https://media.istockphoto.com/vectors/profile-icon-male-avatar-portrait-casual-person-vector-id530827853?k=6&m=530827853&s=612x612&w=0&h=FYnhkmLYaHjYSyTva1A72eDj5yu3sU7TUXg_BsH1Dfw=" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Malkesh Patel</h2>
        <p class="title">18BCE163</p>
        <p></p>
        <p>18bce163@nirmauni.ac.in</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  <div class="column" align="center">
    <div class="card">
      <img src="https://media.istockphoto.com/vectors/profile-icon-male-avatar-portrait-casual-person-vector-id530829125?k=6&m=530829125&s=170667a&w=0&h=kt4e9GBu-PmMf93lY19phOU2t_IoUfF790a8cITN8Ho=" alt="John" style="width:100%">
      <div class="container">
        <h2>Preet Patel</h2>
        <p class="title">18BCE167</p>
        <p></p>
        <p>18bce167@nirmauni.ac.in</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
</div>

</body>
</html>