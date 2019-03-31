package project.demo.complexuiprogramatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String[] Countries = {"Algeria", "Albania", "China", "England", "Ukraine", "the Netherlands", "India",
           // "Nepal"};
    ArrayList<String> countrieslist;

    int country = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countrieslist = new ArrayList<>();
        countrieslist.add("Finland");
        countrieslist.add("China");
        countrieslist.add("America");
        countrieslist.add("Nepal");
        LinearLayout parent = new LinearLayout(this);
        parent.setOrientation(LinearLayout.VERTICAL);
        LayoutParams parentParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setContentView(parent, parentParam);

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        layout2.setGravity(Gravity.CENTER | Gravity.TOP);
        parent.addView(layout2);

        final Button addBtn = new Button(this);
        addBtn.setText("Add");
        layout2.addView(addBtn);

        final Button editBtn = new Button(this);
        editBtn.setText("Edit");
        layout2.addView(editBtn);

        Button removeBtn = new Button(this);
        removeBtn.setText("Remove");
        layout2.addView(removeBtn);

        final EditText edi = new EditText(this);
        edi.setHint("Country");
        parent.addView(edi);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countrieslist);


        final ListView list = new ListView(this);
        list.setAdapter(adapter);
        parent.addView(list);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               edi.setText(countrieslist.get(position));
               country = position;
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String test = edi.getText().toString();
                countrieslist.add(test);
                Collections.reverse(countrieslist);

                edi.setText(null);
            }


        });
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               adapter.remove(countrieslist.get(country));
               edi.setText(null);
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editString = edi.getText().toString();
                adapter.remove(countrieslist.get(country));
                countrieslist.add(editString);
                edi.setText(null);
            }
        });
    }
}
