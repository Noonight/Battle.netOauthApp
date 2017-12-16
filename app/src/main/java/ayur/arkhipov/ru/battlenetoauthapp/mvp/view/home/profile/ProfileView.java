package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.profile;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.UserData;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;

public interface ProfileView extends BaseView {
    void onGetUserDataSuccess(UserData userData);
    void onGetUserDataError(Throwable throwable);
}
