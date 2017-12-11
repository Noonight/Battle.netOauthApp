package ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model;


import java.io.Serializable;

public class AccessToken implements Serializable {

    /**
     * access_token : z9sbp6xsje4saj9x247a4pu8
     * token_type : bearer
     * expires_in : 2591999
     */

    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "access_token: " + access_token
                + "\ntoken_type: " + token_type
                + "\nexpires_in: " + expires_in;
    }
}
