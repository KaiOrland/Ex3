package com.example.kai.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculator(View view){
        double result;
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
        if(view.getId()==R.id.button5){
            TextView answer = (TextView) view.findViewById(R.id.textView4);
            answer.setText(Double.toString(result));
        }

    }
}
