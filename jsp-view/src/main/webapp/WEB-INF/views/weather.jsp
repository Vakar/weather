<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather</title>
</head>
<body>
<h3>${weather.cityName}</h3>
<p>Lon:${weather.cityLon} Lat:${weather.cityLat}</p>
<h3>Temperature</h3>
<p>${weather.temperatureValue} ${weather.temperatureUnit }</p>
<h3>Humidity</h3>
<p>${weather.humidityValue} ${weather.humidityUnit}</p>
</body>
</html>