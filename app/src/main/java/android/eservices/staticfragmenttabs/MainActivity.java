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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;
    private PagerAdapter pagerAdapter;
    private SharedViewModel model;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counter_textview);
        // TODO : A VOIR l'increment commence apres le deuxieme click
        counterTextView.setText(String.format("Current counter is : %1$d",0));

        // holds instance of SharedViewModel
        model =
                ViewModelProviders
                        .of(this)
                        .get(SharedViewModel.class);
        // observes the liveData from SharedViewModel
        observeLiveData();

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {

        viewPager = findViewById(R.id.tab_viewpager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle fragment change inside
        //viewpager.setAdapter(...);

    }


    // observes liveData from current activity
    public void observeLiveData(){
        model.getLiveData()
             .observe(this, new Observer<Integer>() {
                @SuppressLint("DefaultLocale")
                @Override
                public void onChanged(@Nullable Integer integer) {
                    //String text = String.valueOf(R.string.counter_text);
                    //TODO : CECI EST UNE TRICHE DE MA PART :( À RESOUDRE
                    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
                    counterTextView.setText(String.format("Current counter is : %1$d",integer));
                }
             });
    }


    /**
     * A simple pager adapter that represents 2 Fragments objects, in
     * sequence.
     */
    private class PagerAdapter extends FragmentStatePagerAdapter {

        // TODO : POSIIBILITE DE FAIRE MIEUX JE PENSE !!!
        private String[] tabTitles = new String[]{FragmentOne.TAB_NAME, FragmentTwo.TAB_NAME};

        public PagerAdapter(FragmentManager fm) {
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
