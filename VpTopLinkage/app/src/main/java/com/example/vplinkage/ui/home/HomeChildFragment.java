package com.example.vplinkage.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vplinkage.databinding.FragmentHomeChildBinding;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 14:54
 */
public class HomeChildFragment extends Fragment {
    private FragmentHomeChildBinding binding;
    private int index;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeChildBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        init();
        return view;
    }

    private void init() {
        index = getArguments().getInt("index", 0);
        binding.homeChindTv.setText(String.valueOf(index));
    }

    public static HomeChildFragment instance(int index) {
        HomeChildFragment fragment = new HomeChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }
}