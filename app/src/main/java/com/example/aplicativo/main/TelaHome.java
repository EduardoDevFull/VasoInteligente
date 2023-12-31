package com.example.aplicativo.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.aplicativo.R;
import com.example.aplicativo.databinding.ActivityMainBinding;
import com.example.aplicativo.fragment.HomeFragment;
import com.example.aplicativo.fragment.LoginFragment;
import com.example.aplicativo.fragment.PlantaFragment;
import com.example.aplicativo.fragment.RelatorioFragment;

public class TelaHome extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    this.replaceFragment(new HomeFragment());
                    break;
                case R.id.relatorio:
                    this.replaceFragment(new RelatorioFragment());
                    break;
                case R.id.planta:
                    this.replaceFragment(new PlantaFragment());
                    break;
                case R.id.profile:
                    this.replaceFragment(new LoginFragment());
                    break;

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
