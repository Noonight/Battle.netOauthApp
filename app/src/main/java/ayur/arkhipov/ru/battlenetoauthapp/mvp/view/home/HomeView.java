package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;

public interface HomeView extends BaseView{

    void onGetBattleTagSuccess(String name);
    void onGetBattleTagError(Throwable throwable);

}
