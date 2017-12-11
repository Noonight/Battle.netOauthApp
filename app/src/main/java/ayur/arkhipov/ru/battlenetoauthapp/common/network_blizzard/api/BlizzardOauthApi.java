package ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.api;


import java.util.Map;

import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface BlizzardOauthApi {

    @FormUrlEncoded
    @POST("/oauth/token")
    Observable<AccessToken> getAccessToken(@FieldMap Map<String, String> fields);

    /*
    * https://us.battle.net/oauth/token
    *   ?grant_type=client_credentials
    *   &client_id=turbu6bcedutvmequfywpkrkvyjrvabg
    *   &client_secret=6YhGZBPBpT2HQtRrEEZWKAD4hNxGU2xw
    * */
}
