package id.imam.cobakkp.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.R;

public class productviewholder extends RecyclerView.ViewHolder {
     TextView namapesan;

    public productviewholder(@NonNull View itemView) {
        super(itemView);
        namapesan = itemView.findViewById(R.id.textpesannama);
    }
}
