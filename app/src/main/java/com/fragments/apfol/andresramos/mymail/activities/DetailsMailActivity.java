package com.fragments.apfol.andresramos.mymail.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fragments.apfol.andresramos.mymail.R;
import com.fragments.apfol.andresramos.mymail.fragments.DetailsFragment;

public class DetailsMailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_mail);

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(getIntent().getStringExtra(MainActivity.TEXT_SUBJECT), getIntent().getStringExtra(MainActivity.TEXT_SENDER), getIntent().getStringExtra(MainActivity.TEXT_MESSAGE));

    }
}
