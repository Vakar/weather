<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather</title>

<%@ include file="common/css.jspf"%>

</head>
<body>

	<%@ include file="common/navigationbar.jspf"%>

	<div class="container" id="main">

		<div class="raw" id="cityNameRaw">
			<div class="col-12">
				<h2 align="center">${weather.cityName}</h2>
			</div>
		</div>

		<div class="raw" id="weatherData">
			<div class="col-sm-4" id="Location">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title" align="center">Location</h3>
					</div>
					<p>longitude&nbsp;${weather.cityLon}</p>
					<p>latitude&nbsp;${weather.cityLat}</p>
					<p>sunrise&nbsp;${weather.sunRise}</p>
					<p>sunset&nbsp;${weather.sunSet }</p>
				</div>
			</div>
			<div class="col-sm-4" id="Conditions">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title" align="center">Conditions</h3>
					</div>
					<p>temperature&nbsp;${weather.temperatureValue}&nbsp;${weather.temperatureUnit }</p>
					<p>humidity&nbsp;${weather.humidityValue}&nbsp;${weather.humidityUnit}</p>
					<p>pressure&nbsp;${weather.pressureValue}&nbsp;${weather.pressureUnit}</p>
					<p>clouds&nbsp;${weather.cloudsName}</p>
				</div>
			</div>
			<div class="col-sm-4" id="Wind">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title" align="center">Wind</h3>
					</div>
					<p>wind&nbsp;speed&nbsp;${weather.windSpeed}</p>
					<p>wind&nbsp;direction&nbsp;${weather.windDirection}</p>
					<p>wind&nbsp;name&nbsp;${weather.windName}</p>
					<p>&nbsp;</p>
				</div>
			</div>
		</div>
	</div>

	<div class="raw">
		<div class="col-12">
			<h5 align="center">last&nbsp;update&nbsp;${weather.lastUpdate}</h5>
		</div>
	</div>

	<%@ include file="common/footer.jspf"%>
	<%@ include file="common/js.jspf"%>

</body>
</html>