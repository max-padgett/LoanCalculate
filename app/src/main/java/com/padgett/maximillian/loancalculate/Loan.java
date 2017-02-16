package com.padgett.maximillian.loancalculate;



/**
 * Created by Maximillian Padgett on 2/15/2017. A mobile app for calculating loans
 */

public class Loan {

    //Data Members
    private double loanAmount = 0.0;
    private double interestRate = 0.0;
    private double[] years = {5,10,15,20,25,30};
    private double[] yearAmount = {0.0,0.0,0.0,0.0,0.0,0.0};


    public Loan(){
        loanAmount = 0.0;
        interestRate = 0.0;

    }

    //getters
    public double getLoanAmount(){
        return loanAmount;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public double getMonthly(int i){
        return yearAmount[i];
    }
    public void setLoanAmount(double l){
        loanAmount = l;
    }
    public void setInterestRate(double iR){
        interestRate = iR;
    }

    public void calc(){
        for(int i = 0; i < years.length; i++){
            yearAmount[i] = (loanAmount*(Math.pow((1+((interestRate/100)/1)),years[i])))/(12*years[i]);
        }
    }
}
