package id.imam.cobakkp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.activity.DetailActivity;
import id.imam.cobakkp.R;
import id.imam.cobakkp.activity.OrderActivity;
import id.imam.cobakkp.model.ModelWisata;
import id.imam.cobakkp.model.ModelWisatabaru;

public class Adapterwisata  extends FirestoreRecyclerAdapter<ModelWisatabaru,Adapterwisata.AdapterHolder> {

        OnItemClickListener listener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapterwisata(@NonNull FirestoreRecyclerOptions<ModelWisatabaru> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterHolder adapterHolder, int i, @NonNull ModelWisatabaru modelWisatabaru) {
        adapterHolder.tempatWisata.setText(modelWisatabaru.getTempat_wisata());
        adapterHolder.tanggalberangkat.setText(modelWisatabaru.getTanggal_berangkat());
        Picasso.get().load(modelWisatabaru.getGambar_wisata()).into(adapterHolder.imagehome);
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kategori_jawa_barat, parent, false);
            return new AdapterHolder(v);
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        private TextView tempatWisata,tanggalberangkat;
        private ImageView imagehome;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tempatWisata = itemView.findViewById(R.id.textView);
        imagehome = itemView.findViewById(R.id.imageHome);
        tanggalberangkat=itemView.findViewById(R.id.textView41);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null){
                    listener.onItemClick(getSnapshots().getSnapshot(position),position);
                }
            }
        });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);

    }
    public void  setOnItemClickListener(OnItemClickListener listener){
        this.listener =  listener;
    }


}

