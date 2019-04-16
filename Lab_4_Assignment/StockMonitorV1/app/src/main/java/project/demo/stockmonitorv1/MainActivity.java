package project.demo.stockmonitov2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> stockPrice;
ArrayAdapter<String> StockPrice;
RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue= Volley.newRequestQueue(this);

        stockPrice = new ArrayList<>();

        StockPrice = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stockPrice);
        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(StockPrice);
        stockMonitor("AAPL", "Apple");
        stockMonitor("GOOGL", "Alphabet (Google)");
        stockMonitor("FB", "Facebook");
        stockMonitor("NOK", "Nokia");


    }
    private void stockMonitor(final String stockSymbol,  final String stockName){
//        final String stockSymbol = "AAPL";
//        final String stockName = "Apple";

        String url = "https://financialmodelingprep.com/api/company/price/"+ stockSymbol +"?datatype=json";
        Log.d("response json data, URL", url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            JSONObject getStockDetailsfromServer = response.getJSONObject(stockSymbol);
                           String price = getStockDetailsfromServer.getString("price");
                           String nameWithCurrency = stockName + ": " + price + " USD";
                           stockPrice.add(nameWithCurrency);
                            StockPrice.notifyDataSetChanged();
                        } catch (Exception e) {
                           // Log.d("response jason data, catch Exception", e.getLocalizedMessage());
                        }
                        //stockPrice.add("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        //Log.d("response jason data, VolleyError", error.getLocalizedMessage());
                    }
                });

// Access the RequestQueue through your singleton class.
      requestQueue.add(jsonObjectRequest);
    }




}
