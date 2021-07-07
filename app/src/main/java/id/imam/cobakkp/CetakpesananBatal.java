package id.imam.cobakkp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CetakpesananBatal extends AppCompatActivity {
private  TextView Namawisata,Hargawisata,Keterangan,Kodetransaksi,Tempatwisata,Keteranganwisata,Tanggalberangkat,Namapemesan,Tanggaldibatalkan,NamaAdmin;
private  Button btncetak;
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
        setContentView(R.layout.activity_cetakpesanan_batal);
        Namapemesan = findViewById(R.id.textView40);
        Namawisata = findViewById(R.id.textView33);
        Kodetransaksi = findViewById(R.id.textView30);
        Tanggalberangkat = findViewById(R.id.textView32);
        Keterangan = findViewById(R.id.textView31);
        Keteranganwisata = findViewById(R.id.textView38);
        Tempatwisata = findViewById(R.id.textView35);
        Hargawisata = findViewById(R.id.textView34);
        btncetak = findViewById(R.id.btncetak);

        NamaAdmin = findViewById(R.id.textView57);
        Tanggaldibatalkan = findViewById(R.id.textView55);



        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mDisplay = wm.getDefaultDisplay();

        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
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
        if (intentambildata.hasExtra("id_dia")) {
            String hargawisata = intentambildata.getStringExtra("harga_wisata");
            String keterangan = intentambildata.getStringExtra("status_pembatalan");
            String kodetransaksi = intentambildata.getStringExtra("id_dia");
            String namapemesan =  intentambildata.getStringExtra("nama_pemesan");
            String tanggalberangkat = intentambildata.getStringExtra("total_transfer");
            String namawisata = intentambildata.getStringExtra("nama_wisata");
            String tempatwisata = intentambildata.getStringExtra("tempat_wisata");
            String keteranganwisata = intentambildata.getStringExtra("keterangan_wisata");
            String namaadmin = intentambildata.getStringExtra("nama_admin");
            String tanggalbatal = intentambildata.getStringExtra("waktu_batal");
            NamaAdmin.setText(namaadmin);
            Tanggaldibatalkan.setText(tanggalbatal);
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

                    takeSt();
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


    private void takeSt() {
        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/BuktiBatalWisata/");

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

    private void openPdf(String path) {
        File file = new File(path);
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open FIle");
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "No Apps to read PDF FIle", Toast.LENGTH_SHORT).show();
        }
    }
}