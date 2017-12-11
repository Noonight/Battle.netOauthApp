package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;

interface HomeView {

    AccessToken getSerAccessToken();
    void bindBattleTag(String name);

}
