package com.journaldev.retrofitintro.pojo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.ApplicationClass;
import com.journaldev.retrofitintro.R;
import com.squareup.otto.Subscribe;

public class FragmentA extends Fragment {
    UserList.Datum user;
    View view;
    LinearLayout llContainer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ApplicationClass.getEventBus().register(this);
        view = inflater.inflate(R.layout.fragment_a, container, false);
        //textView = (TextView) view.findViewById(R.id.textView);
        llContainer = (LinearLayout)view.findViewById(R.id.llContainer);


        return view;

    }

    @Override
    public void onDestroy() {
        ApplicationClass.getEventBus().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void eventHandle(ExampleEvent event){
        user = event.getUser();


        TextView valueTV = new TextView(getActivity());
        valueTV.setText(user.first_name);
        valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        llContainer.addView(valueTV);

        //textView.setText(user.first_name);
        Toast.makeText(getActivity(), "event clicked", Toast.LENGTH_SHORT).show();
    }

}