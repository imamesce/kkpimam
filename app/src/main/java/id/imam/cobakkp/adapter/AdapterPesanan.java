package id.imam.cobakkp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import java.text.SimpleDateFormat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.R;
import id.imam.cobakkp.model.ModelPesan;


public class AdapterPesanan extends FirestoreRecyclerAdapter<ModelPesan,AdapterPesanan.AdapterHolder> {
       OnItemClickListener listener;
    public AdapterPesanan(@NonNull FirestoreRecyclerOptions<ModelPesan> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterHolder adapterHolder, int i, @NonNull ModelPesan modelPesan) {
        adapterHolder.namaorderwisata.setText(modelPesan.getNama_wisata());
       //ini ambil integer... adapterHolder.hargaorderwisata.setText(String.valueOf(modelPesan.getHarga()));
        adapterHolder.hargaorderwisata.setText(modelPesan.getHarga_wisata());

        adapterHolder.keteranganwisata.setText(modelPesan.getKeterangan_wisata());
        adapterHolder.ketorder.setText(modelPesan.getKeterangan());

        //adapterHolder.idtransaksiku.setText(modelPesan.getHarga());
        //SimpleDateFormat spf = new SimpleDateFormat("MMM-dd-yyyy 'jam' hh:mm:ss z");
        //String date = spf.format(modelPesan.getDibuat());
        adapterHolder.waktuorder.setText(modelPesan.getTanggal_berangkat());
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pesan, parent, false);
        return new AdapterHolder(v);
    }


    public class AdapterHolder extends RecyclerView.ViewHolder{
        TextView namaorderwisata,hargaorderwisata,ketorder,keteranganwisata,waktuorder;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            namaorderwisata = itemView.findViewById(R.id.textpesannama);
            waktuorder = itemView.findViewById(R.id.idwaktu);
            hargaorderwisata=itemView.findViewById(R.id.hargawisata);
            ketorder = itemView.findViewById(R.id.keterangan);
            keteranganwisata = itemView.findViewById(R.id.orderketeranganwisata);


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
        this.listener = listener;
    }








}
