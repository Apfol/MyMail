package com.fragments.apfol.andresramos.mymail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fragments.apfol.andresramos.mymail.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    @BindView(R.id.textViewMessage)
    TextView textViewMessage;
    @BindView(R.id.textViewSubject)
    TextView textViewSubject;
    @BindView(R.id.textViewSender)
    TextView textViewSender;
    Unbinder unbinder;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void renderText(String subject, String sender, String message) {
        textViewSubject.setText(subject);
        textViewSender.setText(sender);
        textViewMessage.setText(message);
    }

}
