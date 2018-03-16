package com.example.mansopresk01.sampleproj;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.mansopresk01.sampleproj.MainActivity.MYPREFERENCES;

public class NavigationLtr extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    ImageView iv1;
    Bitmap bit = null;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.apple,
            R.drawable.orange,
            R.drawable.grapes,
            R.drawable.banana
    };
    String choice[] = {"CAMERA","GALLERY"};
    public static final int CAM_REQ_CODE = 123;
    public static final int GAL_REQ_CODE = 321;

    public static final int CAM_PERMISSION_ACCESS_CODE = 111;
    public static final String CAM_PERMISSION_NAME[] = {android.Manifest.permission.CAMERA};
    public static final int GAL_PERMISSION_ACCESS_CODE = 222;
    public static final String GAL_PERMISSION_NAME[] = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hview = navigationView.getHeaderView(0);
         name = (TextView)hview.findViewById(R.id.txtvwname);
         iv1 = (ImageView)hview.findViewById(R.id.img1);

            sharedPreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
            String uname = sharedPreferences.getString("username", null);
        if(sharedPreferences!=null) {
            if (uname != null || uname != "") {
                name.setText(uname);
            } else {
                Intent i = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Logout completely", Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

//            CameraImportFragment cameraImportFragment = new CameraImportFragment();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.content_frame,cameraImportFragment)
//                    .addToBackStack(null)
//                    .commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

//            GalleryFragment galleryFragment = new GalleryFragment();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.content_frame,galleryFragment)
//                    .addToBackStack(null)
//                    .commit();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
//            Intent i=new Intent(NavigationLtr.this,MainActivity.class);
//            SharedPreferences settings =getSharedPreferences("userdetails",MODE_PRIVATE);
//            settings.edit().clear().commit();
//            startActivity(i);
            Intent intent = new Intent(this, MainActivity.class);
            getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AppleFragment(), "APPLE");
        adapter.addFrag(new OrangeFragment(), "ORANGE");
        adapter.addFrag(new GrapesFragment(), "GRAPES");
        adapter.addFrag(new BananaFragment(), "Banana");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




    public void cam(View v){

            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setIcon(R.drawable.camera);
            adb.setTitle(" Select One ");
            adb.setItems(choice, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0:
                            int res = ContextCompat.checkSelfPermission(NavigationLtr.this, android.Manifest.permission.CAMERA);
                            if (res == PackageManager.PERMISSION_GRANTED) {
                                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(cam, CAM_REQ_CODE);
                            } else {
                                ActivityCompat.requestPermissions(NavigationLtr.this, CAM_PERMISSION_NAME, CAM_PERMISSION_ACCESS_CODE);
                            }
                            break;
                        case 1:
                            int res1 = ContextCompat.checkSelfPermission(NavigationLtr.this, android.Manifest.permission.READ_EXTERNAL_STORAGE);

                            if (res1 == PackageManager.PERMISSION_GRANTED) {
                                Intent gal = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(gal, GAL_REQ_CODE);
                            } else {
                                ActivityCompat.requestPermissions(NavigationLtr.this, GAL_PERMISSION_NAME, GAL_PERMISSION_ACCESS_CODE);
                            }

                            break;
                    }
                }
            });
            adb.create().show();
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case CAM_PERMISSION_ACCESS_CODE:
                    if (CAM_PERMISSION_NAME.equals(permissions[0]) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cam, CAM_REQ_CODE);
                    }
                    break;

                case GAL_PERMISSION_ACCESS_CODE:
                    if (GAL_PERMISSION_NAME.equals(permissions[0]) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Intent gal = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(gal, GAL_REQ_CODE);
                    }
                    break;
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case CAM_REQ_CODE:
                    if (resultCode == RESULT_OK) {
                        Bundle b = data.getExtras();
                        bit = (Bitmap) b.get("data");
                        iv1.setImageBitmap(bit);
                    }
                    break;

                case GAL_REQ_CODE:
                    if (resultCode == RESULT_OK) {
                        Uri img = data.getData();
                        try {
                            bit = MediaStore.Images.Media.getBitmap(this.getContentResolver(), img);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        iv1.setImageBitmap(bit);
                    }
                    break;
            }
        }
    }





