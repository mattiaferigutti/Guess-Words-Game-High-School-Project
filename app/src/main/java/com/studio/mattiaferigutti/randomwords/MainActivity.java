package com.studio.mattiaferigutti.randomwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.studio.mattiaferigutti.randomwords.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //site from where to get random words https://randomwordgenerator.com/
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //If a LiveData is in one of the binding expressions and no LifecycleOwner is set,
        // the LiveData will not be observed and updates to it will not be propagated to the UI.
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
    }
}