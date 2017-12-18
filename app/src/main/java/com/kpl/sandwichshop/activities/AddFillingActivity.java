package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.adapters.FillingAdapter;
import com.kpl.sandwichshop.filter.CondimentFilter;
import com.kpl.sandwichshop.filter.FilterFilling;
import com.kpl.sandwichshop.filter.MeatFilter;
import com.kpl.sandwichshop.filter.OrCriteria;
import com.kpl.sandwichshop.filter.VegetableFilter;
import com.kpl.sandwichshop.models.filling.Bacon;
import com.kpl.sandwichshop.models.filling.Beef;
import com.kpl.sandwichshop.models.filling.Cabbage;
import com.kpl.sandwichshop.models.filling.Cheese;
import com.kpl.sandwichshop.models.filling.Chicken;
import com.kpl.sandwichshop.models.filling.Cucumber;
import com.kpl.sandwichshop.models.filling.Egg;
import com.kpl.sandwichshop.models.filling.Filling;
import com.kpl.sandwichshop.models.filling.Garlic;
import com.kpl.sandwichshop.models.filling.Ham;
import com.kpl.sandwichshop.models.filling.Lettuce;
import com.kpl.sandwichshop.models.filling.Mayonnaise;
import com.kpl.sandwichshop.models.filling.Mushroom;
import com.kpl.sandwichshop.models.filling.Octopus;
import com.kpl.sandwichshop.models.filling.Onion;
import com.kpl.sandwichshop.models.filling.Pepper;
import com.kpl.sandwichshop.models.filling.Peppers;
import com.kpl.sandwichshop.models.filling.Salmon;
import com.kpl.sandwichshop.models.filling.Salt;
import com.kpl.sandwichshop.models.filling.Sauce;
import com.kpl.sandwichshop.models.filling.Shrimp;
import com.kpl.sandwichshop.models.filling.Tomato;
import com.kpl.sandwichshop.models.filling.Turkeys;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.itemanimators.SlideDownAlphaAnimator;

import org.parceler.Parcels;

import java.util.Arrays;
import java.util.List;

public class AddFillingActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilling;
    private FastAdapter<FillingAdapter> mFastAdapter;
    private ItemAdapter<FillingAdapter> mItemAdapter;
    private CheckBox checkBoxMeat;
    private CheckBox checkBoxVegetable;
    private CheckBox checkBoxCondiment;
    private static final List<Filling> allFilling = Arrays.asList(
            new Beef(), new Ham(), new Bacon(), new Salmon(), new Octopus(), new Shrimp(), new Turkeys(), new Chicken(), new Egg(),
            new Mushroom(), new Peppers(), new Cabbage(), new Cucumber(), new Lettuce(), new Tomato(), new Onion(), new Garlic(),
            new Cheese(), new Sauce(), new Mayonnaise(), new Pepper(), new Salt()
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_filling);
        checkBoxCondiment = findViewById(R.id.checkbox_condiment);
        checkBoxVegetable = findViewById(R.id.checkbox_vegetable);
        checkBoxMeat = findViewById(R.id.checkbox_meat);
        recyclerViewFilling = findViewById(R.id.recyclerview_filling);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillingSetup();
        fillingData(allFilling);
    }

    private void fillingData(List<Filling> fillings) {
        mItemAdapter.clear();
        for (Filling filling : fillings) {
            mItemAdapter.add(new FillingAdapter().create(filling));
        }
    }

    private void fillingSetup() {
        mItemAdapter = new ItemAdapter<>();
        mFastAdapter = FastAdapter.with(Arrays.asList(mItemAdapter));
        mFastAdapter.withSelectable(true);
        mFastAdapter.withSelectOnLongClick(false);
        recyclerViewFilling.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFilling.setAdapter(mFastAdapter);
        recyclerViewFilling.setItemAnimator(new SlideDownAlphaAnimator());
        recyclerViewFilling.getItemAnimator().setAddDuration(500);
        recyclerViewFilling.getItemAnimator().setRemoveDuration(500);

    }

    public void addFilling(View view) {
        Filling filling = null;
        for (Integer pos : mFastAdapter.getSelections()) {
            filling = mItemAdapter.getAdapterItem(pos).filling;
        }
        Intent i = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(StaticKeys.ADD_FILLING_RESULT, Parcels.wrap(Filling.class, filling));
        i.putExtras(bundle);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        setResult(RESULT_CANCELED, i);
        finish();
        super.onBackPressed();
    }

    public void checkCategory(View view) {
        if (checkBoxCondiment.isChecked() && checkBoxMeat.isChecked() && checkBoxVegetable.isChecked()) {
            fillingData(allFilling);
        } else if (checkBoxCondiment.isChecked() && checkBoxMeat.isChecked()) {
            FilterFilling condimentFilter = new CondimentFilter();
            FilterFilling meatFilter = new MeatFilter();
            FilterFilling condimentOrMeat = new OrCriteria(condimentFilter, meatFilter);
            fillingData(condimentOrMeat.meetCriteria(allFilling));

        } else if (checkBoxMeat.isChecked() && checkBoxVegetable.isChecked()) {
            FilterFilling meatFilter = new MeatFilter();
            FilterFilling vegetableFilter = new VegetableFilter();
            FilterFilling meatOrVegetable = new OrCriteria(meatFilter, vegetableFilter);
            fillingData(meatOrVegetable.meetCriteria(allFilling));

        } else if (checkBoxCondiment.isChecked() && checkBoxVegetable.isChecked()) {
            FilterFilling condimentFilter = new CondimentFilter();
            FilterFilling vegetableFilter = new VegetableFilter();
            FilterFilling condimentOrVegetable = new OrCriteria(condimentFilter, vegetableFilter);
            fillingData(condimentOrVegetable.meetCriteria(allFilling));

        } else if (checkBoxCondiment.isChecked()) {
            FilterFilling condimentFilter = new CondimentFilter();
            fillingData(condimentFilter.meetCriteria(allFilling));

        } else if (checkBoxMeat.isChecked()) {
            FilterFilling meatFilter = new MeatFilter();
            fillingData(meatFilter.meetCriteria(allFilling));

        } else if (checkBoxVegetable.isChecked()) {
            FilterFilling vegetableFilter = new VegetableFilter();
            fillingData(vegetableFilter.meetCriteria(allFilling));
        } else {
            mItemAdapter.clear();
        }
    }
}
