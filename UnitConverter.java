
public class UnitConverter {
	
	
	private int getConversionFormula(String inputUnit, String outputUnit){
		// Normalize inputUnit and outputUnit
		String input = inputUnit.toLowerCase().replaceAll(" ", "");
		String output = outputUnit.toLowerCase().replaceAll(" ", "");
		String keyConversion = input.concat(output);
		
		// If input or output unit is not in UNIT_MAP, return immediately
		if(!Constant.UNIT_MAP.containsKey(input) || !Constant.UNIT_MAP.containsKey(output)){
			return Constant.unsupportedConversion;
		}
		
		 int unitFlag = Constant.UNIT_MAP.get(input) + Constant.UNIT_MAP.get(output);
		 
		 if(unitFlag > Constant.TEMPERATURE_FLAG || unitFlag < Constant.VOLUME_FLAG){
			 return Constant.CONVERSION_MAP.get(keyConversion);
		 }else{
			 return Constant.unsupportedConversion;
		 }
	}
	
	// Temperature conversion formula is referenced from: www.allmeasures.com/temperature.html
	// Volume conversion formula is referenced from: www.unitconverters.net/volume-converter.html
	public double convertUnit(double inputValue, String inputUnit, String outputUnit){
		int conversionFormula = getConversionFormula(inputUnit, outputUnit);
		
		switch(conversionFormula){
		   case Constant.celciusToCelcius : { return inputValue;}
		   case Constant.celciusToKelvin  : {return inputValue + 273.15;}
		   case Constant.celciusToFahrenheit : {return (((inputValue*9)/5)+32);}
		   
		   case Constant.kelvinToKelvin : {return inputValue;}
		   case Constant.kelvinToCelcius: {return inputValue - 273.15;}
		   case Constant.kelvinToFahrenheit: {return ((((inputValue-273.15)*9)/5)+32);}
		   
		   case Constant.fahrenheitToFahrenheit: {return inputValue;}
		   case Constant.fahrenheitToCelcius: {return (((inputValue-32)*5)/9);}
		   case Constant.fahrenheitToKelvin: {return ((((inputValue-32)*5)/9)+273.15);}
		   
		   case Constant.litreToLitre: {return inputValue;}
		   case Constant.litreToMillilitre: {return inputValue*1000;}
		   case Constant.litreToGallon: {return inputValue*0.265;}
		   
		   case Constant.millilitreToMillilitre: {return inputValue;}
		   case Constant.millilitreToLitre: {return inputValue/1000;}
		   case Constant.millilitreToGallon: {return inputValue*0.000265;}
		   
		   case Constant.gallonToGallon: {return inputValue;}
		   case Constant.gallonToLitre: {return inputValue*3.785;}
		   case Constant.gallonToMillilitre: {return inputValue*3785.411;}
		   
		   default : return Constant.unsupportedConversion;
		}
	}
}
