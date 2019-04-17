package project.demo.eggtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            openTimerActivity();
        }
    });

    }
    public void openTimerActivity(){
    Intent intent= new Intent(this, TimeCountdownActivity.class);
    EditText timeNumber = findViewById(R.id.edit_layout);
        String timeText = timeNumber.getText().toString();
       try {
           int time =  Integer.parseInt(timeText);//it tries to parse an integer from string.
           intent.putExtra("count_time", time);
           startActivity(intent);
       }catch (Exception e){
           Log.e("Parsing error", e.getLocalizedMessage());
           Toast toast= Toast.makeText(getApplicationContext(),
                   "Please put a vaid number", Toast.LENGTH_SHORT);
           toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
           toast.show();

       }

    }
}
