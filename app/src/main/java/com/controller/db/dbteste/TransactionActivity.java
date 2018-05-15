package com.controller.db.dbteste;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.controller.db.dbteste.Objects.Transaction;

public class TransactionActivity extends AppCompatActivity {

    private EditText valueEditText;
    private EditText dateEditText;
    private ToggleButton transactionToggleButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button cleanButton;
    private Button ContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        valueEditText = (EditText)this.findViewById(R.id.ValueEditText);
        dateEditText = (EditText)this.findViewById(R.id.DateEditText);
        transactionToggleButton = (ToggleButton) this.findViewById(R.id.TransactionToggleButton);
        radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) this.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) this.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) this.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) this.findViewById(R.id.radioButton4);
        cleanButton = (Button) this.findViewById(R.id.ClenaButton);
        ContinueButton = (Button) this.findViewById(R.id.ContinueButton);

        transactionToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radioButton1.setText("Dinheiro");
                    radioButton2.setText("Credito");
                    radioButton3.setText("Debito");
                    radioButton4.setText("Ifood");
                }else{
                    radioButton1.setText("Carne");
                    radioButton2.setText("Pão");
                    radioButton3.setText("Pagamento");
                    radioButton4.setText("Outros");
                }
            }
        });
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueEditText.setText("");
                dateEditText.setText("");
                transactionToggleButton.setChecked(false);
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
            }
        });
        ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transaction transaction = new Transaction();
                if(valueEditText.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getBaseContext(), "Preencha todos os Campos",Toast.LENGTH_LONG);
                    return;
                }
                if(dateEditText.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getBaseContext(), "Preencha todos os Campos",Toast.LENGTH_LONG);
                    return;
                }

                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast toast = Toast.makeText(getBaseContext(), "Selecione um tipo de transação",Toast.LENGTH_LONG);
                    return;
                }
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton)  radioGroup.getChildAt(idx);
                Transaction transaction1 = new Transaction();
                transaction.setValue(Float.parseFloat(valueEditText.getText().toString()));
                if(r.getText().toString().equals("Pagamento"))transaction.setTransactionType("Pagamento");
                if(!transactionToggleButton.isChecked() && !r.getText().toString().equals("Pagamento"))transaction.setTransactionType("Compra");
                if(transactionToggleButton.isChecked())transaction.setTransactionType("Venda");
                transaction.setDescription(r.getText().toString());
                transaction.setDate(dateEditText.getText().toString());

                //chama banco de dados

            }
        });
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
    }
}