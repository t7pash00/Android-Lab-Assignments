package project.demo.makeanimalsound;

import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView text = findViewById(R.id.hello);
        switch (item.getItemId()){
            case R.id.mammals:
                text.setText("Press animals to hear sound");
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.bear);
                ((ImageView)findViewById(R.id.imageView2)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("bear");
                    }
                });

                ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.elephant);
                ((ImageView)findViewById(R.id.imageView3)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("elephant");

                    }
                });

                ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.lamb);
                ((ImageView)findViewById(R.id.imageView4)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("lamb");
                    }
                });
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(R.drawable.wolf);
                ((ImageView)findViewById(R.id.imageView5)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("wolf");
                    }
                });
                return true;
            case R.id.birds:
                text.setText("Press birds to hear sound");
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.huuhkaja);
                ((ImageView)findViewById(R.id.imageView2)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("huuhkaja_norther_eagle_owl");
                    }
                });

                ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.peippo);
                ((ImageView)findViewById(R.id.imageView3)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("peippo_chaffinch");
                    }
                });
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.peukaloinen);
                ((ImageView)findViewById(R.id.imageView4)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("peukaloinen_wren");
                    }
                });
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(R.drawable.punatulkku);
                ((ImageView)findViewById(R.id.imageView5)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopPlaying();
                        playSound("punatulkku_northern_bullfinch");
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    private void playSound(String name) {
        mediaPlayer = MediaPlayer.create(MainActivity.this, getResources().getIdentifier(name, "raw", getPackageName()));
        mediaPlayer.start();
    }
    private void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }



}
