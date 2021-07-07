package id.imam.cobakkp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import id.imam.cobakkp.BuildConfig;
import id.imam.cobakkp.R;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NamedNodeMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

public class CetakData extends AppCompatActivity {
private TextView Namawisata,Hargawisata,Keterangan,Kodetransaksi,Tempatwisata,Keteranganwisata,Tanggalberangkat,Namapemesan,Tanggalberhasil,NamaAdmin;
private Button btncetak;

    Display mDisplay;
    String imagesUri;
    String path;
    Bitmap bitmap;

    int totalHeight;
    int totalWidth;

    public static final int READ_PHONE = 110;
    String file_name = "Bukti bayar suka suka saya";
    File myPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_data);
        Namapemesan = findViewById(R.id.textView40);
        Tanggalberhasil = findViewById(R.id.textView60);
        NamaAdmin = findViewById(R.id.textView61);
        Namawisata = findViewById(R.id.textView33);
        Kodetransaksi = findViewById(R.id.textView30);
        Tanggalberangkat = findViewById(R.id.textView32);
        Keterangan = findViewById(R.id.textView31);
        Keteranganwisata = findViewById(R.id.textView38);
        Tempatwisata = findViewById(R.id.textView35);
        Hargawisata = findViewById(R.id.textView34);
        btncetak = findViewById(R.id.btncetak);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mDisplay = wm.getDefaultDisplay();
/**
        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
*/
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED){
            }else{
                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PHONE);
            }
        }


        Intent intentambildata = getIntent();
        if (intentambildata.hasExtra("id_wisata")) {
            String hargawisata = intentambildata.getStringExtra("harga_wisata");
            String keterangan = intentambildata.getStringExtra("keterangan");
            String kodetransaksi = intentambildata.getStringExtra("id_wisata");
            String namapemesan =  intentambildata.getStringExtra("nama_pemesan");
            String tanggalberangkat = intentambildata.getStringExtra("tanggal_berangkat");
            String namawisata = intentambildata.getStringExtra("nama_wisata");
            String tempatwisata = intentambildata.getStringExtra("tempat_wisata");
            String keteranganwisata = intentambildata.getStringExtra("keterangan_wisata");
            String namaAdmin = intentambildata.getStringExtra("nama_admin");
            String tanggalberhasil = intentambildata.getStringExtra("tanggal_berhasil");
            NamaAdmin.setText(namaAdmin);
            Tanggalberhasil.setText(tanggalberhasil);
            Tanggalberangkat.setText(tanggalberangkat);
            Namapemesan.setText(namapemesan);
            Namawisata.setText(namawisata);
            Kodetransaksi.setText(kodetransaksi);
            Keterangan.setText(keterangan);
            Keteranganwisata.setText(keteranganwisata);
            Tempatwisata.setText(tempatwisata);
            Hargawisata.setText(hargawisata);

            btncetak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btncetak.setVisibility(View.GONE);

                    takeS();
                    btncetak.setVisibility(View.VISIBLE);
                }
            });


        }
    }
    public Bitmap getBitmapFromView(View view, int totalHeight, int totalWidth){

        Bitmap returnedBitmap = Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();

        if(bgDrawable != null){
            bgDrawable.draw(canvas);
        }else{
            canvas.drawColor(Color.WHITE);
        }

        view.draw(canvas);
        return returnedBitmap;
    }

    private void takeS() {
        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/BuktiBayarWisata/");

        if(!folder.exists()){
            boolean success = folder.mkdir();
        }

        path = folder.getAbsolutePath();
        path = path + "/" + file_name + System.currentTimeMillis() + ".pdf";

        View u = findViewById(R.id.nestedcetak);

        NestedScrollView z = findViewById(R.id.nestedcetak);
        totalHeight = z.getChildAt(0).getHeight();
        totalWidth = z.getChildAt(0).getWidth();

        String extr = Environment.getExternalStorageDirectory() + "/Flight Ticket/";
        File file = new File(extr);
        if(!file.exists())
            file.mkdir();
        String fileName = file_name + ".jpg";
        myPath = new File(extr, fileName);
        imagesUri = myPath.getPath();
        bitmap = getBitmapFromView(u, totalHeight, totalWidth);

        try{
            FileOutputStream fos = new FileOutputStream(myPath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        createPdf();



    }

    private void createPdf() {
        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawPaint(paint);

        Bitmap bitmap = Bitmap.createScaledBitmap(this.bitmap, this.bitmap.getWidth(), this.bitmap.getHeight(), true);

        paint.setColor(Color.BLUE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        document.finishPage(page);
        File filePath = new File(path);
        try{
            document.writeTo(new FileOutputStream(filePath));
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Something Wrong: "+e.toString(), Toast.LENGTH_SHORT).show();
        }

        document.close();

        if (myPath.exists())
            myPath.delete();

        openPdf(path);



}
//------------------------------------------------------------------------------------------------------------
    public File getFile(Context context, String fileName) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return null;
        }

        File storageDir = context.getExternalFilesDir(null);
        return new File(storageDir, fileName);
    }

    public Uri getFileUri(Context context, String fileName) {
        File file = getFile(context, fileName);
        return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
    }

    private void openPdf(String path) {

        Uri uri  = getFileUri(this,path);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");

        // FLAG_GRANT_READ_URI_PERMISSION is needed on API 24+ so the activity opening the file can read it
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        if (intent.resolveActivity(getPackageManager()) == null) {
            // Show an error
        } else {
            startActivity(intent);
        }

//................................................................................................................


    }
}