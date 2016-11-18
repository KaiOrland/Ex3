package com.example.kai.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1 = (EditText)findViewById(R.id.editText);
        EditText ed2 = (EditText)findViewById(R.id.editText2);
        ed1.addTextChangedListener(this);
        ed2.addTextChangedListener(this);
        Button equal = (Button)findViewById(R.id.button5);
        equal.setOnClickListener(this);
    }

    public void abc(View view){
        findViewById(R.id.editText);
        EditText ed1 = (EditText)findViewById(R.id.editText);
        String StrVar1 = ed1.getText().toString();
        int var1 = Integer.parseInt(StrVar1);

        EditText ed2 = (EditText)findViewById(R.id.editText2);
        String StrVar2 = ed2.getText().toString();
        int var2 = Integer.parseInt(StrVar1);

        switch(view.getId())
        {
            case R.id.button:
                result = var1+var2;
                break;
            case R.id.button2:
                result = var1-var2;
                break;
            case R.id.button3:
                result = var1*var2;
                break;
            case R.id.button4:
                result = (double)(var1/var2);
                break;
            default:
                result = 0;
                break;
        }

        }



    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        EditText ed1 = (EditText)findViewById(R.id.editText);
        EditText ed2 = (EditText)findViewById(R.id.editText2);
        changeButtonState((!ed1.getText().toString().isEmpty())&&(!ed2.getText().toString().isEmpty()));

    }
    private void changeButtonState(boolean newState){
        Button b1 = (Button)findViewById(R.id.button);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);
        Button b4 = (Button)findViewById(R.id.button4);
        Button b5 = (Button)findViewById(R.id.button5);
        b1.setEnabled(newState);
        b2.setEnabled(newState);
        b3.setEnabled(newState);
        b4.setEnabled(newState);
        b5.setEnabled(newState);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button5) {
            TextView answer = (TextView) v.findViewById(R.id.textView4);
            answer.setText(Double.toString(result));
        }
    }
}
