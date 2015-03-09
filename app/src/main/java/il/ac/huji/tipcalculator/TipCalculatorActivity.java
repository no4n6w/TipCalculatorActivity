package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Gets bill amount object
        final EditText billAmount = (EditText) findViewById(R.id.billAmount);
        // Gets calculate button object
        final Button button = (Button) findViewById(R.id.btnCalculate);

        // Waits for the click to read the bill amount
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Reads the bill amount
                CharSequence s = billAmount.getText();

                // Gets the tip text box object
                TextView tipBill = (TextView) findViewById(R.id.tipBill);

                if (s.length()>0) {
                    double number = Double.parseDouble(s.toString());

                    // Gets the check box value
                    boolean isChecked = ((CheckBox) findViewById(R.id.chkRound)).isChecked();
                    double rounded;


                    if (isChecked) {
                        rounded = Math.round(number * 0.12);
                    }
                        else {
                        rounded = (double) Math.round(number * 0.12 * 100) / 100;
                    }
                    // Sets the tip amount
                    tipBill.setText(Double.toString(rounded));
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
