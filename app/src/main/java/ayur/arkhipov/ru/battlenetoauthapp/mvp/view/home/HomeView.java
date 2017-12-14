package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;

public interface HomeView extends BaseView{

    void onGetBattleTagSuccess(String name);
    void onGetBattleTagError(Throwable throwable);

    void onGetWowCharactersSuccess(WowCharacters wowCharactersObjects);
    void onGetWowCharactersError(Throwable throwable);

    void onGetSc2ProfileSuccess(Sc2Profile sc2ProfileObject);
    void onGetSc2ProfileError(Throwable throwable);
}
