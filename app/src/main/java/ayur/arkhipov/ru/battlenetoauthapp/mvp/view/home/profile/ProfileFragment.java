package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.UserData;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.profile.ProfilePresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment implements ProfileView {

    @BindView(R.id.battle_tag_profile_tv)
    TextView battleTagProfileTv;
    @BindView(R.id.id_profile_tv)
    TextView idProfileTv;

    @Inject
    ProfilePresenter presenter;

    public static ProfileFragment newInstance(Bundle args) {
        ProfileFragment mInstance = new ProfileFragment();
        mInstance.setArguments(args);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        App.getComponent(getActivity()).injectProfile(this);
        presenter.attachView(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {

    }

    @Override
    public void onGetUserDataSuccess(UserData userData) {
        battleTagProfileTv.setText(userData.getBattletag());
        idProfileTv.setText(String.valueOf(userData.getId()));
    }

    @Override
    public void onGetUserDataError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
