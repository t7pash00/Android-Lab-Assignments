package project.demo.menuproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.color_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout layout = findViewById(R.id.layout);
        TextView text = findViewById(R.id.hello);
        switch (item.getItemId()) {
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                text.setTextColor(Color.GREEN);
                text.setText("This is my red text");
                return true;
            case R.id.green:
                layout.setBackgroundColor(Color.GREEN);
                text.setTextColor(Color.RED);
                text.setText("This is my green text");
                return true;
            case R.id.blue:
                layout.setBackgroundColor(Color.BLUE);
                text.setTextColor(Color.YELLOW);
                text.setText("This is my blue text");
                return true;
            case R.id.yellow:
                layout.setBackgroundColor(Color.YELLOW);
                text.setTextColor(Color.BLUE);
                text.setText("This is my yellow text");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



