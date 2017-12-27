package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.wowCharacters.wowCharacterDetail.WowCharacterDetailPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WowCharacterDetailFragment extends Fragment implements WowCharacterDetailView {

    /*@BindView(R.id.wow_character_detail_name_tv)
    TextView wowCharacterDetailNameTv;
    @BindView(R.id.wow_character_detail_realm_tv)
    TextView wowCharacterDetailRealmTv;*/

    @Inject
    WowCharacterDetailPresenter presenter;

    public static WowCharacterDetailFragment newInstance(Bundle bundle) {
        WowCharacterDetailFragment mInstance = new WowCharacterDetailFragment();
        mInstance.setArguments(bundle);
        return mInstance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wow_character_detail, container, false);
        ButterKnife.bind(this, view);
        App.getComponent(getActivity()).injectWowCharacterDetail(this);
        presenter.attachView(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        TESTbindView();
    }

    private void TESTbindView() {
        if (getArguments() != null) {
            Parcelable item = getArguments().getParcelable(WowCharacterDetailFragment.class.getName());
//            wowCharacterDetailNameTv.setText(((WowCharacters.CharactersBean) item).getName());
//            wowCharacterDetailRealmTv.setText(((WowCharacters.CharactersBean) item).getRealm());
        }
    }
}
