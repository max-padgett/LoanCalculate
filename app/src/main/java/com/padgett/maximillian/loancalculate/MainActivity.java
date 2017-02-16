package com.padgett.maximillian.loancalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Loan userLoan;

    private EditText loanET;
    private EditText interestRET;
    private TextView year5;
    private TextView year10;
    private TextView year15;
    private TextView year20;
    private TextView year25;
    private TextView year30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating loan model
        userLoan = new Loan();

        //input
        loanET = (EditText) findViewById(R.id.editText2);
        interestRET = (EditText) findViewById(R.id.editText3);

        //output
        year5 = (TextView) findViewById(R.id.textView11);
        year10 = (TextView) findViewById(R.id.textView12);
        year15 = (TextView) findViewById(R.id.textView13);
        year20 = (TextView) findViewById(R.id.textView14);
        year25 = (TextView) findViewById(R.id.textView15);
        year30 = (TextView) findViewById(R.id.textView16);

        //registering the listener
        loanET.addTextChangedListener(loanTextWatcher);
        interestRET.addTextChangedListener(interestRateTextWatcher);



    }

    private TextWatcher loanTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                userLoan.setLoanAmount((double)Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                userLoan.setLoanAmount(0.0);
            }
            displayMonthly();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher interestRateTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                userLoan.setInterestRate((double)
                        Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                userLoan.setInterestRate(0.0);
            }
            displayMonthly();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayMonthly(){
            userLoan.calc();
            year5.setText("$" + String.format("%.02f", userLoan.getMonthly(0)));
            year10.setText("$" + String.format("%.02f", userLoan.getMonthly(1)));
            year15.setText("$" + String.format("%.02f", userLoan.getMonthly(2)));
            year20.setText("$" + String.format("%.02f", userLoan.getMonthly(3)));
            year25.setText("$" + String.format("%.02f", userLoan.getMonthly(4)));
            year30.setText("$" + String.format("%.02f", userLoan.getMonthly(5)));
    }
}
