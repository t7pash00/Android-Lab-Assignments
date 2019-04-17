package project.demo.greetingsassignment;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.invoke.ConstantCallSite;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout parent = new LinearLayout(this);
        LinearLayout.LayoutParams parentParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setContentView(parent, parentParam);
        parent.setOrientation(LinearLayout.VERTICAL);

        final EditText edi = new EditText(this);
        edi.setHint("Name");
        parent.addView(edi);

        LinearLayout childLayout1 = new LinearLayout(this);
        childLayout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        childLayout1.setGravity(Gravity.CENTER | Gravity.TOP);

        parent.addView(childLayout1, childParam1 );


        final Button english = new Button(this);
        english.setText("English");
        childLayout1.addView(english);

        final Button sverige = new Button(this);
        sverige.setText("Sverige");
        childLayout1.addView(sverige);

        LinearLayout childLayout2 = new LinearLayout(this);
        childLayout2.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams childParam2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        childLayout2.setGravity(Gravity.CENTER | Gravity.TOP);
        parent.addView(childLayout2, childParam2);



        final Button suomeksi = new Button(this);
        suomeksi.setText("Suomeksi");
        childLayout2.addView(suomeksi);

        final Button surprise = new Button(this);
        surprise.setText("Surprise");
        childLayout2.addView(surprise);

        final TextView shiva = new TextView(this);
        shiva.setText("Shiva");
        shiva.setGravity(Gravity.CENTER | Gravity.BOTTOM);

        parent.addView(shiva);

        english.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String test = edi.getText().toString();

                shiva.setText( "Hi! "+ test);
            }


        });
        sverige.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String test = edi.getText().toString();

                shiva.setText( "Hej! "+ test);
            }


        });
        suomeksi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String test = edi.getText().toString();

                shiva.setText( "Hei! "+ test);
            }


        });
        surprise.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String test = edi.getText().toString();

                shiva.setText( "Hola! "+ test);
            }


        });




    }
}
