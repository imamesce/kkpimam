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
import id.imam.cobakkp.model.ModelBerhasil;

public class AdapterPesananBatal extends FirestoreRecyclerAdapter<ModelBerhasil,AdapterPesananBatal.AdapterHolderBatal> {
    OnItemClickListener listener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterPesananBatal(@NonNull FirestoreRecyclerOptions<ModelBerhasil> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull AdapterPesananBatal.AdapterHolderBatal adapterHolderBatal, int i, @NonNull ModelBerhasil modelBerhasil) {
        adapterHolderBatal.id_order.setText(modelBerhasil.getId_dia());
        adapterHolderBatal.keterangann.setText(modelBerhasil.getStatus_pembatalan());
        adapterHolderBatal.cekrekening.setText(modelBerhasil.getKeterangan_transfer());

    }

    @NonNull
    @Override
    public AdapterHolderBatal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesanan_batal, parent, false);
        return new AdapterHolderBatal(v);
    }

    public class AdapterHolderBatal extends RecyclerView.ViewHolder {
        private TextView id_order,keterangann,cekrekening;
        public AdapterHolderBatal(@NonNull View itemView) {

            super(itemView);
            id_order = itemView.findViewById(R.id.txtberhasil);
            keterangann = itemView.findViewById(R.id.idtransaksi);
            cekrekening = itemView.findViewById(R.id.textView44);
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
