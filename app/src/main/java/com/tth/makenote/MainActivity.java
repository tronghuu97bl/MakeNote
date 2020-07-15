package com.tth.makenote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.tth.makenote.fragment.TabFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private TextView app3textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        app3textView = findViewById(R.id.appbar_text_view);
        //icon_navigation
        ImageButton icon_nav = findViewById(R.id.icon_nav);
        icon_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override //khi item tren navigation dc chon
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //handle navigation view item clicks
        int id = item.getItemId();
        if (id == R.id.nav_personal) {
            app3textView.setText("Personal Work");
            TabFragment tabFragment = new TabFragment();
            ft.replace(R.id.f_container, tabFragment);
            ft.commit();
        }
        if (id == R.id.nav_work) {
            app3textView.setText("Works");

        }
        if (id == R.id.nav_friend) {
            app3textView.setText("Friends");

        }
        if (id == R.id.nav_group) {
            app3textView.setText("Groups");

        }
        if (id == R.id.nav_setting) {
            app3textView.setText("Setting");

        }
        if (id == R.id.nav_about) {
            app3textView.setText("About");

        }
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return false;
    }
}