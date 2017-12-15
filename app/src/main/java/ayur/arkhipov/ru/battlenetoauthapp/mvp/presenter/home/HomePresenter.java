package ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home;


import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.HomeView;

public class HomePresenter extends BasePresenter<HomeView> {

    private BlizzardApi blizzardApi;

    @Inject
    public HomePresenter(BlizzardApi blizzardApi) {
        this.blizzardApi = blizzardApi;
    }

    public void getUserData() {
        blizzardApi.getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData -> getView().onGetBattleTagSuccess(userData.getBattletag())
                    , throwable -> getView().onGetBattleTagError(throwable));
    }

//    public void getWowCharacters() {
//        blizzardApi.getWowCharacters()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(wowCharacters -> getView().onGetWowCharactersSuccess(wowCharacters),
//                        throwable -> getView().onGetWowCharactersError(throwable));
//    }
//
//    public void getSc2Profile() {
//        blizzardApi.getSc2Profile()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(sc2Profile -> getView().onGetSc2ProfileSuccess(sc2Profile),
//                        throwable -> getView().onGetSc2ProfileError(throwable));
//    }

    @Override
    public void updateView() {
        getUserData();
//        getWowCharacters();
//        getSc2Profile();
    }
}
