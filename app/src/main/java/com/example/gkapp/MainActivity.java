package com.example.gkapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RequestQueue rq;
    private List<States> stateList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.recycle);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        rq = VolleySingleton.getmInstance(this).getRequestQueue();

        stateList = new ArrayList<>();
        fetchStates();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        System.exit(0);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void fetchStates() {

        String url = "https://codemap.co.in/statesAPI.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0 ; i < response.length() ; i ++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String population = jsonObject.getString("population");
                                String capital = jsonObject.getString("capital");
                                String gdp = jsonObject.getString("gdp");
                                String cmname=jsonObject.getString("cmname");
                                String rulingparty=jsonObject.getString("rulingparty");
                                String gdppercapita=jsonObject.getString("gdppercapita");
                                String image=jsonObject.getString("image");


                                States state = new States(name,population,capital,gdp,cmname,rulingparty,gdppercapita,image);
                                stateList.add(state);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            StateAdapter adapter = new StateAdapter(MainActivity.this , stateList);

                            rv.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        rq.add(jsonArrayRequest);
    }
}

