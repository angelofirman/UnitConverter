import java.util.HashMap;
import java.util.Map;


public class Constant {
	// Flags to distinct Temperature unit with Volume unit
	public static final int TEMPERATURE_FLAG = 1;
	public static final int VOLUME_FLAG      = -1;
	
	// Define supported temperature units
	public static final String TEMP_KELVIN     = "k";
	public static final String TEMP_CELCIUS    = "c";
	public static final String TEMP_FAHRENHEIT = "f";
	
	//Define supported volume units
	public static final String VOL_MILLILITRE = "ml";
	public static final String VOL_LITRE      = "l";
	public static final String VOL_GALLON     = "us_gal";
	
	// Put supported units here
	public static final HashMap<String, Integer> UNIT_MAP = new HashMap<String, Integer>(){
		{
			put(TEMP_KELVIN, TEMPERATURE_FLAG);
			put(TEMP_CELCIUS, TEMPERATURE_FLAG);
			put(TEMP_FAHRENHEIT, TEMPERATURE_FLAG);
			
			put(VOL_MILLILITRE, VOLUME_FLAG);
			put(VOL_LITRE, VOLUME_FLAG);
			put(VOL_GALLON, VOLUME_FLAG);
		}
	};
	
	// Define supported temperature conversions here
	public static final int unsupportedConversion = -1;
	public static final int celciusToCelcius    = 1;
	public static final int celciusToFahrenheit = 2;
	public static final int celciusToKelvin     = 3;
	public static final int kelvinToKelvin      = 4;
	public static final int kelvinToCelcius     = 5;
	public static final int kelvinToFahrenheit  = 6;
	public static final int fahrenheitToFahrenheit = 7;
	public static final int fahrenheitToCelcius    = 8;
	public static final int fahrenheitToKelvin     = 9;
	
	// Define supported volume conversions here
	public static final int litreToLitre           = 51;
	public static final int litreToMillilitre      = 52;
	public static final int litreToGallon          = 53;
	public static final int millilitreToMillilitre = 54;
	public static final int millilitreToLitre      = 55;
	public static final int millilitreToGallon     = 56;
	public static final int gallonToGallon         = 57;
	public static final int gallonToLitre          = 58;
	public static final int gallonToMillilitre     = 59;
	
	public static final HashMap<String, Integer> CONVERSION_MAP = new HashMap<String, Integer>(){
		{
			put(TEMP_KELVIN.concat(TEMP_KELVIN), kelvinToKelvin);
			put(TEMP_KELVIN.concat(TEMP_CELCIUS), kelvinToCelcius);
			put(TEMP_KELVIN.concat(TEMP_FAHRENHEIT), kelvinToFahrenheit);

			put(TEMP_CELCIUS.concat(TEMP_CELCIUS), celciusToCelcius);
			put(TEMP_CELCIUS.concat(TEMP_KELVIN), celciusToKelvin);
			put(TEMP_CELCIUS.concat(TEMP_FAHRENHEIT), celciusToFahrenheit);

			put(TEMP_FAHRENHEIT.concat(TEMP_FAHRENHEIT), fahrenheitToFahrenheit);
			put(TEMP_FAHRENHEIT.concat(TEMP_KELVIN), fahrenheitToKelvin);
			put(TEMP_FAHRENHEIT.concat(TEMP_CELCIUS), fahrenheitToCelcius);
			
			put(VOL_MILLILITRE.concat(VOL_MILLILITRE), millilitreToMillilitre);
			put(VOL_MILLILITRE.concat(VOL_GALLON), millilitreToGallon);
			put(VOL_MILLILITRE.concat(VOL_LITRE), millilitreToLitre);

			put(VOL_LITRE.concat(VOL_LITRE), litreToLitre);
			put(VOL_LITRE.concat(VOL_GALLON), litreToGallon);
			put(VOL_LITRE.concat(VOL_MILLILITRE), litreToMillilitre);

			put(VOL_GALLON.concat(VOL_GALLON), gallonToGallon);
			put(VOL_GALLON.concat(VOL_LITRE), gallonToLitre);
			put(VOL_GALLON.concat(VOL_MILLILITRE), gallonToMillilitre);
		}
	};
}
