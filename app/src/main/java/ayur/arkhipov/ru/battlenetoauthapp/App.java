package ayur.arkhipov.ru.battlenetoauthapp;


import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App instance;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = createComponent();
    }

    private AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).component;
    }

    public static App getAppContext() {
        return instance;
    }
}
