package id.imam.cobakkp.fragment;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.Batal;
import id.imam.cobakkp.PesananBatal;
import id.imam.cobakkp.R;
import id.imam.cobakkp.activity.CetakData;
import id.imam.cobakkp.activity.DetailActivity;
import id.imam.cobakkp.adapter.AdapterBerhasil;
import id.imam.cobakkp.adapter.AdapterPesanan;
import id.imam.cobakkp.adapter.Adapterwisata;
import id.imam.cobakkp.model.ModelBerhasil;
import id.imam.cobakkp.model.ModelPesan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class PesanFragment extends Fragment {
    RecyclerView recyclerViewFragmentPesanan;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    CardView cardajukanpembatalan;



    FirebaseFirestore firebaseFirestore;
    AdapterBerhasil adapter;

    public PesanFragment(){

}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pesan,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewFragmentPesanan = view.findViewById(R.id.recylerviewpesan);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        cardajukanpembatalan = view.findViewById(R.id.cardajukanpembatalan);

        cardajukanpembatalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zzz1= new Intent(getActivity(), Batal.class);
                startActivity(zzz1);
            }
        });

        String emailll = firebaseAuth.getCurrentUser().getEmail();





        Query query2 = firebaseFirestore.collection("order").whereEqualTo("alamat_email",emailll).whereEqualTo("keterangan","berhasil");
        FirestoreRecyclerOptions<ModelBerhasil>options1 = new FirestoreRecyclerOptions.Builder<ModelBerhasil>()
                .setQuery(query2,ModelBerhasil.class)
                .build();


        adapter = new AdapterBerhasil(options1);
        recyclerViewFragmentPesanan.setAdapter(adapter);
        recyclerViewFragmentPesanan.setHasFixedSize(true);
        recyclerViewFragmentPesanan.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter.setOnItemClickListener(new AdapterBerhasil.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                String id = documentSnapshot.getId();
                String  hargawisata = documentSnapshot.getString("harga_wisata");
                String keterangan = documentSnapshot.getString("keterangan");
                String keteranganwisata = documentSnapshot.getString("keterangan_wisata");
                String kodetransaksi = documentSnapshot.getString("id_wisata");
                String namawisata = documentSnapshot.getString("nama_wisata");
                String tempat = documentSnapshot.getString("tempat_wisata");
                String tanggalberangkat = documentSnapshot.getString("tanggal_berangkat");
                String namapemesan = documentSnapshot.getString("nama_pemesan");

                String namaadmin = documentSnapshot.getString("nama_admin");
                String tanggalberhasi = documentSnapshot.getString("tanggal_berhasil");

                Toast.makeText(getActivity(), "id" + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), CetakData.class);

                intent.putExtra("nama_admin",namaadmin);
                intent.putExtra("tanggal_berhasil",tanggalberhasi);

                intent.putExtra("tanggal_berangkat",tanggalberangkat);
               // intent.putExtra("id_wisata",id);
                intent.putExtra("harga_wisata",hargawisata);
                intent.putExtra("keterangan",keterangan);
                intent.putExtra("keterangan_wisata",keteranganwisata);
                intent.putExtra("id_wisata",kodetransaksi);
                intent.putExtra("nama_wisata",namawisata);
                intent.putExtra("tempat_wisata",tempat);
                intent.putExtra("nama_pemesan",namapemesan);
                startActivity(intent);


            }
        });





    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}