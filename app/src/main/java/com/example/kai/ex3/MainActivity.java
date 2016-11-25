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

public class MainActivity extends AppCompatActivity implements TextWatcher {
    double result;
    EditText ed1,ed2;
    TextView tv;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button ans;
    double var1;
    double var2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        ans = (Button)findViewById(R.id.btnAnswer);
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(Double.toString(result));
            }
        });
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textView4);
        Button btnClear = (Button)findViewById(R.id.btnClear);
        ed1.addTextChangedListener(this);
        ed2.addTextChangedListener(this);
        Button equal = (Button)findViewById(R.id.button5);
        equal.setOnClickListener(new myListener());
        btnClear.setOnClickListener(new myListener());
    }

    public void abc(View view){
        String StrVar1 = ed1.getText().toString();
        var1 = Double.parseDouble(StrVar1);
        String StrVar2 = ed2.getText().toString();
        var2 = Double.parseDouble(StrVar2);

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

        b1.setEnabled(newState);
        b2.setEnabled(newState);
        b3.setEnabled(newState);
        b4.setEnabled(newState);
        b5.setEnabled(newState);

    }

    private class myListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.button5:
                    tv.setText(Double.toString(result));

                    ans.setEnabled(true);
                    break;
                case R.id.btnClear:
                    tv.setText("");
                    ed1.setText("");
                    ed2.setText("");
                    ans.setEnabled(false);
                    break;
            }


        }
    }


}
