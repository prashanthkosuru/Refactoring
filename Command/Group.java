// Group BillPayers into an ArrayList
// Now you can use these BillPayers as simple commands

class CustomerGroup{

	ArrayList<BillPayer> customers;
	
	CustomerGroup(){
		
		customers = new ArrayList<BillPayer>();
		
	}
	
	public void add(BillPayer newPayer){
		
		customers.add(newPayer);
		
	}
	
	public BillPayer get(int customerIndex){
		
		return customers.get(customerIndex);
		
	}

}