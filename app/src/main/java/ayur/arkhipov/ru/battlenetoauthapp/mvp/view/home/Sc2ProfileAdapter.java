package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;
import butterknife.BindView;
import butterknife.ButterKnife;

/*deprecated*/
class Sc2ProfileAdapter extends RecyclerView.Adapter<Sc2ProfileAdapter.ViewHolder>{

    private Sc2Profile sc2Profile;
    public OnSc2ItemClickListener onSc2ItemClickListener;

    public Sc2ProfileAdapter() {
        sc2Profile = new Sc2Profile();
        sc2Profile.setCharacters(new ArrayList<>());
    }

    public interface OnSc2ItemClickListener {
        void onSc2ItemClick(Sc2Profile.CharactersBean item);
    }

    public void setData(Sc2Profile sc2Profile) {
        this.sc2Profile = sc2Profile;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sc2_profile_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(sc2Profile.getCharacters().get(position), onSc2ItemClickListener);
    }

    @Override
    public int getItemCount() {
        return sc2Profile.getCharacters().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.sc2_profile_name_tv)
        TextView sc2ProfileNameTv;
        @BindView(R.id.sc2_profile_portrait_iv)
        ImageView sc2ProfilePortraitIv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(Sc2Profile.CharactersBean item, OnSc2ItemClickListener itemClickListener) {
            sc2ProfileNameTv.setText(item.getName());
            Glide.with(itemView)
                    .load(item.getAvatar().getUrl())
                    .into(sc2ProfilePortraitIv);
            itemView.setOnClickListener(view -> itemClickListener.onSc2ItemClick(item));
        }
    }
}
