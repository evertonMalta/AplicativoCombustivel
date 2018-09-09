package com.app.trabalho.everton.combustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editAlc = (EditText)findViewById(R.id.editAlcohol);
        this.mViewHolder.editGas = (EditText)findViewById(R.id.editGasoline);
        this.mViewHolder.textResult = (TextView)findViewById(R.id.textResult);
        this.mViewHolder.btnCalculate = (Button)findViewById(R.id.btnCalculate);
        this.mViewHolder.textValue = (TextView)findViewById(R.id.textValueResultado);
        this.mViewHolder.btnCalculate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btnCalculate){
            if(this.mViewHolder.editGas.getText().toString().trim().equals("") ||
                    this.mViewHolder.editAlc.getText().toString().trim().equals("")){
                Toast.makeText(this, "Valores incorretos",Toast.LENGTH_SHORT).show();
            }else{
                double valueGas =Double.valueOf(this.mViewHolder.editGas.getText().toString());
                double valueAlc =Double.valueOf(this.mViewHolder.editAlc.getText().toString());


                if((valueAlc/valueGas)<0.7){
                    this.mViewHolder.textResult.setText("Álcool");
                }else{
                    this.mViewHolder.textResult.setText("Gasolina");
                }
                this.mViewHolder.textValue.setText(String.format("%.2f",valueAlc/valueGas));


            }
        }
    }


    private class ViewHolder{
        EditText editGas;
        EditText editAlc;
        TextView textResult;
        Button btnCalculate;
        TextView textValue;
    }
}
//alcool/ gasolin== se for mer q 0,7 alcoll se for mairo gasolina
