package com.example.najdere.stagenl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdpater extends FragmentPagerAdapter {
    public PagerAdpater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AddStageFragment();
            case 1:
                return new CalendarFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Add";
            case 1:
                return "Agenda";
            default:
                return null;
        }
    }
}
