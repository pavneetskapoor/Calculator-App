package com.example.pavneet.application2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new GamePanel(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    ArrayList<String> arrayList= new ArrayList<String>();
    String string= "";
    String string1 = "";

    public void onClick1 (View v){

        TextView textView3 = (TextView) findViewById(R.id.textView3);

        Button button = (Button) v;

        string = (String) button.getText().toString();

        if (!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")) {

            string1 = string1 + string;

            if (arrayList.size()>0){

                arrayList.remove((arrayList.size()-1));

            }
            arrayList.add(string1);
        }
        else {
            arrayList.add(string);
            arrayList.add(string);
            string1="";


        }

        textView3.setText(textView3.getText().toString()+string);

        //textView3.setText(arrayList.toString());
    }

    public void onClick (View v){

        TextView textView1 = (TextView)findViewById(R.id.textView3);

        int calc=0;
        int c= arrayList.size();

        while(c!=1)
        {
            if(c>3){

                if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/") ){

                    if (arrayList.get(3).contains("*")){
                        calc= Integer.parseInt(arrayList.get(2))*Integer.parseInt(arrayList.get(4));
                    }
                    if (arrayList.get(3).contains("/")){
                        calc= Integer.parseInt(arrayList.get(2))/Integer.parseInt(arrayList.get(4));
                    }

                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.add(2, Integer.toString(calc));
                    c= arrayList.size();
                }

                else{

                    if (arrayList.get(1).contains("+")){
                        calc= Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("-")){
                        calc= Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("*")){
                        calc= Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));
                    }
                    if (arrayList.get(1).contains("/")){
                        calc= Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));
                    }

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.add(0, Integer.toString(calc));
                    c= arrayList.size();

                }
            }
            else{

                if (arrayList.get(1).contains("+")){
                    calc= Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));
                }
                if (arrayList.get(1).contains("-")){
                    calc= Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));
                }
                if (arrayList.get(1).contains("*")){
                    calc= Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));
                }
                if (arrayList.get(1).contains("/")){
                    calc= Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));
                }

                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.add(0, Integer.toString(calc));
                c= arrayList.size();

            }
        }

//        textView1.setText(Integer.toString(calc));
    }

    public void clear (View v){

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView2 = (TextView) findViewById(R.id.textView3);

        string1 = " ";
        string= " ";
        textView3.setText("0");
        textView2.setText("");
        arrayList.clear();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
