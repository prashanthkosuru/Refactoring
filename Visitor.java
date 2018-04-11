public class Salesman implements Visitable{
	
	private double totalSalesAmount;
	private int newCustomers;
	
	public Salesman(double totalSalesAmount, int newCustomers) {
		this.totalSalesAmount = totalSalesAmount;
		this.newCustomers = newCustomers;
	}

	public double accept(Visitor visitor){
		
		return visitor.visit(this);
		
	}

	// Getters & Setters

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	public int getNewCustomers() {
		return newCustomers;
	}

	public void setNewCustomers(int newCustomers) {
		this.newCustomers = newCustomers;
	}

}

public class YearlyBonusVisitor implements Visitor{

	public double visit(SalesTrainee trainee) {
		
		System.out.println("Trainees Yearly Bonus");
		
		// Find bonus percentage using ternary operator
		
		double yearlyBonusPercentage = (trainee.getSickDays() < 10 && trainee.getFailedTests() < 2) ? .10 : .02;
		
		double yearlyBonusAmount = trainee.getSalary() * yearlyBonusPercentage;
		
		return yearlyBonusAmount;

	}

	public double visit(Salesman salesman) {
		
		System.out.println("Salesmans Yearly Bonus");
		
		double yearlyBonusPercentage = (salesman.getTotalSalesAmount() > 100000 && salesman.getNewCustomers() > 50) ? .12 : .04;
		
		double yearlyBonusAmount = salesman.getTotalSalesAmount() * yearlyBonusPercentage;
		
		return yearlyBonusAmount;
		
	}

	public double visit(Boss boss) {
		
		System.out.println("Bosses Yearly Bonus");
		
		double yearlyBonusPercentage = (boss.getOfficeExpenses() < 50000 && boss.getNewCustomers() > 1000) ? .15 : .04;
				
		double yearlyBonusAmount = boss.getTotalSalesAmount() * yearlyBonusPercentage;
				
		return yearlyBonusAmount;
		
	}

}


public class TestBonusCalculator {

	public static void main(String[] args){
		
		// We can have completely different calculations performed
		// on completely different objects just by defining a
		// new concrete Visitor
		
		YearlyBonusVisitor yearlyBonusCalculator = new YearlyBonusVisitor();
		
		SalesTrainee bradTrainee = new SalesTrainee(5, 1, 20000);
		Salesman tomSalesman = new Salesman(150000, 62);
		Boss rossBoss = new Boss(1000000, 1200, 4000000);
		
		System.out.println("YEARLY BONUS");
		
		System.out.println(bradTrainee.accept(yearlyBonusCalculator));
		System.out.println(tomSalesman.accept(yearlyBonusCalculator));
		System.out.println(rossBoss.accept(yearlyBonusCalculator));
		
		// Calculate Quarterly Bonus
		
		QuarterlyBonusVisitor quarterlyBonusCalculator = new QuarterlyBonusVisitor();
		
		bradTrainee = new SalesTrainee(1, 0, 20000);
		tomSalesman = new Salesman(30000, 22);
		rossBoss = new Boss(200000, 300, 11000);
		
		System.out.println("\nQUARTERLY BONUS");
		
		System.out.println(bradTrainee.accept(quarterlyBonusCalculator));
		System.out.println(tomSalesman.accept(quarterlyBonusCalculator));
		System.out.println(rossBoss.accept(quarterlyBonusCalculator));
		
	}
	
}