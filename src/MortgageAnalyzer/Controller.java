package MortgageAnalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class Controller {

    private MortgageAnalyzer mortgageAnalyzer = new MortgageAnalyzer();

    @FXML
    private TextField loanAmountField;

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField loanDurationField;

    @FXML
    private Label loanAmountLabel;

    @FXML
    private Label interestRateLabel;

    @FXML
    private Label loanDurationLabel;

    @FXML
    private Label monthlyPayementLabel;

    @FXML
    private Label interestPaidLabel;

    public void initialize() {}

    @FXML
    private void handleCalculate() {
        try {
            mortgageAnalyzer.setLoanAmount(Integer.parseInt(loanAmountField.getText()));
            mortgageAnalyzer.setAnnualInterestRate(Float.parseFloat(interestRateField.getText()));
            mortgageAnalyzer.setLoanDuration(Integer.parseInt(loanDurationField.getText()));

            if (mortgageAnalyzer.isValid()) {
                mortgageAnalyzer.calculateMortgageDetails();
                loanAmountLabel.setText("$" + mortgageAnalyzer.getLoanAmount());
                interestRateLabel.setText(mortgageAnalyzer.getAnnualInterestRate() + "%");
                loanDurationLabel.setText(String.valueOf(mortgageAnalyzer.getLoanDuration()));
                monthlyPayementLabel.setText(String.format("$%,.2f", mortgageAnalyzer.getMonthlyPayment()));
                interestPaidLabel.setText(String.format("$%,.2f", mortgageAnalyzer.getTotalInterestPaid()));
            } else {
                showAlert("Invalid input. Please enter valid values.");
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid input format. Please enter numeric values.");
        }
    }

    @FXML
    private void handleReset() {
        loanAmountField.clear();
        interestRateField.clear();
        loanDurationField.clear();
        loanAmountLabel.setText("$...");
        interestRateLabel.setText("...%");
        loanDurationLabel.setText("...");
        monthlyPayementLabel.setText("$...");
        interestPaidLabel.setText("$...");
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    private void showAlert(String message) {
        // Show an alert with the given message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mortgage Analyzer");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
