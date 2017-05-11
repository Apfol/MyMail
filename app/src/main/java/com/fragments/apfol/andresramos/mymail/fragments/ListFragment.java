package com.fragments.apfol.andresramos.mymail.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fragments.apfol.andresramos.mymail.R;
import com.fragments.apfol.andresramos.mymail.adapters.MyAdapter;
import com.fragments.apfol.andresramos.mymail.models.Mail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    List<Mail> mails;
    DataListener listener;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mails = getMails();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(mails, R.layout.recycler_view_item, getActivity(), new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mail mail, int position) {
                listener.actionClickedView(mail, position);
            }
        });

        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<Mail> getMails () {
        List<Mail> mails = new ArrayList<>();
        //TODO change color
        mails.add(new Mail("Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex e", "Pepito", R.color.colorTextOne));
        mails.add(new Mail("Title", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo", "Josefa", R.color.colorTextTwo));
        mails.add(new Mail("Title", "Donec auctor mi enim, iaculis egestas eros dignissim et. Morbi pretium a quam sit amet lobortis. Aenean commodo nec nunc sit amet ullamcorper.", "Sarita", R.color.colorTextThree));
        mails.add(new Mail("Title", "Mauris condimentum viverra nulla, ac efficitur arcu convallis id. Pellentesque mollis neque tellus, eget laoreet magna tempor eu. Donec mollis auctor est", "Rafico", R.color.colorTextFour));
        mails.add(new Mail("Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex e", "Pepito", R.color.colorTextOne));
        mails.add(new Mail("Title", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo", "Josefa", R.color.colorTextTwo));
        mails.add(new Mail("Title", "Donec auctor mi enim, iaculis egestas eros dignissim et. Morbi pretium a quam sit amet lobortis. Aenean commodo nec nunc sit amet ullamcorper.", "Sarita", R.color.colorTextThree));
        mails.add(new Mail("Title", "Mauris condimentum viverra nulla, ac efficitur arcu convallis id. Pellentesque mollis neque tellus, eget laoreet magna tempor eu. Donec mollis auctor est", "Rafico", R.color.colorTextFour));
        mails.add(new Mail("Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex e", "Pepito", R.color.colorTextOne));
        mails.add(new Mail("Title", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo", "Josefa", R.color.colorTextTwo));
        mails.add(new Mail("Title", "Donec auctor mi enim, iaculis egestas eros dignissim et. Morbi pretium a quam sit amet lobortis. Aenean commodo nec nunc sit amet ullamcorper.", "Sarita", R.color.colorTextThree));
        mails.add(new Mail("Title", "Mauris condimentum viverra nulla, ac efficitur arcu convallis id. Pellentesque mollis neque tellus, eget laoreet magna tempor eu. Donec mollis auctor est", "Rafico", R.color.colorTextFour));

        return mails;
    }


    public interface DataListener {
        void actionClickedView(Mail mail, int position);
    }

}
