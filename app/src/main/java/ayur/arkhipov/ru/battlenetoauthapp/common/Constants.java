package ayur.arkhipov.ru.battlenetoauthapp.common;


public class Constants {
    public static final String REDIRECT_URL = "https://localhost";
    public static final String CODE = "code";
    public static final String RESPONSE_TYPE = "code";
    public static final String CLIENT_ID = "turbu6bcedutvmequfywpkrkvyjrvabg";
    public static final String BASE_AUTHORIZE_URI = "https://eu.battle.net/oauth/authorize";
    public static final String AUTHORIZE_URI = "https://eu.battle.net/oauth/authorize?"
            + "response_type="+RESPONSE_TYPE+"&client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URL;
    public static final String ACCESS_TOKEN = "access_token";
    public static final String API_URL = "https://eu.api.battle.net";
}
