package android.eservices.staticfragmenttabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private SharedViewModel model;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counter_textview);
        // TODO : A VOIR l'increment commence apres le deuxieme click
        setTextToView(0);

        // holds instance of SharedViewModel
        model =
                ViewModelProviders
                        .of(this)
                        .get(SharedViewModel.class);

        // observes the liveData from SharedViewModel
        observeLiveData();

        setupViewPagerAndTabs();
    }


    private void setupViewPagerAndTabs() {

        ViewPager viewPager = findViewById(R.id.tab_viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }


    // observes liveData from current activity
    public void observeLiveData(){
        model.getLiveData()
             .observe(this, new Observer<Integer>() {
                @SuppressLint("DefaultLocale")
                @Override
                public void onChanged(@Nullable Integer integer) {
                    setTextToView(integer);
                }
             });
    }


    public void setTextToView(Integer number){
        String formattedTextView = this.getString(R.string.counter_text, number);
        counterTextView.setText(formattedTextView);
    }



    /**
     * A simple pager adapter that represents 2 Fragments objects
     */
    private class PagerAdapter extends FragmentStatePagerAdapter {

        private String[] tabTitles = new String[]{FragmentOne.TAB_NAME, FragmentTwo.TAB_NAME};

        private PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i){
                case 0:
                    return FragmentOne.newInstance();

                case 1:
                    return FragmentTwo.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }


}
