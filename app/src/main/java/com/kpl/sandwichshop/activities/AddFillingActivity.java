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
import com.kpl.sandwichshop.models.Filling.Beef;
import com.kpl.sandwichshop.models.Filling.Cheese;
import com.kpl.sandwichshop.models.Filling.Chicken;
import com.kpl.sandwichshop.models.Filling.Egg;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.kpl.sandwichshop.models.Filling.Fish;
import com.kpl.sandwichshop.models.Filling.Lettuce;
import com.kpl.sandwichshop.models.Filling.Mayonnaise;
import com.kpl.sandwichshop.models.Filling.Tomato;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.itemanimators.SlideDownAlphaAnimator;

import org.parceler.Parcels;

import java.util.Arrays;
import java.util.List;

public class AddFillingActivity extends AppCompatActivity  {

    RecyclerView recyclerfilling;
    FastAdapter<FillingAdapter> mFastAdapter;
    ItemAdapter<FillingAdapter> mItemAdapter;
    CheckBox checkboxmeat;
    CheckBox checkboxvegetable;
    CheckBox checkboxcondiment;
    static final List<Filling> allfilling = Arrays.asList(
           new Beef(), new Chicken(), new Fish(), new Egg(), new Lettuce(), new Tomato(), new Mayonnaise(), new Cheese()
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_filling);
        checkboxcondiment = findViewById(R.id.checkbox_condiment);
        checkboxvegetable = findViewById(R.id.checkbox_vegetable);
        checkboxmeat = findViewById(R.id.checkbox_meat);
        recyclerfilling = findViewById(R.id.recycler_filling);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillingSetup();
        fillingData(allfilling);
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
        recyclerfilling.setLayoutManager(new LinearLayoutManager(this));
        recyclerfilling.setAdapter(mFastAdapter);
        recyclerfilling.setItemAnimator(new SlideDownAlphaAnimator());
        recyclerfilling.getItemAnimator().setAddDuration(500);
        recyclerfilling.getItemAnimator().setRemoveDuration(500);

    }

    public void addFilling(View view) {
        Filling filling = null;
        for (Integer pos : mFastAdapter.getSelections()) {
            filling=mItemAdapter.getAdapterItem(pos).filling;
        }
        Intent i = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(StaticKeys.addFillingResult, Parcels.wrap(Filling.class, filling));
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
        if(checkboxcondiment.isChecked()&&checkboxmeat.isChecked()&&checkboxvegetable.isChecked()){
            fillingData(allfilling);
        }else if(checkboxcondiment.isChecked()&&checkboxmeat.isChecked()) {
            FilterFilling condimentFilter = new CondimentFilter();
            FilterFilling meatFilter = new MeatFilter();
            FilterFilling condimentOrMeat = new OrCriteria(condimentFilter, meatFilter);
            fillingData(condimentOrMeat.meetCriteria(allfilling));

        }else if(checkboxmeat.isChecked()&&checkboxvegetable.isChecked()) {
            FilterFilling meatFilter = new MeatFilter();
            FilterFilling vegetableFilter = new VegetableFilter();
            FilterFilling meatOrVegetable = new OrCriteria(meatFilter, vegetableFilter);
            fillingData(meatOrVegetable.meetCriteria(allfilling));

        }else if(checkboxcondiment.isChecked()&&checkboxvegetable.isChecked()) {
            FilterFilling condimentFilter = new CondimentFilter();
            FilterFilling vegetableFilter = new VegetableFilter();
            FilterFilling condimentOrVegetable = new OrCriteria(condimentFilter, vegetableFilter);
            fillingData(condimentOrVegetable.meetCriteria(allfilling));

        }else if(checkboxcondiment.isChecked()){
            FilterFilling condimentFilter = new CondimentFilter();
            fillingData(condimentFilter.meetCriteria(allfilling));

        }else if(checkboxmeat.isChecked()){
            FilterFilling meatFilter = new MeatFilter();
            fillingData(meatFilter.meetCriteria(allfilling));

        }else if(checkboxvegetable.isChecked()){
            FilterFilling vegetableFilter = new VegetableFilter();
            fillingData(vegetableFilter.meetCriteria(allfilling));
        }else{
            mItemAdapter.clear();
        }
    }
}
