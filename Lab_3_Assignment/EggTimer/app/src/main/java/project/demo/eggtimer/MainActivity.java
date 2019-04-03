package project.demo.eggtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        String time = timeNumber.getText().toString();
        intent.putExtra("count_time", time);
    startActivity(intent);
    }
}
