package com.pronin.tasklist_v2;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pronin.tasklist_v2.di.Injector;
import com.pronin.tasklist_v2.navigation.Screens;
import com.pronin.tasklist_v2.presentation.presenter.MainPresenter;
import com.pronin.tasklist_v2.presentation.view.MainView;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class MainActivity extends MvpAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainView {
    Toolbar mtoolbar;
    @Inject
    NavigatorHolder mNavigatorHolder;

    @InjectPresenter
    MainPresenter mMainPresenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return Injector.getInstance().getAppComponent().getMainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.getInstance().getAppComponent().inject(this);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        mtoolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mtoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SupportAppNavigator navigator = new SupportAppNavigator(this, R.id.container);
        mNavigatorHolder.setNavigator(navigator);
        if (savedInstanceState == null) {
            navigator.applyCommands(new Command[]{new Replace(new Screens.TaskListScreen())});
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new_task) {
            mMainPresenter.navigateToItemList();
            mtoolbar.setTitle("Tasks");
        } else if (id == R.id.nav_new_note) {
            mMainPresenter.navigateToItemList();
            mtoolbar.setTitle("Notes");
        } else if (id == R.id.nav_new_geo) {
            mMainPresenter.navigateToItemList();
            mtoolbar.setTitle("Geo Points");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
