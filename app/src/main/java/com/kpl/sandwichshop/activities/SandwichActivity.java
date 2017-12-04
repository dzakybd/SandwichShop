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

        recyclerView = (RecyclerView) findViewById(R.id.recycler_bahan);

        fAdapter = new FillingsAdapter(fillingList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fAdapter);

        prepareFillingData();
    }

    private void prepareFillingData() {
        Filling filling = new Filling("Roti tawar", 750, "roti");
        fillingList.add(filling);

        filling = new Filling("Selada", 250, "lapisan");
        fillingList.add(filling);

        filling = new Filling("Margarin", 500, "pasta");
        fillingList.add(filling);

        filling = new Filling("Keju", 320, "lapisan");
        fillingList.add(filling);

        filling = new Filling("Kornet", 1900, "lapisan");
        fillingList.add(filling);

        filling = new Filling("Mayones", 750, "pasta");
        fillingList.add(filling);

        fAdapter.notifyDataSetChanged();
    }
}
