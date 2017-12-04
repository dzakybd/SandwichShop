package com.kpl.sandwichshop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.models.FillingsAdapter;
import com.kpl.sandwichshop.models.Filling;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class SandwichActivity extends AppCompatActivity {
    private List<Filling> fillingList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FillingsAdapter fAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);

        recyclerView = findViewById(R.id.recycler_bahan);

        fAdapter = new FillingsAdapter(fillingList);
        RecyclerView.LayoutManager fLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(fLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fAdapter);

        prepareFillingData();
    }

    private void prepareFillingData() {
        Filling filling = new Filling("Roti tawar", 750, "roti");
        fillingList.add(filling);

        filling = new Filling("Selada", 250, "sayur");
        fillingList.add(filling);

        filling = new Filling("Tomat", 250, "sayur");
        fillingList.add(filling);

        filling = new Filling("Jamur", 550, "sayur");
        fillingList.add(filling);

        filling = new Filling("Margarin", 500, "isian");
        fillingList.add(filling);

        filling = new Filling("Keju", 550, "isian");
        fillingList.add(filling);

        filling = new Filling("Mayones", 750, "isian");
        fillingList.add(filling);

        filling = new Filling("Telur", 2250, "isian");
        fillingList.add(filling);

        filling = new Filling("Ayam", 2250, "daging");
        fillingList.add(filling);

        filling = new Filling("Ikan", 2250, "daging");
        fillingList.add(filling);

        filling = new Filling("Sapi", 2250, "daging");
        fillingList.add(filling);

        fAdapter.notifyDataSetChanged();
    }
}
