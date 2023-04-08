package com.example.huynvph20687_2608;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewpagerfrg extends FragmentStateAdapter {
    public viewpagerfrg(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new danhsachfrg();
            case 1:
                return new themnhansufrg();
        }
        return new danhsachfrg();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
