import static org.junit.Assert.*;

import org.junit.Test;


public class TestUnitConverter {
	public static final int EPSILON_VALUE = 0;

	@Test
	public void test() {
		UnitConverter convert = new UnitConverter();
			
		// Ensure the flag matches what it supposed to
		assertEquals(Constant.TEMPERATURE_FLAG, (int)Constant.UNIT_MAP.get(Constant.TEMP_CELCIUS));
		assertEquals(Constant.TEMPERATURE_FLAG, (int)Constant.UNIT_MAP.get(Constant.TEMP_FAHRENHEIT));
		assertEquals(Constant.TEMPERATURE_FLAG, (int)Constant.UNIT_MAP.get(Constant.TEMP_KELVIN));
		assertEquals(Constant.VOLUME_FLAG, (int)Constant.UNIT_MAP.get(Constant.VOL_LITRE));
		assertEquals(Constant.VOLUME_FLAG, (int)Constant.UNIT_MAP.get(Constant.VOL_MILLILITRE));
		assertEquals(Constant.VOLUME_FLAG, (int)Constant.UNIT_MAP.get(Constant.VOL_GALLON));
		
		String inputUnit = Constant.VOL_LITRE;
		String outputUnit = Constant.VOL_MILLILITRE;
		double inputValue = 1;
		double outputValue = convert.convertUnit(inputValue, inputUnit, outputUnit);
		assertNotSame(Constant.unsupportedConversion, outputValue); // successfully convert 1 litre to millilitre
		
		// Unsupported unit is not allowed
		inputUnit = "Test";
		outputValue = convert.convertUnit(inputValue, inputUnit, outputUnit); // inputValue = 1, inputUnit = "Test", outputUnit = "ml"
		assertSame(Constant.unsupportedConversion, (int) outputValue);
		
		// Mixing conversion is not allowed
		inputUnit = Constant.TEMP_CELCIUS;
		outputValue = convert.convertUnit(inputValue, inputUnit, outputUnit); // inputValue = 1, inputUnit = "c", outputUnit = "ml"
		assertSame(Constant.unsupportedConversion, (int) outputValue);
		
		// Converting Celcius to Fahrenheit successfully
		outputUnit = Constant.TEMP_FAHRENHEIT;
		outputValue = convert.convertUnit(inputValue, inputUnit, outputUnit); // inputValue = 1, inputUnit = "c", outputUnit = "f"
		assertEquals(33.8, (double)outputValue, EPSILON_VALUE);
		
		// Same input and output conversion should result in output value equals to input value
		outputUnit = Constant.TEMP_CELCIUS;
		outputValue = convert.convertUnit(inputValue, inputUnit, outputUnit); // inputValue = 1, inputUnit = "c", outputUnit = "c"
		assertEquals(inputValue, (int) outputValue, EPSILON_VALUE);
	}

}
