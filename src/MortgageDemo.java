
import java.util.Scanner;

public class MortgageDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Mortgage Calculator!");
        MortgageAnalyzer mortgageAnalyzer = new MortgageAnalyzer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the loan amount:");
        mortgageAnalyzer.setLoanAmount(scanner.nextInt());

        System.out.println("Please enter the annual interest rate (in %):");
        mortgageAnalyzer.setAnnualInterestRate(scanner.nextFloat());

        System.out.println("Please enter the loan duration (in months):");
        mortgageAnalyzer.setLoanDuration(scanner.nextInt());

        while (!mortgageAnalyzer.isValid()) {
            System.out.println("\nInvalid input detected. Please correct the input values.");
            mortgageAnalyzer.correctInput();
        }

        mortgageAnalyzer.calculateMortgageDetails();
        scanner.close();
    }
}