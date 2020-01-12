package fr.epsi.birthdayapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnniversaireAdapter extends RecyclerView.Adapter<AnniversaireAdapter.VH>{

    private final ArrayList<Anniversaire> data;
    private LayoutInflater inflater;

    public AnniversaireAdapter(Activity cxt, ArrayList<Anniversaire> data){
        this.data = data;
        this.inflater = cxt.getLayoutInflater();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.nomTxt.setText(data.get(position).getNom());
        holder.dateTxt.setText(data.get(position).getDate());
        holder.telTxt.setText(data.get(position).getTel());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder{
            TextView nomTxt;
            TextView telTxt;
            TextView dateTxt;

        public VH(@NonNull View itemView) {

            super(itemView);

            nomTxt = itemView.findViewById(R.id.list_item_nom);
            telTxt = itemView.findViewById(R.id.list_item_tel);
            dateTxt = itemView.findViewById(R.id.list_item_date);
        }
    }
}
