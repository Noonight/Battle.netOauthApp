package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ayur.arkhipov.ru.battlenetoauthapp.R;

public class ProfileFragment extends Fragment implements ProfileView {

    public static ProfileFragment newInstance(Bundle args) {
        ProfileFragment mInstance = new ProfileFragment();
        mInstance.setArguments(args);
        return mInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
