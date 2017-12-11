package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

import ayur.arkhipov.ru.battlenetoauthapp.BuildConfig;
import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.log.Log;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.WowCharacters;
import ayur.arkhipov.ru.battlenetoauthapp.utils.GenderConverter;
import butterknife.BindView;
import butterknife.ButterKnife;

class WowCharactersAdapter extends RecyclerView.Adapter<WowCharactersAdapter.ViewHolder> {

    private WowCharacters wowCharacters;

    public WowCharactersAdapter() {
        wowCharacters = new WowCharacters();
        wowCharacters.setCharacters(new ArrayList<>());
    }

    public void setData(WowCharacters wowCharacters) {
        this.wowCharacters = wowCharacters;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wow_characters_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(wowCharacters.getCharacters().get(position));
    }

    @Override
    public int getItemCount() {
        return wowCharacters.getCharacters().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.wow_character_name)
        TextView wowCharacterName;
        @BindView(R.id.wow_character_class)
        TextView wowCharacterClass;
        @BindView(R.id.wow_character_gender)
        TextView wowCharacterGender;
        @BindView(R.id.wow_character_level)
        TextView wowCharacterLevel;
        @BindView(R.id.wow_character_race)
        TextView wowCharacterRace;
        @BindView(R.id.wow_character_spec)
        TextView wowCharacterSpec;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(WowCharacters.CharactersBean item) {
            //Log.d(item.getSpec().toString());
            if (item.getSpec() != null) {
                //Log.d(item.getSpec().getName() + "\t" + item.getSpec().getBackgroundImage());
                Glide.with(itemView)
                        .load("android.resource://" + BuildConfig.APPLICATION_ID + "/drawable/" + item.getSpec().getBackgroundImage().replaceAll("[-]", "_"))
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    itemView.setBackground(resource);
                                }
                            }
                        });
            }

            wowCharacterName.setText(item.getName());
            wowCharacterClass.setText("Class: " + String.valueOf(item.getClassX()));
            wowCharacterGender.setText("Gender: " + GenderConverter.getGender(item.getGender()));
            wowCharacterLevel.setText("Level: " + String.valueOf(item.getLevel()));
            wowCharacterRace.setText("Race: " + String.valueOf(item.getRace()));
            if (item.getSpec() != null) {
                wowCharacterSpec.setText("Spec: " + item.getSpec().getName());
            } else {
                wowCharacterSpec.setText("Spec not found");
            }
        }
    }
}
