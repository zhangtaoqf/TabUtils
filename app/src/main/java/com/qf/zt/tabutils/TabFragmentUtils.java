package com.qf.zt.tabutils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/4/8 0008.
 */
public class TabFragmentUtils implements RadioGroup.OnCheckedChangeListener {
    private int container;
    private FragmentManager fragmentManager;
    private List<BaseFragment> fragments;
    private int curPosition = 0;
    public TabFragmentUtils(RadioGroup radioGroup,int container,FragmentManager fragmentManager,List<BaseFragment> fragments) {

        this.container = container;
        this.fragmentManager  = fragmentManager;
        this.fragments = fragments;
        radioGroup.setOnCheckedChangeListener(this);
        //默认选择第0个按钮
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if(view.getId() == checkedId)
            {


                fragments.get(curPosition).onStop();

                if(fragments.get(i).isAdded())
                {
                    fragments.get(i).onStart();
                }
                else
                {
                    fragmentManager.beginTransaction().add(container,fragments.get(i)).commit();
                }
                //显示
                show(i);
            }
        }
    }

    private void show(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if(i == index)
            {
                fragmentTransaction.show(fragments.get(i));
            }else {
                fragmentTransaction.hide(fragments.get(i));
            }
        }
        fragmentTransaction.commit();
        //保存当前的类。
        curPosition = index;
    }
}
