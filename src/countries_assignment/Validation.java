package countries_assignment;

public class Validation {
	
	public static boolean menuSelectionTest(String userInput){
		boolean isValid = true;
		int temp = 0;
		
		try{
			temp = Integer.parseInt(userInput);
			if(temp > 0 && temp < 6){
				isValid = false;
			}else{
				System.out.println("Not a valid entry, please try again. Number must be 1, 2, 3, 4, or 5");
			}
		}catch(NumberFormatException e){
			System.out.println("Not a valid entry, please try again . Entry must be a number.");
		}
		
		return isValid;
	}
	
	public static boolean countryTest(String country){
		boolean isValid = true;
		
		for(int i=0; i<WriteAndRead.countries.size(); i++){
			if(country.equalsIgnoreCase(WriteAndRead.countries.get(i))){
				isValid = false;
			}
		}
		
		return isValid;
	}

}
