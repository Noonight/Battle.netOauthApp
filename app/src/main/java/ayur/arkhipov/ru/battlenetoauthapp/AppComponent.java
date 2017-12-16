package ayur.arkhipov.ru.battlenetoauthapp;


import javax.inject.Singleton;

import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.HomeActivity;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.profile.ProfileFragment;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.WowCharactersListMasterFragment;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail.WowCharacterDetailFragment;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void injectHome(HomeActivity activity);
    void injectProfile(ProfileFragment fragment);
    void injectWowCharactersMaster(WowCharactersListMasterFragment fragment);

    void injectWowCharacterDetail(WowCharacterDetailFragment wowCharacterDetailFragment);
}
