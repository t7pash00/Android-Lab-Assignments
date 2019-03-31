package project.demo.complexuiprogramatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] Countries = {"Algeria", "Albania", "China", "England", "Ukraine", "the Netherlands", "India",
            "Nepal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout parent = new LinearLayout(this);
        parent.setOrientation(LinearLayout.VERTICAL);
        LayoutParams parentParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setContentView(parent, parentParam);

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);

        parent.addView(layout2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Countries);

        Button addBtn = new Button(this);
        addBtn.setText("Add");
        layout2.addView(addBtn);

        Button editBtn = new Button(this);
        editBtn.setText("Edit");
        layout2.addView(editBtn);

        Button removeBtn = new Button(this);
        removeBtn.setText("Remove");
        layout2.addView(removeBtn);

        EditText edi = new EditText(this);
        edi.setHint("Country");
        parent.addView(edi);


        ListView list = new ListView(this);
        list.setAdapter(adapter);
        parent.addView(list);

    }
}
