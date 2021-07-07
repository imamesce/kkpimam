package id.imam.cobakkp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.imam.cobakkp.activity.KonfirmasiPembatalan;
import id.imam.cobakkp.adapter.AdapterAjukanBatal;
import id.imam.cobakkp.adapter.AdapterPesananBatal;
import id.imam.cobakkp.model.ModelBerhasil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Batal extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    RecyclerView recyclerViewBatal;
    FirebaseFirestore firebaseFirestore;
   private AdapterAjukanBatal adapter11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batal);
        recyclerViewBatal = findViewById(R.id.recycpesananbatal1);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        String emailll = firebaseAuth.getCurrentUser().getEmail();
        Query query2 = firebaseFirestore.collection("order").whereEqualTo("alamat_email",emailll).whereEqualTo("keterangan","berhasil");
        FirestoreRecyclerOptions<ModelAjukanBatal> options12 = new FirestoreRecyclerOptions.Builder<ModelAjukanBatal>()
                .setQuery(query2,ModelAjukanBatal.class)
                .build();
        adapter11 = new AdapterAjukanBatal(options12);
        recyclerViewBatal.setAdapter(adapter11);
        recyclerViewBatal.setHasFixedSize(true);
        recyclerViewBatal.setLayoutManager(new LinearLayoutManager(this));

        adapter11.setOnItemClickListener(new AdapterAjukanBatal.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                String id = documentSnapshot.getId();
                String  hargawisata = documentSnapshot.getString("harga_wisata");
                String keterangan = documentSnapshot.getString("keterangan");
                String teleponn = documentSnapshot.getString("telepon_pemesan");
                String keteranganwisata = documentSnapshot.getString("keterangan_wisata");
                String kodetransaksi = documentSnapshot.getString("id_wisata");
                String namawisata = documentSnapshot.getString("nama_wisata");
                String email = documentSnapshot.getString("alamat_email");
                String tempat = documentSnapshot.getString("tempat_wisata");
                String id_order = documentSnapshot.getString("id_order");
              //  String nama_admin = documentSnapshot.getString("nama_admin");
                //String tanggal_batal = documentSnapshot.getString("waktu_batal");

                String tanggalberangkat = documentSnapshot.getString("tanggal_berangkat");
                String namapemesan = documentSnapshot.getString("nama_pemesan");
                Toast.makeText(Batal.this, "id" + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Batal.this, KonfirmasiPembatalan.class);
                //intent.putExtra("")
                intent.putExtra("telepon_pemesan",teleponn);
                intent.putExtra("id_order",id_order);
                intent.putExtra("id_wisata",kodetransaksi);
                intent.putExtra("harga_wisata",hargawisata);
                intent.putExtra("keterangan",keterangan);
                intent.putExtra("tempat_wisata",tempat);
                intent.putExtra("alamat_email",email);
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
        adapter11.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter11.stopListening();
    }
}