package ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.wowCharacters.wowCharacterDetail;


import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.common.network.api.BlizzardApi;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BasePresenter;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail.WowCharacterDetailView;

public class WowCharacterDetailPresenter extends BasePresenter<WowCharacterDetailView> {

    BlizzardApi blizzardApi;

    @Inject
    public WowCharacterDetailPresenter(BlizzardApi blizzardApi) {
        this.blizzardApi = blizzardApi;
    }

    public void getWowCharacterDetail() {
        //TODO
    }

    @Override
    public void updateView() {
        getWowCharacterDetail();
    }
}
