package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.Constants;
import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.NetworkManagerBlizzard;
import ayur.arkhipov.ru.battlenetoauthapp.common.network_blizzard.model.AccessToken;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.HomeActivity;
import ayur.arkhipov.ru.battlenetoauthapp.utils.SharedPreferencesConfig;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.web_view)
    WebView webView;
    private String code;
    private AccessToken newAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initWebView();

        showWebView();

        /*Handler handler = new Handler();
        handler.postDelayed(() -> {
        }, 5000);*/

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d("web View Finished");

                if (url.startsWith(Constants.REDIRECT_URL)) {
                    hideWebView();

                    Uri uri = Uri.parse(url);
                    code = uri.getQueryParameter(Constants.CODE);
                    Log.d(code);

                    if (!TextUtils.isEmpty(code)) {
                        Map<String, String> map = new HashMap<>();
                        map.put("redirect_uri", "https://localhost");
                        map.put("grant_type", "authorization_code");
                        map.put("code", code);
                        NetworkManagerBlizzard networkManager = new NetworkManagerBlizzard();
                        Subscription subscription = networkManager.getBlizzardOauthApi().getAccessToken(map)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(accessToken -> {
                                        newAccessToken = accessToken;
                                        Log.d(accessToken.toString());
                                        startHomeActivity();
                                    }
                                        , throwable -> Log.d(throwable.getMessage()));
                    } else {
                        Log.d(" Code is empty ");
                    }

                } else {
                    Log.d(url);
                }
            }
        });
    }

    @Override
    public void showWebView() {

        webView.setVisibility(View.VISIBLE);

        String url = "https://EU.battle.net/oauth/authorize" +
                "?response_type=code" +
                "&client_id=turbu6bcedutvmequfywpkrkvyjrvabg" +
                "&redirect_uri=https://localhost" +
                "&scope=wow.profile";
        webView.loadUrl(url);
    }

    @Override
    public void hideWebView() {
        webView.setVisibility(View.GONE);
    }

    @Override
    public void startHomeActivity() {
        if (newAccessToken != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(AccessToken.class.getCanonicalName(), newAccessToken);
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Log.d("access token is empty");
        }
    }

    @Override
    public void putAccessTokenToSharedPreferences(AccessToken accessToken) {
        SharedPreferencesConfig sharedPreferences = new SharedPreferencesConfig();
    }
}