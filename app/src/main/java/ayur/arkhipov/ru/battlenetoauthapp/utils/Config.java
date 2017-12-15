package ayur.arkhipov.ru.battlenetoauthapp.utils;


import android.content.Context;
import android.content.SharedPreferences;

import ayur.arkhipov.ru.battlenetoauthapp.common.Constants;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;

public class Config {

    public static final String APP_PREFERENCES = "app_settings";

    private SharedPreferences sharedPreferences;

    public Config(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, context.MODE_PRIVATE);
    }

    public void putAccessToken(AccessToken accessToken) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.ACCESS_TOKEN, accessToken.getAccess_token());
        editor.apply();
        editor.commit();
    }

    public String getAccessToken() {
        return sharedPreferences.getString(Constants.ACCESS_TOKEN, "");
    }

}
