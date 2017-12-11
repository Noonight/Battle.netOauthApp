package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.login;


import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;

public interface LoginView {

    void showWebView();
    void hideWebView();
    void startHomeActivity();
    void putAccessTokenToSharedPreferences(AccessToken accessToken);

}
