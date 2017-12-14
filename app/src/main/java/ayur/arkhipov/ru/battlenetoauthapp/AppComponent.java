package ayur.arkhipov.ru.battlenetoauthapp;


import javax.inject.Singleton;

import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.HomeActivity;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void inject(HomeActivity activity);
}
