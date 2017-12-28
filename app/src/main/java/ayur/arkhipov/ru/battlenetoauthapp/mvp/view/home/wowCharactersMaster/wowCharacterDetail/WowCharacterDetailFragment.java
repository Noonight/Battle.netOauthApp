package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home.wowCharactersMaster.wowCharacterDetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import ayur.arkhipov.ru.battlenetoauthapp.App;
import ayur.arkhipov.ru.battlenetoauthapp.BuildConfig;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.Constants;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.mvp.presenter.home.wowCharacters.wowCharacterDetail.WowCharacterDetailPresenter;
import ayur.arkhipov.ru.battlenetoauthapp.utils.Classes;
import ayur.arkhipov.ru.battlenetoauthapp.utils.Races;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class WowCharacterDetailFragment extends Fragment implements WowCharacterDetailView {

    /*@BindView(R.id.wow_character_detail_name_tv)
    TextView wowCharacterDetailNameTv;
    @BindView(R.id.wow_character_detail_realm_tv)
    TextView wowCharacterDetailRealmTv;*/

    @BindView(R.id.wow_character_nick_item_tv)
    TextView wowCharacterNickItemtv;
    @BindView(R.id.wow_character_realm_item_tv)
    TextView wowCharacterRealmItemTv;
    @BindView(R.id.wow_character_detail_race_tv)
    TextView wowCharacterDetailRaceTv;
    @BindView(R.id.wow_character_level_item_tv)
    TextView wowCharacterLevelItemTv;
    @BindView(R.id.wow_character_text_level_tv)
    TextView wowCharacterTextLevelTv;
    @BindView(R.id.wow_character_detail_class_tv)
    TextView wowCharacterDetailClassTv;

    @BindView(R.id.wow_character_detail_face_iv)
    ImageView wowCharacterDetailFaceIv;

    @BindViews({
            R.id.wow_character_nick_item_tv,
            R.id.wow_character_realm_item_tv,
            R.id.wow_character_detail_race_tv,
            R.id.wow_character_level_item_tv,
            R.id.wow_character_text_level_tv,
            R.id.wow_character_detail_class_tv
    })
    List<TextView> detail;

    @BindView(R.id.wow_character_detail_spec_name_tv)
    TextView wowCharacterDetailSpecNameTv;
    @BindView(R.id.wow_character_detail_spec_role_tv)
    TextView wowCharacterDetailSpecRoleTv;
    @BindView(R.id.wow_character_detail_spec_description_tv)
    TextView wowCharacterDetailSpecDescriptionTv;

    @BindView(R.id.wow_character_detail_spec_background_iv)
    ImageView wowCharacterDetailSpecBackgroundIv;

    @BindViews({
            R.id.wow_character_detail_spec_name_tv,
            R.id.wow_character_detail_spec_role_tv,
            R.id.wow_character_detail_spec_description_tv,
            R.id.wow_character_detail_spec_text_role_tv,
            R.id.wow_character_detail_spec_text_description_tv
    })
    List<TextView> detailSpec;

    @BindView(R.id.wow_character_detail_spec_not_found_tv)
    TextView wowCharacterDetailSpecNotFoundTv;

    /*@BindView(R.id.wow_character_detail_spec_text_role_tv)
    TextView wowCharacterDetailSpecTextRoleTv;*/

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
        bindView(getParcelableCharacterItem());
    }

    @Override
    public void bindView(WowCharacters.CharactersBean item) {
        wowCharacterNickItemtv.setText(item.getName());
        wowCharacterRealmItemTv.setText(item.getRealm());
        wowCharacterDetailRaceTv.setText(Races.getStringRaceById(item.getRace()));
        wowCharacterLevelItemTv.setText(String.valueOf(item.getLevel()));
        Glide.with(this)
                .load(Constants.THUMBNAIL_URL + item.getThumbnail())
                .placeholder(R.mipmap.wow_logo)
                .error(R.drawable.icon_warning)
                .into(wowCharacterDetailFaceIv);
        wowCharacterDetailClassTv.setText(Classes.getClassString(item.getClassX()));
        setTextColorWithClassId(item.getClassX());

        if (item.getSpec() != null) {
            showDetailSpec();
            wowCharacterDetailSpecNameTv.setText(item.getSpec().getName());
            wowCharacterDetailSpecRoleTv.setText(item.getSpec().getRole());
            wowCharacterDetailSpecDescriptionTv.setText(item.getSpec().getDescription());

            Glide.with(getContext())
                    .load("android.resource://" + BuildConfig.APPLICATION_ID + "/drawable/" + item.getSpec().getBackgroundImage().replaceAll("[-]", "_"))
                    .into(wowCharacterDetailSpecBackgroundIv);
        } else {
            hideDetailSpec();
            /*Glide.with(getContext())
                    .load(R.drawable.bg_no_spec)
                    .into(wowCharacterDetailSpecBackgroundIv);*/
        }

    }

    private void hideDetailSpec() {
        wowCharacterDetailSpecNotFoundTv.setVisibility(View.VISIBLE);
        ButterKnife.apply(detailSpec, (view, value, index) -> view.setVisibility(value), View.INVISIBLE);
    }

    private void showDetailSpec() {
        ButterKnife.apply(detailSpec, (view, value, index) -> view.setVisibility(value), View.VISIBLE);
        wowCharacterDetailSpecNotFoundTv.setVisibility(View.GONE);
    }

    private void setTextColorWithClassId(int id) {
        int color = ContextCompat.getColor(this.getContext(), Classes.getClassColorResId(id));
        ButterKnife.apply(detail, (view, value, index) -> view.setTextColor(value), color);
        ButterKnife.apply(detailSpec, (view, value, index) -> view.setTextColor(value), color);
        /*wowCharacterNickItemtv.setTextColor(color);
        wowCharacterRealmItemTv.setTextColor(color);
        wowCharacterTextLevelTv.setTextColor(color);
        wowCharacterDetailClassTv.setTextColor(color);
        wowCharacterDetailRaceTv.setTextColor(color);
        wowCharacterLevelItemTv.setTextColor(color);*/
    }

    private WowCharacters.CharactersBean getParcelableCharacterItem() {
//        WowCharacters.CharactersBean item = getArguments()!= null
//                ?   ((WowCharacters.CharactersBean) getArguments().getParcelable(WowCharacterDetailFragment.class.getName()))
//                :   new WowCharacters.CharactersBean();
        return getArguments() != null
                ? ((WowCharacters.CharactersBean) getArguments().getParcelable(WowCharacterDetailFragment.class.getName()))
                : new WowCharacters.CharactersBean();
    }
}
