package com.qf.zt.tabutils;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment {


    public TestFragment() {
        // Required empty public constructor
    }

    public static TestFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text",text);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textViewId);
        textView.setText(getArguments().getString("text"));
        return view;
    }


}
