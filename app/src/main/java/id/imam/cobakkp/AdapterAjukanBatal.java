package id.imam.cobakkp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAjukanBatal  extends FirestoreRecyclerAdapter<ModelAjukanBatal,AdapterAjukanBatal.AdapterHolderAjukanBatal> {
    OnItemClickListener listener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterAjukanBatal(@NonNull FirestoreRecyclerOptions<ModelAjukanBatal> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterAjukanBatal.AdapterHolderAjukanBatal adapterHolderAjukanBatal, int i, @NonNull ModelAjukanBatal modelAjukanBatal) {
        adapterHolderAjukanBatal.id_order.setText(modelAjukanBatal.getId_wisata());

    }

    @NonNull
    @Override
    public AdapterHolderAjukanBatal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vn = LayoutInflater.from(parent.getContext()).inflate(R.layout.ajukan_batal, parent, false);
        return new AdapterHolderAjukanBatal(vn);
    }

    public class AdapterHolderAjukanBatal extends RecyclerView.ViewHolder {
        private TextView id_order;

        public AdapterHolderAjukanBatal(@NonNull View itemView) {
            super(itemView);
            id_order = itemView.findViewById(R.id.txtajukanbatal);
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

