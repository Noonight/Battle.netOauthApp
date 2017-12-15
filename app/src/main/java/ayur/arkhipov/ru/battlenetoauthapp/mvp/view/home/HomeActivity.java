package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.HomePresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.home_nv)
    NavigationView homeNv;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private View headerLayout;
//    @BindView(R.id.battle_tag_tv)
//    TextView battleTag;
//    @BindView(R.id.recycler_view)
//    RecyclerView recyclerView;
//    @BindView(R.id.bottom_navigator)
//    BottomNavigationView bottomNavigationView;
//    @BindView(R.id.wow_iv)
//    ImageView wowIv;
//    @BindView(R.id.sc2_iv)
//    ImageView sc2Iv;

    @Inject
    HomePresenter presenter;

//    private WowCharactersAdapter wowCharactersAdapter;
//    private Sc2ProfileAdapter sc2ProfileAdapter;

//    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.wow_characters_item_menu:
//                    recyclerView.setAdapter(wowCharactersAdapter);
//                    return true;
//                case R.id.sc2_profile_item_menu:
//                    recyclerView.setAdapter(sc2ProfileAdapter);
//                    return true;
//            }
//            return false;
//        }
//    };

    TextView battleTagHeaderTv;
    ImageView headHeaderIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        App.getComponent(this).inject(this);
        init();
    }

    private void init() {
        setSupportActionBar(homeToolbar);
        initNavigationView();
//        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

//        LinearLayoutManager layoutManager =
//                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);

//        wowCharactersAdapter = new WowCharactersAdapter();
//        sc2ProfileAdapter = new Sc2ProfileAdapter();
////      important check error
        presenter.attachView(this);
////
//        wowCharactersAdapter.onWowItemClickListener = item -> Toast.makeText(HomeActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
//        sc2ProfileAdapter.onSc2ItemClickListener = item -> Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();

//        recyclerView.setAdapter(wowCharactersAdapter);
//
//        wowIv.setOnClickListener(view -> recyclerView.setAdapter(wowCharactersAdapter));
//        sc2Iv.setOnClickListener(view -> recyclerView.setAdapter(sc2ProfileAdapter));
    }

    private void initNavigationView() {
        homeNv.setNavigationItemSelectedListener(this::selectDrawerItem);
        headerLayout = homeNv.getHeaderView(0);

        //headerLayout = homeNv.inflateHeaderView(R.layout.nv_header);
        battleTagHeaderTv = headerLayout.findViewById(R.id.battle_tag_nv_header_tv);
        headHeaderIv = headerLayout.findViewById(R.id.head_nv_header_iv);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, homeToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private boolean selectDrawerItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blizzard_profile_nv_item_menu:
                //TODO
                return true;
            case R.id.sign_out_nv_item_menu:
                //TODO
                return true;
            default:
                return true;
        }
    }

//    public AccessToken getSerAccessToken() {
//        return (AccessToken) getIntent().getSerializableExtra(AccessToken.class.getCanonicalName());
//    }

    @Override
    public void onGetBattleTagSuccess(String name) {
        battleTagHeaderTv.setText(name);
    }

    @Override
    public void onGetBattleTagError(Throwable throwable) {
        battleTagHeaderTv.setText(throwable.getMessage());
    }

}
