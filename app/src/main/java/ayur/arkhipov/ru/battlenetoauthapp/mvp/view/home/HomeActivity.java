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

import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.NetworkManager;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
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

    private NetworkManager networkManager;

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
        init();
    }

    private void init() {
        networkManager = new NetworkManager(getSerAccessToken());
        networkManager.getBlizzardApi().getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData -> {
                    bindBattleTag(userData.getBattletag());
                }, throwable -> Log.d(throwable.getMessage()));
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        wowCharactersAdapter = new WowCharactersAdapter();
        recyclerView.setAdapter(wowCharactersAdapter);
        networkManager.getBlizzardApi().getWowCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wowCharacters -> {
                            setWowCharactersData(wowCharacters);
                            Log.d(wowCharacters.toString());
                        }
                        , throwable -> Log.d(throwable.getMessage()));

        sc2ProfileAdapter = new Sc2ProfileAdapter();

        wowIv.setOnClickListener(view -> {
            recyclerView.setAdapter(wowCharactersAdapter);
        });
        sc2Iv.setOnClickListener(view -> {
            recyclerView.setAdapter(sc2ProfileAdapter);
        });
    }

    public void setWowCharactersData(WowCharacters wowCharacters) {
        wowCharactersAdapter.setData(wowCharacters);
    }

    public void setSc2ProfileAdapterData(Sc2Profile sc2Profile) {
        sc2ProfileAdapter.setData(sc2Profile);
    }

    @Override
    public AccessToken getSerAccessToken() {
        return (AccessToken) getIntent().getSerializableExtra(AccessToken.class.getCanonicalName());
    }

    @Override
    public void bindBattleTag(String text) {
        battleTag.setText(text);
    }
}
