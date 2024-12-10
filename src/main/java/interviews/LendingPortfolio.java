package interviews;

import java.util.*;

public class LendingPortfolio {

    public static Map<String, Loan> loans = new HashMap<>();
    public static Set<Loan> loansSet = new TreeSet<>((l1,l2) ->  Double.compare(l1.getRisk(), l2.getRisk()));
    public static Loan highestRiskLoan;

    public static void main(String[] args) {
        

       // risk.put(loanId, getLoanRisk(loanId));


    }

    public static void addLoan(String loanId, double loanAmount, double interestRate, int termMonths){
        Loan loan = new Loan(loanId, loanAmount, interestRate, termMonths);
        loans.put(loanId, loan);
        if(highestRiskLoan == null){
            highestRiskLoan = loan;
        }
        else{
            highestRiskLoan = highestRiskLoan.risk > loan.risk ? highestRiskLoan : loan;
        }
    }
    

    public double getNthHighestRiskLoan(int nth){
        return loansSet.stream().skip(nth-1).findFirst().get().getRisk();
    }

    public double getLoanRisk(String loanId){
        return loans.get(loanId).getRisk();
    }

    private static class Loan {
        String loanId;
        double loanAmount;
        double interestRate;
        int termMonths;
        Double risk;

        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public int getTermMonths() {
            return termMonths;
        }

        public void setTermMonths(int termMonths) {
            this.termMonths = termMonths;
        }

        public Double getRisk() {
            return risk;
        }

        public void setRisk(Double risk) {
            this.risk = risk;
        }

        public Loan(String loanId, double loanAmount, double interestRate, int termMonths) {
            this.loanId = loanId;
            this.loanAmount = loanAmount;
            this.interestRate = interestRate;
            this.termMonths = termMonths;
            this.risk = loanAmount * loans.get(loanId).interestRate * loans.get(loanId).termMonths;;
        }

        
    }

    public static String getHighestRiskLoan(){

        return Double.toString(highestRiskLoan.getRisk());

    }


}
