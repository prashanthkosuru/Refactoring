class UseCashRegister{
	
	public static void main(String[] args){
		
		// Get the customer to use for bill calculation
		
		BillPayer sallyMay = CustomerTypePicker.getWomanOver60();
		
		// The Waiter sets the customer type so that the right 
		// executeCalculateBill method is called
		
		Waiter theWaiter = new Waiter(sallyMay);
		
		// The invoker makes sure the right method is called and
		// stores the Waiter so BillPayers assigned to Waiter
		// are available
		
		CashRegister calculateBill = new CashRegister(theWaiter);
		
		// When returnFinalBill() is called that signals that the
		// Waiter stored in CashRegister should execute method
		// executeCalculateBill
		
		calculateBill.returnFinalBill(12.00);
		
		// Calculate for Man over 60
		
		BillPayer paulThumb = CustomerTypePicker.getManOver60();
		theWaiter = new Waiter(paulThumb);
		calculateBill = new CashRegister(theWaiter);
		calculateBill.returnFinalBill(12.00);
		
		// Call commands from the BillPayer ArrayList
		
		CustomerGroup custGroup = new CustomerGroup();
		custGroup.add(CustomerTypePicker.getWomanOver60());
		custGroup.get(0).calculateBill(12.00);
		
		
	}
	
}