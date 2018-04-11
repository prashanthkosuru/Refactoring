// Command: Calls the right executeCalculateBill method
// based on the BillPayer type

class Waiter implements Command{
	
	BillPayer thePayer;
	
	Waiter(BillPayer thePayer){
		
		this.thePayer = thePayer;
		
	}

	public void executeCalculateBill(double amountDue) {
		
		thePayer.calculateBill(amountDue);
		
	}

}

