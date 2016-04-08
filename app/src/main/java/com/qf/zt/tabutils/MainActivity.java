package com.qf.zt.tabutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BaseFragment> fragments;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = ((RadioGroup) findViewById(R.id.radioGroupsId));
        fragments = new ArrayList<>();
        fragments.add(TestFragment.newInstance("页面1"));
        fragments.add(TestFragment.newInstance("页面2"));
        fragments.add(TestFragment.newInstance("页面3"));
        fragments.add(TestFragment.newInstance("页面4"));
        new TabFragmentUtils(radioGroup,R.id.containerId,getSupportFragmentManager(),fragments);
    }
}
