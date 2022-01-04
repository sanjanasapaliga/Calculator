package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    TextView output;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=findViewById(R.id.input);
        output.setShowSoftInputOnFocus(false);

    }

    public void backbtn(View view) {
        if (str.isEmpty())
        {
            str="";


        }
        else
            {
                int r=str.length();
                str=str.substring(0,r-1);
                output.setText(str);
            }


    }



    public void clearbtn(View view) {
        str="";
        output.setText(str);
    }

    public void sevenbtn(View view) {
        str=str+"7";
        output.setText(str);
    }

    public void eightbtn(View view) {
        str=str+"8";
        output.setText(str);
    }

    public void ninebtn(View view) {
        str=str+"9";
        output.setText(str);
    }

    public void addbtn(View view) {
        str=str+"+";
        output.setText(str);
    }

    public void fourbtn(View view) {
        str=str+"4";
        output.setText(str);
    }

    public void fivebtn(View view) {
        str=str+"5";
        output.setText(str);
    }

    public void sixbtn(View view) {
        str=str+"6";
        output.setText(str);

    }

    public void sunbtn(View view) {
        str=str+"-";
        output.setText(str);
    }

    public void onebtn(View view) {
        str=str+"1";
        output.setText(str);

    }

    public void twobtn(View view) {
        str=str+"2";
        output.setText(str);
    }

    public void threebtn(View view) {
        str=str+"3";
        output.setText(str);

    }

    public void mulbtn(View view) {
        str=str+"*";
        output.setText(str);
    }

    public void decbtn(View view) {
        str=str+".";
        output.setText(str);
    }

    public void zerobtn(View view) {
        str=str+"0";
        output.setText(str);
    }

    public void equlalbtn(View view) {

        try{

            str=str.replaceAll("×","*");
            str=str.replaceAll("%","/100*");
            str=str.replaceAll("÷","/");

            Context rhino=Context.enter();
            rhino.setOptimizationLevel(-1);

            Scriptable scriptable=rhino.initStandardObjects();
            String finalResult = rhino.evaluateString(scriptable, str, "Javsscript", 1, null).toString();
            output.setText(finalResult);
            str=finalResult;
        }
        catch (Exception e)
        {
            String err="Error";
            output.setText(err);
            str="";
        }
    }

    public void divbtn(View view) {
        str=str+"/";
        output.setText(str);
    }

    public void percentbtn(View view) {
        str=str+"%";
        output.setText(str);
    }

    public void bopen(View view) {
        str = str + "(";
        output.setText(str);
    }
    public void bclose(View view) {
        str=str+")";
        output.setText(str);
    }
}