<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

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

	<div class="container" id="main">

		<div class="navbar navbar-default">
			<div class="container">
				<a class="navbar-brand" href="/">MyWeather</a>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/weather.do">Weather</a></li>
					</ul>
				</div>
				<!-- end nav-collapse -->
			</div>
			<!-- end container -->
		</div>
		<!-- end navbar -->


		<div class="raw" id="cityNameRaw">
			<div class="col-12">
				<h2>${weather.cityName}</h2>
			</div>
		</div>
		<!-- end cityNameRaw -->


		<div class="raw" id="cityLocationRaw">
			<div class="col-4">
				<h4>Coordinates</h4>
				<p>Lon:&nbsp${weather.cityLon}</p>
				<p>Lat:&nbsp${weather.cityLat}</p>
			</div>
		</div>
		<!-- end cityLocationRaw -->


		<div class="raw" id="citySunriseSunsetRaw"></div>
		<!-- end citySunriseSunsetRaw -->


		<div class="raw" id="cityTemperatureRaw"></div>
		<!-- end cityTemperatureRaw -->


		<div class="raw" id="cityPressureRaw"></div>
		<!-- end cityPressureRaw -->


		<div class="raw" id="cityCloudsRaw"></div>
		<!-- end cityCloudsRaw -->


		<div class="raw" id="lastUpdateRaw"></div>
		<!-- end lastUpdateRaw -->

	</div>
	<!-- end container -->

	<footer> </footer>
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
		<p>${weather.windSpeed}${weather.windName}${weather.windDirection}</p>
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