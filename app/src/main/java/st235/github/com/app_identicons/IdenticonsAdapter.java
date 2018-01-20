package st235.github.com.app_identicons;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import st235.github.com.identiconview.IdenticonView;

/**
 * Created by alexander on 28/12/2017.
 */

public class IdenticonsAdapter extends RecyclerView.Adapter<IdenticonsAdapter.IdenticonsViewHolder> {

    private final List<String> users = new ArrayList<>();

    public IdenticonsAdapter() {
        users.add("Waylon Dalton");
        users.add("Marcus Cruz");
        users.add("Eddie Randolph");
        users.add("Hadassah Hartman");
        users.add("Justine Henderson");
        users.add("Thalia Cobb");
        users.add("Angela Walker");
        users.add("Joanna Shaffer");
        users.add("Abdullah Lang");
        users.add("Mathias Little");
        users.add("Lia Shelton");
        users.add("Jonathon Sheppard");
        users.add("Will Odom");
        users.add("Adriana Fry");
        users.add("Elaina Vasquez");
        users.add("Landyn Martin");
        users.add("Madalyn Savage");
        users.add("Cindy Moss");
        users.add("Mathew Tapia");
        users.add("Ayanna Shields");
    }

    public static class IdenticonsViewHolder extends RecyclerView.ViewHolder {

        private TextView identiconTextView;
        private IdenticonView identiconView;

        public IdenticonsViewHolder(View itemView) {
            super(itemView);

            identiconView = itemView.findViewById(R.id.identicon);
            identiconTextView = itemView.findViewById(R.id.identiconText);
        }

        public void setText(@Nullable String text) {
            identiconView.setText(text);
            identiconTextView.setText(text);
        }
    }

    @Override
    public IdenticonsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_identicon, parent, false);
        return new IdenticonsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(IdenticonsViewHolder holder, int position) {
        holder.setText(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
