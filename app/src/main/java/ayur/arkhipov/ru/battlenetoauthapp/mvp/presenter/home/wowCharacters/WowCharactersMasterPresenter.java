package ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.wowCharacters;


import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BasePresenter;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.WowCharactersListMasterFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WowCharactersMasterPresenter extends BasePresenter<WowCharactersListMasterFragment> {

    BlizzardApi blizzardApi;

    @Inject
    public WowCharactersMasterPresenter(BlizzardApi blizzardApi) {
        this.blizzardApi = blizzardApi;
    }

    public void getWowCharacters() {
        blizzardApi.getWowCharacters()
                .map(WowCharacters::getCharactersWithSpec)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wowCharacters -> getView().onGetWowCharactersSuccess(wowCharacters),
                        throwable -> getView().onGetWowCharactersError(throwable));
    }

    @Override
    public void updateView() {
        getWowCharacters();
    }
}
