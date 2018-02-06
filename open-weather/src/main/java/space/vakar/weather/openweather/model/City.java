package space.vakar.weather.openweather.model;

public class City {

	/** City ID */
	private int id;

	/** City name */
	private String name;
	
	/** Country code (GB, JP etc.) */
	private String country;

	/** City sunrise & sunset */
	private Sun sun;

	/** City geo location */
	private Coordinates coordinates;

}
