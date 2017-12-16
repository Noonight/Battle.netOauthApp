package ayur.arkhipov.ru.battlenetoauthapp.mvp.model;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;

public class WowCharacterDetailModel {

    String name;
    String realm;

    public WowCharacterDetailModel parse(WowCharacters.CharactersBean item) {
        WowCharacterDetailModel mInstance = new WowCharacterDetailModel();
        mInstance.name = item.getName();
        mInstance.realm = item.getRealm();
        return mInstance;
    }
}
