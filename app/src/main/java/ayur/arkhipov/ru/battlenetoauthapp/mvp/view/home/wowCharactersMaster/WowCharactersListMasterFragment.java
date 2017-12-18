package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.model.WowCharacterDetailModel;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.wowCharacters.WowCharactersMasterPresenter;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail.WowCharacterDetailFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WowCharactersListMasterFragment extends Fragment implements WowCharactersListMasterView {

    @BindView(R.id.wow_characters_list_rv)
    RecyclerView wowCharactersListRv;

    @Inject
    WowCharactersMasterPresenter presenter;

    private WowCharactersListMasterAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wow_characters_list, container, false);
        ButterKnife.bind(this, view);
        App.getComponent(getActivity()).injectWowCharactersMaster(this);
        presenter.attachView(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        wowCharactersListRv.setLayoutManager(layoutManager);
        adapter = new WowCharactersListMasterAdapter();
        wowCharactersListRv.setAdapter(adapter);

        adapter.onWowItemClickListener = this::showDetailFragment;
    }

    @Override
    public void onGetWowCharactersSuccess(WowCharacters wowCharacters) {
        adapter.setData(wowCharacters);
    }

    @Override
    public void onGetWowCharactersError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailFragment(WowCharacters.CharactersBean item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(WowCharacterDetailFragment.class.getName(), item);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_fragment_container, WowCharacterDetailFragment.newInstance(bundle), WowCharacterDetailFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }
}
