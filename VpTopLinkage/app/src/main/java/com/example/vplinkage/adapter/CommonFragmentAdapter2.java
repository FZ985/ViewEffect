package com.example.vplinkage.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 14:58
 */
public class CommonFragmentAdapter2 extends OpenFragmentStatePagerAdapter {
    private List<Fragment> frags;

    @Override
    Object getItemData(int position) {
        return null;
    }

    @Override
    boolean dataEquals(Object oldData, Object newData) {
        return false;
    }

    @Override
    int getDataPosition(Object data) {
        return 0;
    }

    public void remove(int position) {
        frags.remove(position);
        notifyDataSetChanged();
    }


    public CommonFragmentAdapter2(@NonNull FragmentManager fm, List<Fragment> frags) {
        super(fm);
        this.frags = frags;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags == null ? 0 : frags.size();
    }
}