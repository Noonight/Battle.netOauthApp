package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.base.BaseView;

public interface WowCharacterDetailView extends BaseView {

    void bindView(WowCharacters.CharactersBean item);

}
