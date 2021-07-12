package id.imam.cobakkp.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.R;
import id.imam.cobakkp.model.ModelBerhasil;

public class AdapterBerhasil extends FirestoreRecyclerAdapter<ModelBerhasil,AdapterBerhasil.AdapterHolderBerhasil> {
    OnItemClickListener listener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterBerhasil(@NonNull FirestoreRecyclerOptions<ModelBerhasil> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterHolderBerhasil adapterHolderBerhasil, int i, @NonNull ModelBerhasil modelBerhasil) {
        adapterHolderBerhasil.id_order.setText(modelBerhasil.getId_wisata());
    }

    @NonNull
    @Override
    public AdapterHolderBerhasil onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesanan_berhasill, parent, false);
        return new AdapterHolderBerhasil(v);
    }

    public class AdapterHolderBerhasil extends RecyclerView.ViewHolder {
        private TextView id_order;
        public AdapterHolderBerhasil(@NonNull View itemView) {
            super(itemView);
            id_order = itemView.findViewById(R.id.txtberhasil);
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
