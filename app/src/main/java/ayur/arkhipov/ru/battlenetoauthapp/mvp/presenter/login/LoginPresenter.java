package ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.login;


import java.util.HashMap;
import java.util.Map;

import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.NetworkManagerBlizzard;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BasePresenter;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.login.LoginView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginView> {

    private NetworkManagerBlizzard networkManagerBlizzard;

    public LoginPresenter() {
        networkManagerBlizzard = new NetworkManagerBlizzard();
    }

    public void getAccessToken(Map<String, String> param) {
        networkManagerBlizzard.getBlizzardOauthApi().getAccessToken(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(accessToken -> {
                    getView().putAccessTokenToSharedPreferences(accessToken);
                    getView().startHomeActivity();
                }, throwable -> getView().onGetAccessTokenError(throwable));
    }

    public Map<String, String> createParamAccessToken(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("redirect_uri", "https://localhost");
        param.put("grant_type", "authorization_code");
        param.put("code", code);
        return param;
    }



    @Override
    public void updateView() {

    }
}
