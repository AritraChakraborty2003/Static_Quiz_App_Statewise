package com.example.gkapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ImageView imgView=findViewById(R.id.StateImg);
        TextView name=findViewById(R.id.nameDetails);
        TextView population=findViewById(R.id.PopulationDetails);
        TextView capital=findViewById(R.id.CapitalDetails);
        TextView gdp=findViewById(R.id.GdpDetails);
        TextView cmname=findViewById(R.id.CmDetails);
        TextView  rulingparty=findViewById(R.id.RulingpartyDetails);
        TextView gdppercapita=findViewById(R.id.Gdppercapita);



        Bundle bundle=getIntent().getExtras();
        String mName=bundle.getString("name");
        String mPopulation=bundle.getString("population");
        String mCapital=bundle.getString("capital");
        String mGdp=bundle.getString("gdp");
        String mcmname=bundle.getString("cmname");
        String mrulingparty=bundle.getString("rulingparty");
        String mgdppercapita=bundle.getString("gdppercapita");
        String mimage=bundle.getString("image");



        Glide.with(this).load(mimage).into(imgView);
        name.setText(mName);
        population.setText(mPopulation);
        capital.setText(mCapital);
        gdp.setText(mGdp);
        cmname.setText(mcmname);
        rulingparty.setText(mrulingparty);
        gdppercapita.setText(mgdppercapita);



        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    }
