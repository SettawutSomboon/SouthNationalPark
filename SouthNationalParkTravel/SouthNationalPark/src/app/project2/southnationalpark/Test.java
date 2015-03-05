package app.project2.southnationalpark;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class Test extends Activity {
	PlanetPagerAdapter mAdapter; // pager adapter
	ViewPager mViewPager;
	
	protected static final String[] mPlanetTitles = new String[] { "Dive",
        "Rafting", "forest", "Caving" };



public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pager);
    
    setupViewPager();
    setupTabs();
	}
private void setupViewPager() {
    /*
     * ���ҧ�ͺ�礷���� pager adapter (�Թ�᷹��ͧ PlanetPagerAdapter)
     * ���ǹ�仡�˹����Ѻ ViewPager
     */
    mAdapter = new PlanetPagerAdapter(getFragmentManager());
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mAdapter);

    // �ͺ�� OnPageChangeListener ����Ѻ�к��鴡�÷ӧҹ������ա������¹ྨ� ViewPager
    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            // ���������͹��ѧྨ��ҧ� ������͡�纷������ѹ��ѹ
            getActionBar().setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    // ��˹��ͺ�� OnPageChangeListener ���Ѻ ViewPager
    mViewPager.setOnPageChangeListener(pageChangeListener);
}

// pager adapter ��觨����Թ�᷹��ͧ PlanetDetailsFragment ���� ViewPager 
public class PlanetPagerAdapter extends FragmentStatePagerAdapter {
    public PlanetPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        // ���ҧ�á��������ʴ��Ҿ��������� �����觤׹�á��������Ѻ�͡�
        String planetTitle = mPlanetTitles[i];
        Fragment fragment = PlanetDetailsFragment.newInstance(planetTitle);
        return fragment;
    }

    @Override
    public int getCount() {
        return mPlanetTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPlanetTitles[position];
    }
}

private void setupTabs() {
    final ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    // �ͺ�� TabListener ����Ѻ�к��鴡�÷ӧҹ������Դ���ǹ���ҧ�����ǡѺ��
    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // ��������͡�纨С�˹���� ViewPager �ʴ�ྨ�������ѹ��ѹ
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab,
                FragmentTransaction ft) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab,
                FragmentTransaction ft) {
        }
    };

    // ���ҧ�纵���ӹǹ��������������� mPlanetTitles
    for (int i = 0; i < mPlanetTitles.length; i++) {
        // ���ҧ������ (�ͺ�� ActionBar.Tab)
        Tab tab = actionBar.newTab();
        // ��˹���ͤ������ listener ���Ѻ��
        tab.setText(mPlanetTitles[i]);
        tab.setTabListener(tabListener);
        
        // ������ŧ� ActionBar
        actionBar.addTab(tab);
    }
}
}

