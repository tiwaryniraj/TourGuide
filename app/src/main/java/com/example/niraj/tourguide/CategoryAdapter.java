package com.example.niraj.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_hotels);
        } else if (position == 1) {
            return mContext.getString(R.string.category_food);
        } else if (position == 2) {
            return mContext.getString(R.string.category_fun);
        } else {
            return mContext.getString(R.string.category_history);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1){
            return new FoodFragment();
        } else if(position == 2){
            return new FunFragment();
        }else {
            return new HistoryFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
