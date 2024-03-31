package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterProduct.ItemClickListener {

    private RecyclerView recyclerView;
    private AdapterProduct adapterProduct;
    private ArrayList<listproduct> listproducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapterProduct = new AdapterProduct(listproducts);
        adapterProduct.setOnItemClickListener(this); // Set listener di sini
        recyclerView.setAdapter(adapterProduct);
    }

    private void getData() {
        listproducts = new ArrayList<>();
        listproducts.add(new listproduct("Tulip", R.drawable.tulipffp, "Bunga Tulip segar dan tersedia berbagai warna yang menarik", "Rp.19.000"));
        listproducts.add(new listproduct("Mawar1", R.drawable.mawarrr, "Bunga Mawar segar 1 tangkai dan tersedia berbagai warna yang menarik", "Rp.19.000"));
        listproducts.add(new listproduct("Melati", R.drawable.melatie, "Bunga Melati segar dan tersedia berbagai warna yang menarik", "Rp.19.000"));
        listproducts.add(new listproduct("Anggrek", R.drawable.anggrekk, "Bunga Anggrek segar dan tersedia berbagai warna yang menarik", "Rp.19.000" ));
        listproducts.add(new listproduct("Matahari", R.drawable.suns,"Bunga Matahari segar dan tersedia berbagai warna yang menarik", "Rp.19.000" ));
        listproducts.add(new listproduct("Mawar2", R.drawable.mawarssr, "Bunga Mawar segar 2 tangkai dan tersedia berbagai warna", "Rp. 25.000"));
        listproducts.add(new listproduct("Teddy", R.drawable.teddyu, "Boneka Teddy ukuran sedang berwarna cokelat yang lucu", "Rp.45.000"));
        listproducts.add(new listproduct("Stitch", R.drawable.stich, "Boneka Stitch ukuran sedang berwarna biru yang lucu", "Rp.45.000"));
        listproducts.add(new listproduct("Doraemon", R.drawable.doraemon, "Boneka Doraemon ukuran sedang berwarna biru yang lucu", "Rp.45.000"));
        listproducts.add(new listproduct("Bird", R.drawable.birdx, "Boneka Angry Bird ukuran sedang dan tersedia berbagai warna", "Rp.45.000"));
        listproducts.add(new listproduct("Rabbit", R.drawable.rabbitr, "Boneka Kelinci ukuran sedang dan tersedia berbagai warna", "Rp.45.000"));
        listproducts.add(new listproduct("Facemask", R.drawable.facemask, "Facemask yang baik digunakan sebelum tidur agar wajah terlihat lebih cerah", "Rp.20.000"));
        listproducts.add(new listproduct("Facewash", R.drawable.facewash, "Facewash yang baik digunakan untuk cuci muka agar wajah terlihat lebih cerah", "Rp.20.000"));
        listproducts.add(new listproduct("Lipbalm", R.drawable.lipbalm, "Lipbalm yang baik digunakan agar bibir terasa lebih lembab", "Rp.20.000"));
        listproducts.add(new listproduct("Serum", R.drawable.serum, "Serum yang baik digunakan agar wajah terlihat lebih cerah", "Rp.45.000"));
        listproducts.add(new listproduct("Sunscreen", R.drawable.sunscreen, "Sunscreen yang baik digunakan agar terlindungi dari sinar matahari", "Rp.35.000"));
    }


    @Override
    public void onItemClick(int position) {
        // Meng-handle klik pada item RecyclerView di sini
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("productName", listproducts.get(position).getNamaItem());
        intent.putExtra("productDescription", listproducts.get(position).getDeskripsiItem());
        intent.putExtra("productPrice", listproducts.get(position).getHargaItem());
        intent.putExtra("productImage", listproducts.get(position).getLogoitem());
        startActivity(intent);
    }
}









