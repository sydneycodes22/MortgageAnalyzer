
import java.util.Scanner;

public class MortgageAnalyzer {
    private int loanAmount;
    private float annualInterestRate;
    private int loanDuration;
    private float monthlyInterestRate;
    private float monthlyPayment;
    private float totalInterestPaid;


    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public boolean isValid() {
        return loanAmount > 0 && annualInterestRate > 0 && loanDuration > 0;
    }

    public boolean correctInput() {
        Scanner scanner = new Scanner(System.in);
        if (loanAmount <= 0) {
            System.out.println("Loan amount must be greater than 0.");
            System.out.println("Please enter a valid loan amount.");
            loanAmount = scanner.nextInt();
        }
        if (annualInterestRate <= 0) {
            System.out.println("Annual interest rate must be greater than 0.");
            System.out.println("Please enter a valid annual interest rate.");
            annualInterestRate = scanner.nextFloat();
        }
        if (loanDuration <= 0) {
            System.out.println("Loan duration must be greater than 0.");
            System.out.println("Please enter a valid loan duration.");
            loanDuration = scanner.nextInt();
        }
        scanner.close();
        return isValid();
    }
    
    public void calculateMortgageDetails() {
        System.out.println("\nCalculating mortgage details...\n");

        System.out.println("Loan Amount: $" + loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        System.out.println("Loan Duration: " + loanDuration);

        monthlyInterestRate = annualInterestRate / 100 / 12;
        monthlyPayment = (loanAmount * monthlyInterestRate * (float)Math.pow(1 + monthlyInterestRate, loanDuration)) / ((float)Math.pow(1 + monthlyInterestRate, loanDuration) - 1);
        System.out.printf("Monthly Payment: $%,.2f\n", monthlyPayment);

        totalInterestPaid = (monthlyPayment * loanDuration) - loanAmount;
        System.out.printf("Total Interest Paid: $%,.2f\n", totalInterestPaid);
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public float getTotalInterestPaid() {
        return totalInterestPaid;
    }
}
