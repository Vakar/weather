<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>
<body>

	<nav class="navbar navbar-default"> <a href="/"
		class="navbar-brand">OpenWeather</a>

	<ul class="nav navbar-nav">
		<li class="active"><a href="/weather.do">Weather</a></li>
	</ul>

	</nav>

	<div id="weather" class="container">
		<p>${errorMessage}</p>
		<h4>${weather.cityName}</h4>
		<p>Lon:${weather.cityLon} Lat:${weather.cityLat}</p>
		<h4>Temperature</h4>
		<p>${weather.temperatureValue}${weather.temperatureUnit }</p>
		<h4>Sunrise and Sunset</h4>
		<p>${weather.sunRise}${weather.sunSet }</p>
		<h4>Humidity</h4>
		<p>${weather.humidityValue}${weather.humidityUnit}</p>
		<h4>Pressure</h4>
		<p>${weather.pressureValue}${weather.pressureUnit}</p>
		<h4>Wind</h4>
		<p>${weather.windSpeed}${weather.windName}
			${weather.windDirection}</p>
		<h4>Clouds</h4>
		<p>${weather.cloudsValue}${weather.cloudsName}</p>
		<p>${weather.lastUpdate}</p>
	</div>

	<footer class="footer">
	<div class="container">
		<p class="text-muted"></p>
	</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>