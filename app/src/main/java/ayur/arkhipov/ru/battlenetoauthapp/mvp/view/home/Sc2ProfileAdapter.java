package ayur.arkhipov.ru.battlenetoauthapp.mvp.view.home;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import ayur.arkhipov.ru.battlenetoauthapp.common.network.model.Sc2Profile;

class Sc2ProfileAdapter extends RecyclerView.Adapter<Sc2ProfileAdapter.ViewHolder>{

    Sc2Profile sc2Profile;

    public Sc2ProfileAdapter() {
    }

    public void setData(Sc2Profile sc2Profile) {
        this.sc2Profile = sc2Profile;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
