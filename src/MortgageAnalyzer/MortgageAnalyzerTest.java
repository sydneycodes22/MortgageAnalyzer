package MortgageAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageAnalyzerTest {

    @Test
    public void testCalculateMortgageDetails() {
        MortgageAnalyzer mortgageAnalyzer = new MortgageAnalyzer();
        mortgageAnalyzer.setLoanAmount(140000);
        mortgageAnalyzer.setAnnualInterestRate(8.0f);
        mortgageAnalyzer.setLoanDuration(360); // 30 years

        assertTrue(mortgageAnalyzer.isValid());

        mortgageAnalyzer.calculateMortgageDetails();

        assertEquals(1027.27, mortgageAnalyzer.getMonthlyPayment(), 0.01f);
        assertEquals(229817.20, mortgageAnalyzer.getTotalInterestPaid(), 0.01f);
    }
    
}
