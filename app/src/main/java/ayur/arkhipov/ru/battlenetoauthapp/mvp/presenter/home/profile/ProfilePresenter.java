package ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.profile;


import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BasePresenter;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.profile.ProfileView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ProfilePresenter extends BasePresenter<ProfileView> {

    BlizzardApi blizzardApi;

    @Inject
    public ProfilePresenter(BlizzardApi blizzardApi) {
        this.blizzardApi = blizzardApi;
    }

    public void getUserData() {
        blizzardApi.getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData -> getView().onGetUserDataSuccess(userData)
                        , throwable -> getView().onGetUserDataError(throwable));
    }

    @Override
    public void updateView() {
        getUserData();
    }
}
