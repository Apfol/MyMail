package com.fragments.apfol.andresramos.mymail.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fragments.apfol.andresramos.mymail.R;
import com.fragments.apfol.andresramos.mymail.fragments.DetailsFragment;
import com.fragments.apfol.andresramos.mymail.fragments.ListFragment;
import com.fragments.apfol.andresramos.mymail.models.Mail;

public class MainActivity extends FragmentActivity implements ListFragment.DataListener {

    final public static String TEXT_SUBJECT = "subject";
    final public static String TEXT_SENDER = "sender";
    final public static String TEXT_MESSAGE = "message";

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultiPanel();
    }

    @Override
    public void actionClickedView(Mail mail, int position) {

        if (isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(mail.getSubject(), mail.getSender(), mail.getMessage());
        } else {
            Intent intent = new Intent(this, DetailsMailActivity.class);
            intent.putExtra(TEXT_SUBJECT, mail.getSubject());
            intent.putExtra(TEXT_SENDER, mail.getSender());
            intent.putExtra(TEXT_MESSAGE, mail.getMessage());

            startActivity(intent);
        }
    }

    private void setMultiPanel() {
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

}
