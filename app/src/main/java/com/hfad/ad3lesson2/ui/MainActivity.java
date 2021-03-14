package com.hfad.ad3lesson2.ui;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.hfad.ad3lesson2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}