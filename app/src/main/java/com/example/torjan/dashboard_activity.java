package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class dashboard_activity extends AppCompatActivity {

//    private ViewPager pager;
//    private TabLayout tabLayout;

    private ChipNavigationBar chipNavigation;
    FragmentManager fragmentManager;

//    private MedicalCollegeFragment medicalCollegeFragment;
//    private HospitalFragment hospitalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_hospital_dashboard);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_helpline:
                        startActivity(new Intent(getApplicationContext(), phone_activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_stat:
                        startActivity(new Intent(getApplicationContext(),stat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_notification:
                        startActivity(new Intent(getApplicationContext(), notification1.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_hospital_dashboard:
                        startActivity(new Intent(getApplicationContext(),dashboard_activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        chipNavigation=findViewById(R.id.chipNavigation);

//        tabLayout=findViewById(R.id.tabLayoutDashBoard);
//        pager=findViewById(R.id.viewPagerDashBoard);

//        medicalCollegeFragment=new MedicalCollegeFragment();
//        hospitalFragment=new HospitalFragment();
//

        if(savedInstanceState==null){

            chipNavigation.setItemSelected(R.id.hospitalicon,true);
            fragmentManager=getSupportFragmentManager();
            HospitalFragment hospitalFragment=new HospitalFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,hospitalFragment)
                    .commit();

        }

        chipNavigation.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;

                switch (i){

                    case R.id.hospitalicon:
                        fragment=new HospitalFragment();
                        break;

                    case R.id.Collegeicon:
                        fragment=new MedicalCollegeFragment();
                        break;

                    default:
                        break;
                }

                if(fragment!=null){

                    fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();

                }

            }
        });

//        tabLayout.setupWithViewPager(pager);
//
//        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),0);
//
//        viewPagerAdapter.addfragment(hospitalFragment,"Hospital");
//        viewPagerAdapter.addfragment(medicalCollegeFragment,"Colleges");
//
//        pager.setAdapter(viewPagerAdapter);


    }

//    private class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        private List<Fragment> fragments=new ArrayList<>();
//        private List<String> fragmentTitle=new ArrayList<>();
//
//        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
//            super(fm, behavior);
//        }
//
//        public void addfragment(Fragment fragment,String title){
//
//            fragments.add(fragment);
//            fragmentTitle.add(title);
//
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return fragmentTitle.get(position);
//        }
//    }
}