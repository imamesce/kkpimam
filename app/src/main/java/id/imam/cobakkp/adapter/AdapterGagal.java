package id.imam.cobakkp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.R;
import id.imam.cobakkp.model.ModelGagal;

public class AdapterGagal extends FirestoreRecyclerAdapter<ModelGagal,AdapterGagal.AdapterHolderGagal> {
    OnItemClickListener listener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterGagal(@NonNull FirestoreRecyclerOptions<ModelGagal> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterHolderGagal adapterHolderGagal, int i, @NonNull ModelGagal modelGagal) {
        adapterHolderGagal.namawisata.setText(modelGagal.getNama_wisata());
        adapterHolderGagal.keterangan.setText(modelGagal.getKode_transaksi());
        adapterHolderGagal.keteranganwisata.setText(modelGagal.getKeterangan_wisata());
        adapterHolderGagal.hargawisata.setText(modelGagal.getHarga_wisata());
      //  adapterHolderGagal.waktugagal.setText(modelGagal.getWaktu_gagal());

    }

    @NonNull
    @Override
    public AdapterHolderGagal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View p = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesanan_gagal, parent, false);
        return  new AdapterHolderGagal(p);
    }

    public class AdapterHolderGagal extends RecyclerView.ViewHolder {
       private TextView keterangan,namawisata,keteranganwisata,hargawisata,waktugagal,kodee;
        public AdapterHolderGagal(@NonNull View itemView) {
            super(itemView);
            keterangan =  (TextView) itemView.findViewById(R.id.keterangan1gagal);
            hargawisata =itemView.findViewById(R.id.textView9gagal);
            namawisata = itemView.findViewById(R.id.textpesannamagagal);
            keteranganwisata = itemView.findViewById(R.id.orderketeranganwisatagagal);
            waktugagal = itemView.findViewById(R.id.idwaktugagal);
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
