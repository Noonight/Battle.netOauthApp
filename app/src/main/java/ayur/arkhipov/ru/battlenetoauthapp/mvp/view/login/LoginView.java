package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.login;


import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;

public interface LoginView extends BaseView{

    void showWebView();
    void hideWebView();
    void startHomeActivity();
    void putAccessTokenToSharedPreferences(AccessToken accessToken);
    void onGetAccessTokenError(Throwable throwable);
    void signOut();

}
