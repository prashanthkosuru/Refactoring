public class ATMAccessBad { 
	
	private String state; 
  
	public final static String CARD_ENTERED = "CARD ENTERED"; 
	public final static String VALID_CARD = "VALID CARD"; 
	
	public final static int CARD_NUMBER = 123456789;
	
	public ATMAccessBad() { state = CARD_ENTERED; }  
	
	public void verifyCard(int cardNumber) { 
		
		if (CARD_NUMBER == cardNumber) { 
			state = VALID_CARD; 
		} 
		
	}  
 
	public static void main(String[] args){
		
		ATMAccessBad user = new ATMAccessBad();
		
		System.out.println(user.state);
		
		user.verifyCard(123456789);
	
	}

}


// Type safety is very important. 
// We want to eliminate all operations on values that 
// are not of the appropriate data type by protecting
// the program from bad input.

// We can do this by replacing primitive types with classes

public class ATMAccess { 
	
	// Define a type safe field 
	
	private ATMCardState cardState;
	
	private void setState(ATMCardState cardState){
		
		this.cardState = cardState;
		
	}
	
	public ATMAccess() { 
		
		// Create type safe assignment
		
		setState(ATMCardState.CARD_ENTERED);
		
	}  
	
	public String getState() { 
		
		// REPLACED return state; 
		
		return cardState.toString();
		
	} 
	
	// 1. Encapsulation is used
	
	public void verifyCard(int cardNumber) { 
		
		if (getState().equals(ATMCardState.CARD_ENTERED.toString())){
			
			if(cardNumber == ATMCardState.CARD_NUMBER){
			
			// Create type safe assignment
			
			setState(ATMCardState.VALID_CARD);
			
			} 
		}
		
	}  
	
	
	public static void main(String[] args){
		
		ATMAccess user = new ATMAccess();
		
		System.out.println(user.getState());
		
		user.verifyCard(123456789);
		
	}
	
}

// Represents the state of a ATMAccess object

class ATMCardState{
	
	private final String name;
	
	private ATMCardState(String name){

		this.name = name;
		
	}
	
	public String toString(){
		
		return name;
		
	}
	
	// These type safe constants live in the class and can't be impersonated
	
	public final static ATMCardState CARD_ENTERED = new ATMCardState("CARD ENTERED");
	public final static ATMCardState VALID_CARD = new ATMCardState("VALID CARD");
	
	public final static int CARD_NUMBER = 123456789;
	
}

