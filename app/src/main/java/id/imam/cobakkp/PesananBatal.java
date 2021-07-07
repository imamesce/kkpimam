package id.imam.cobakkp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.activity.CetakData;
import id.imam.cobakkp.activity.KonfirmasiPembatalan;
import id.imam.cobakkp.adapter.AdapterBerhasil;
import id.imam.cobakkp.adapter.AdapterGagal;
import id.imam.cobakkp.adapter.AdapterPesanan;
import id.imam.cobakkp.adapter.AdapterPesananBatal;
import id.imam.cobakkp.model.ModelBerhasil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PesananBatal extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    RecyclerView recyclerViewBatal;
    FirebaseFirestore firebaseFirestore;
    AdapterPesananBatal adapter1;
    TextView totalll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_batal);
        recyclerViewBatal = findViewById(R.id.recycpesananbatal);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        String emailll = firebaseAuth.getCurrentUser().getEmail();
        totalll = findViewById(R.id.textView45);

        CollectionReference collectionReference = firebaseFirestore.collection("pembatalan_order");
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Query query23 = firebaseFirestore.collection("pembatalan_order").whereEqualTo("alamat_email",emailll).whereEqualTo("keterangan_pembatalan","false");
                query23.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            long totall = 0;
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                String statuss = documentSnapshot.getString("statuspembatalan");
                                long statusss = Long.parseLong(statuss);
                                totall += statusss;
                                String totel =""+totall;
                                totalll.getText().toString();
                                totalll.setText(totel);

                            }
                        }
                    }
                });
            }
        });


        Query query2 = firebaseFirestore.collection("pembatalan_order").whereEqualTo("alamat_email",emailll).whereEqualTo("keterangan_pembatalan","true");
        FirestoreRecyclerOptions<ModelBerhasil> options12 = new FirestoreRecyclerOptions.Builder<ModelBerhasil>()
                .setQuery(query2,ModelBerhasil.class)
                .build();
        adapter1 = new AdapterPesananBatal(options12);
        recyclerViewBatal.setAdapter(adapter1);
        recyclerViewBatal.setHasFixedSize(true);
        recyclerViewBatal.setLayoutManager(new LinearLayoutManager(this));
        adapter1.setOnItemClickListener(new AdapterPesananBatal.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                String id = documentSnapshot.getId();
                String  hargawisata = documentSnapshot.getString("harga_wisata");
                String keterangan = documentSnapshot.getString("keterangan");
                String keteranganwisata = documentSnapshot.getString("keterangan_wisata");
                String status_pembatalan = documentSnapshot.getString("status_pembatalan");
                String namawisata = documentSnapshot.getString("nama_wisata");
                String tempat = documentSnapshot.getString("tempat_wisata");
                String tanggalberangkat = documentSnapshot.getString("tanggal_berangkat");
                String namapemesan = documentSnapshot.getString("nama_pemesan");
                String emailll = documentSnapshot.getString("alamat_email");
                String id_dia = documentSnapshot.getString("id_dia");
                String total_transfer = documentSnapshot.getString("total_transfer");
                String nama_admin = documentSnapshot.getString("nama_admin");
                String waktu_batal = documentSnapshot.getString("waktu_batal");
               //  Toast.makeText(PesananBatal.this, "id" + id, Toast.LENGTH_LONG).show();
                Toast.makeText(PesananBatal.this, "ini adalah status pembatalan anda" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PesananBatal.this, CetakpesananBatal.class);
                intent.putExtra("nama_admin",nama_admin);
                intent.putExtra("waktu_batal",waktu_batal);
                intent.putExtra("id_dia",id_dia);
                intent.putExtra("harga_wisata",hargawisata);
                intent.putExtra("keterangan",keterangan);
                intent.putExtra("status_pembatalan",status_pembatalan);
                intent.putExtra("total_transfer",total_transfer);
                intent.putExtra("tempat_wisata",tempat);
                intent.putExtra("alamat_email",emailll);
                intent.putExtra("nama_wisata",namawisata);
                intent.putExtra("nama_pemesan",namapemesan);
                intent.putExtra("keterangan_wisata",keteranganwisata);
                intent.putExtra("tanggal_berangkat",tanggalberangkat);
                startActivity(intent);




            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}