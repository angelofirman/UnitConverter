
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnitConverter converter = new UnitConverter();
		String inputUnit = Constant.VOL_GALLON;
		String outputUnit = Constant.VOL_LITRE;
		double inputValue = 33.5;
		
		double outputValue = converter.convertUnit(inputValue, inputUnit, outputUnit);
		if(outputValue == Constant.unsupportedConversion){
			System.out.println("Unsupported conversion");
		}else{
			System.out.println(inputValue + " " + inputUnit + " is equals to " + outputValue + " " + outputUnit);			
		}

	}

}
