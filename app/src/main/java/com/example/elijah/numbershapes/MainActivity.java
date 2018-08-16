package com.example.elijah.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{

        int number;

        public boolean isSquare(){
            double squareroot= Math.sqrt(number);

            if(squareroot == Math.floor(squareroot)){
                return true;
            }else {
                return false;
            }

        }


        public boolean isTriangular(){

            int x = 1;
            int triangularnumber = 1;

            while (triangularnumber < number){

                x++;
                triangularnumber = triangularnumber + x;
            }
            if(triangularnumber == number){
                return true;
            }else {
                return false;
            }
        }

    }


    public void testNumber(View view){
        String message = "";
        EditText usernumber = (EditText)findViewById(R.id.edittext);
        if(usernumber.getText().toString().isEmpty()){
            message = "Enter in number";
        }else {

            Log.v("User Number", usernumber.getText().toString());


            Number mynumber = new Number();
            mynumber.number = Integer.parseInt(usernumber.getText().toString());
            usernumber.setText("");

            if (mynumber.isSquare()) {
                if (mynumber.isTriangular()) {
                    message = mynumber.number + " is both triangular and square!";
                } else {
                    message = mynumber.number + " is square but not triangular";
                }
            } else {

                if (mynumber.isTriangular()) {
                    message = mynumber.number + " is triangular but not square!";
                } else {
                    message = mynumber.number + " is neither square or triangular";
                }


            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
