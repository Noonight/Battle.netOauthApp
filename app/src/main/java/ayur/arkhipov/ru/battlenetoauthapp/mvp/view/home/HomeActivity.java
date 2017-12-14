package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.NetworkManager;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.HomePresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.battle_tag_tv)
    TextView battleTag;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.bottom_navigator)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.wow_iv)
    ImageView wowIv;
    @BindView(R.id.sc2_iv)
    ImageView sc2Iv;

    @Inject
    HomePresenter presenter;

    private WowCharactersAdapter wowCharactersAdapter;
    private Sc2ProfileAdapter sc2ProfileAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.wow_characters_item_menu:
                    recyclerView.setAdapter(wowCharactersAdapter);
                    return true;
                case R.id.sc2_profile_item_menu:
                    recyclerView.setAdapter(sc2ProfileAdapter);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        App.getComponent(this).inject(this);
        init();
    }

    private void init() {

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        wowCharactersAdapter = new WowCharactersAdapter();
        sc2ProfileAdapter = new Sc2ProfileAdapter();
//      important check error
        presenter.attachView(this);
//
        wowCharactersAdapter.onWowItemClickListener = item -> Toast.makeText(HomeActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
        sc2ProfileAdapter.onSc2ItemClickListener = item -> Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();

        recyclerView.setAdapter(wowCharactersAdapter);

        wowIv.setOnClickListener(view -> recyclerView.setAdapter(wowCharactersAdapter));
        sc2Iv.setOnClickListener(view -> recyclerView.setAdapter(sc2ProfileAdapter));
    }

    /*public AccessToken getSerAccessToken() {
        return (AccessToken) getIntent().getSerializableExtra(AccessToken.class.getCanonicalName());
    }*/

    @Override
    public void onGetBattleTagSuccess(String name) {
        battleTag.setText(name);
    }

    @Override
    public void onGetBattleTagError(Throwable throwable) {
        battleTag.setText(throwable.getMessage());
    }

    @Override
    public void onGetWowCharactersSuccess(WowCharacters wowCharactersObjects) {
        wowCharactersAdapter.setData(wowCharactersObjects);
    }

    @Override
    public void onGetWowCharactersError(Throwable throwable) {
        //TODO
    }

    @Override
    public void onGetSc2ProfileSuccess(Sc2Profile sc2ProfileObject) {
        sc2ProfileAdapter.setData(sc2ProfileObject);
    }

    @Override
    public void onGetSc2ProfileError(Throwable throwable) {
        //TODO
    }
}
