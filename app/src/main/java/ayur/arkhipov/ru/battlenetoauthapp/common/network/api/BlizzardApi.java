package ayur.arkhipov.ru.battlenetoauthapp.common.network.api;


import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.UserData;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import retrofit2.http.GET;
import rx.Observable;

public interface BlizzardApi {

    @GET("/account/user")
    Observable<UserData> getUserData();

    @GET("/wow/user/characters")
    Observable<WowCharacters> getWowCharacters();

    @GET("/sc2/profile/user")
    Observable<Sc2Profile> getSc2Profile();

}
