package com.example.vplinkage.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.vplinkage.R;
import com.example.vplinkage.adapter.CommonFragmentAdapter;
import com.example.vplinkage.adapter.ScalePagerAdapter;
import com.example.vplinkage.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        init();
        return view;
    }

    private int count = 10;

    private void init() {
        binding.homeVp.setAdapter(R.layout.item_vp, new ScalePagerAdapter() {
            @Override
            public int getItemCount() {
                return count;
            }

            @Override
            public void init(View view, int position) {
                TextView item_vp_tv = view.findViewById(R.id.item_vp_tv);
                item_vp_tv.setText(String.valueOf(position));
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getActivity(), "pos:" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        List<Fragment> frags = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            frags.add(HomeChildFragment.instance(i));
        }
        binding.homeContentVp.setAdapter(new CommonFragmentAdapter(getChildFragmentManager(), frags));
        binding.homeVp.linkageViewpager(binding.homeContentVp);


    }
}