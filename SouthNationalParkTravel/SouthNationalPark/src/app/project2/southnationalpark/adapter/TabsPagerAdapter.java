package app.project2.southnationalpark.adapter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import app.project2.southnationalpark.GamesFragment;
import app.project2.southnationalpark.MoviesFragment;
import app.project2.southnationalpark.NationalPark;
import app.project2.southnationalpark.PlantsAnimalsFragment;
import app.project2.southnationalpark.ProvinceNationalPark;
import app.project2.southnationalpark.TopRatedFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	String id1;
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new TopRatedFragment();
		case 1:
			// Games fragment activity
			return new GamesFragment();
		case 2:
			// Movies fragment activity
			return new MoviesFragment();
		case 3:
			// Movies fragment activity
			return new PlantsAnimalsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}
