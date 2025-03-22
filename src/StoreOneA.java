public class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        double loanAmount = super.getLoanAmount();
        int loanPaymentTerm = super.getLoanPaymentTerm();
        double interestRate = super.getINTEREST_RATE();
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("LOAN DETAILS (if applicable):\n");
        sb.append("Loan Amount: ").append(loanAmount).append("\n");
        sb.append("Loan Payment Term: ").append(loanPaymentTerm).append("\n");
        sb.append("Interest Rate: ").append(interestRate).append("\n");
        sb.append("Special Customer: ").append(specialCustomer).append("\n");
        sb.append("Monthly Loan Payment: ").append(calculateLoanFinancing()).append("\n");
        return sb.toString();
    }

    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        final double DISCOUNT_RATE = 0.1;
        if (specialCustomer) {
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }
}