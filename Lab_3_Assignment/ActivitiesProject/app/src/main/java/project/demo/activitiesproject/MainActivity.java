package project.demo.activitiesproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openMap(View view) {

    Uri location = Uri.parse("geo:0,0?q=Kotkantie 1, Oulu, Finland");

    Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

    PackageManager packageManager = getPackageManager();
    List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
    boolean isIntentSafe = ((List) activities).size() > 0;

    if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
    public void createCall(View view){
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }
public void goOamk(View view){
    //Intent intent = new Intent(Intent.ACTION_SEND);
    EditText stringUrl = findViewById(R.id.oamkUrl);
    Log.i("MAIN", stringUrl.getText().toString());
    Uri webpage = Uri.parse(stringUrl.getText().toString());
    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
    //boolean isIntentSafe = ((List) activities).size() > 0;
 //if (isIntentSafe) {
     startActivity(webIntent);
 //}
 }


}

//}
