package project.demo.uiprogramatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int countClicks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button gameButton = new Button(this);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                countClicks = countClicks + 1;
                gameButton.setText("You have pressed the button for " + countClicks + " times");

            }
        });
        gameButton.setText("Hello, I'm the button");
        setContentView(gameButton);
    }
}
