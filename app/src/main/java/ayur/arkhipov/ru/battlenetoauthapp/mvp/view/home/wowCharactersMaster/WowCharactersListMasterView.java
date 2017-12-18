package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.model.WowCharacterDetailModel;

interface WowCharactersListMasterView extends BaseView {
    void onGetWowCharactersSuccess(WowCharacters wowCharacters);
    void onGetWowCharactersError(Throwable throwable);

    void showDetailFragment(WowCharacters.CharactersBean item);
}
