package com.example.dell.navbot;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean state=true;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    /////////////////
    private MyPagerAdapter mFragmentAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.photos_viewpager);
        mViewPager.setAdapter(mFragmentAdapter);

        // link the tabLayout and the viewpager together
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

            dl = (DrawerLayout) findViewById(R.id.activity_main);
            t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
            dl.addDrawerListener(t);
            t.syncState();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            nv = (NavigationView) findViewById(R.id.nv);


         if(myservice.ServiceIsRun==false)
         {
             myservice.ServiceIsRun = true;
             Intent i1 = new Intent(this, myservice.class);
             startService(i1);
         }

         mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                 //Toast.makeText(getApplicationContext(),"onPageScrolled",Toast.LENGTH_SHORT).show();
                 if(state)
                 {
                     state=false;
                     if(mViewPager.getCurrentItem()==0)
                     {
                         RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
                         Itemdata itemdata[]={
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                                 new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                                 new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                                 new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                                 new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                                 new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                                 new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                                 new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                                 new Itemdata("thread","this is first picture in my app","detail2","number worker",R.drawable.s)
                         };
                         //new gridLayoutManager(this,2)
                         recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                         MyAdapter myAdapter=new MyAdapter(itemdata,MainActivity.this);
                         recyclerView.setAdapter(myAdapter);
                         recyclerView.setItemAnimator(new DefaultItemAnimator());
                     }
                     else  if(mViewPager.getCurrentItem()==1)
                     {

                     }
                     else  if(mViewPager.getCurrentItem()==2)
                     {

                     }
                 }

             }

             @Override
             public void onPageSelected(int position) {

                 if(mViewPager.getCurrentItem()==0)
                 {
                     RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
                     Itemdata itemdata[]={
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                         new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                         new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                         new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                         new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                         new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                         new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                         new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                         new Itemdata("thread","this is first picture in my app","detail2","number worker",R.drawable.s)
                 };
                     //new gridLayoutManager(this,2)
                     recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                     MyAdapter myAdapter=new MyAdapter(itemdata,MainActivity.this);
                     recyclerView.setAdapter(myAdapter);
                     recyclerView.setItemAnimator(new DefaultItemAnimator());
                 }
                 else  if(mViewPager.getCurrentItem()==1)
                 {

                 }
                 else  if(mViewPager.getCurrentItem()==2)
                 {

                 }
             }

             @Override
             public void onPageScrollStateChanged(int state) {
                // Toast.makeText(getApplicationContext(),"onPageScrollStateChanged",Toast.LENGTH_SHORT).show();
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav,menu);
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        final Context co=this;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(co,query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Toast.makeText(co,newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void posts_company(MenuItem item) {
        mViewPager.setCurrentItem(0);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata itemdata[]={
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this type to show for you that i can make racycler view without use a picture","detail2","number worker",1000),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.a),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.b),
                new Itemdata("first","this is first picture in my app","detail2","number worker",R.drawable.c),
                new Itemdata("scont","this is first picture in my app","detail2","number worker",R.drawable.d),
                new Itemdata("thread","this is first picture in my app","detail2","number worker",R.drawable.s)
        };

        //new gridLayoutManager(this,2)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter=new MyAdapter(itemdata,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void worker_profile(MenuItem item) {
        mViewPager.setCurrentItem(0);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata_profile itemdata_pro[]={
                new Itemdata_profile("Mahmoud Tantora","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Ammar Kiali","Syria","enginring software",R.drawable.s),
                new Itemdata_profile("Mohammad Ali","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Ali Mahmoud","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Ahmad Saeed","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Zaeed Al_Ahmad","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Abo Baker","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Abo Zaeed","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Mohmmad Kialy","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Khalid Al_Yousf","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Maohmmad Al_Aliway","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Diaa Omar","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Abd Al_kareem","Syria","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        My_Adapter_Profile myAdapter=new My_Adapter_Profile(itemdata_pro,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void project(MenuItem item) {
        mViewPager.setCurrentItem(0);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        itemdata_project[] projects={
                new itemdata_project("Mahmoud Tantora","1000$","enginring software",R.drawable.a),
                new itemdata_project("Ammar Kiali","200$","enginring software",R.drawable.s),
                new itemdata_project("Mohammad Ali","300$","enginring software",R.drawable.c),
                new itemdata_project("Ali Mahmoud","1500$","enginring software",R.drawable.d),
                new itemdata_project("Ahmad Saeed","2500$","enginring software",R.drawable.a),
                new itemdata_project("Zaeed Al_Ahmad","100$","enginring software",R.drawable.b),
                new itemdata_project("Abo Baker","3200$","enginring software",R.drawable.c),
                new itemdata_project("Abo Zaeed","2500$","enginring software",R.drawable.d),
                new itemdata_project("Mohmmad Kialy","2500$","enginring software",R.drawable.a),
                new itemdata_project("Khalid Al_Yousf","2500$","enginring software",R.drawable.b),
                new itemdata_project("Maohmmad Al_Aliway","2500$","enginring software",R.drawable.c),
                new itemdata_project("Diaa Omar","2500$","enginring software",R.drawable.d),
                new itemdata_project("Abd Al_kareem","2500$","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        My_Adapter_project myAdapter=new My_Adapter_project(projects,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void company(MenuItem item) {
        mViewPager.setCurrentItem(0);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_recycler);
        Itemdata_profile itemdata_pro[]={
                new Itemdata_profile("Al Borak","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Al Mostaql","Syria","enginring software",R.drawable.s),
                new Itemdata_profile("Antaliq","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Google","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Yahoo","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Amazon","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Samsung","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Hwawy","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Kialy","Syria","enginring software",R.drawable.a),
                new Itemdata_profile("Orange","Syria","enginring software",R.drawable.b),
                new Itemdata_profile("Maohmmad Al_Aliway","Syria","enginring software",R.drawable.c),
                new Itemdata_profile("Diaa Omar","Syria","enginring software",R.drawable.d),
                new Itemdata_profile("Abd Al_kareem","Syria","enginring software",R.drawable.s)
        };
        //new GridLayoutManager(this,2)
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        My_Adapter_Profile myAdapter=new My_Adapter_Profile(itemdata_pro,MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dl.closeDrawers();
        dl.animate();
    }

    public void groups(MenuItem item) {
        dl.closeDrawers();
        dl.animate();
    }

    public void log_out(MenuItem item) {
        dl.closeDrawers();
        dl.animate();
    }

    public void settings(MenuItem item) {
        Intent i = new Intent(this,SettingsActivity.class);
        startActivity(i);
        dl.closeDrawers();
        dl.animate();
    }

    public void create_post(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,createpost.class);
        startActivity(intent);
    }


}
