package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
import java.math.RoundingMode;
import java.lang.String;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        final EditText billAmount = (EditText) findViewById(R.id.billAmount);
        billAmount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

//                TextView tipBill = (TextView) findViewById(R.id.tipBill);
//                if (s.length()>0) {
//                    double number = Double.parseDouble(s.toString());
//                    double rounded = Math.ceil(number*0.12);
////                    String cs = "jj"
//                    tipBill.setText(Double.toString(rounded));
//                    TextView totalAmount = (TextView) findViewById(R.id.totalAmount);
//                    totalAmount.setText(Double.toString(number+rounded));
//                }
            }

        });


        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence s = billAmount.getText();
                                TextView tipBill = (TextView) findViewById(R.id.tipBill);
                if (s.length()>0) {
                    double number = Double.parseDouble(s.toString());
                    boolean isChecked = ((CheckBox) findViewById(R.id.chkRound)).isChecked();
                    double rounded;
                    if (isChecked) {
                        rounded = Math.round(number * 0.12);
                    }
                        else {
                        rounded = (double) Math.round(number * 0.12 * 100) / 100;
                    }
//                    String cs = "jj"
                    tipBill.setText(Double.toString(rounded));
                    TextView totalAmount = (TextView) findViewById(R.id.totalAmount);
                    totalAmount.setText(Double.toString(number+rounded));
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
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