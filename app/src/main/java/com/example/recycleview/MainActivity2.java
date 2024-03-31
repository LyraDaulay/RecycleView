package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private String namaItem;
    private String deskripsiItem;
    private String hargaItem;
    private int gambarItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        namaItem = intent.getStringExtra("productName");
        deskripsiItem = intent.getStringExtra("productDescription");
        hargaItem = intent.getStringExtra("productPrice");
        gambarItem = intent.getIntExtra("productImage", 0);

        TextView namaItemTextView = findViewById(R.id.namaitem);
        TextView deskripsiItemTextView = findViewById(R.id.deskripsiitem);
        TextView hargaItemTextView = findViewById(R.id.hargaitem);
        ImageView gambarItemImageView = findViewById(R.id.gambaritem);
        Button shareButton = findViewById(R.id.shareButton); // Memperbaiki tombol

        namaItemTextView.setText(namaItem);
        deskripsiItemTextView.setText(deskripsiItem);
        hargaItemTextView.setText(hargaItem);
        gambarItemImageView.setImageResource(gambarItem);

        // Menambahkan OnClickListener ke tombol
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShareButtonClick(v); // Memanggil metode onShareButtonClick saat tombol ditekan
            }
        });
    }

    // Metode untuk menanggapi klik tombol Share
    public void onShareButtonClick(View view) {
        String shareMessage = "Nama Item: " + namaItem + "\nDeskripsi: " + deskripsiItem + "\nHarga: " + hargaItem;

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}

