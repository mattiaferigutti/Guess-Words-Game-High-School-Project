package com.studio.mattiaferigutti.randomwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //site from where to get random words https://randomwordgenerator.com/
    private Button nextButton, previousButton;
    private TextView wordText;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        wordText = findViewById(R.id.wordText);

        //subscriber that observes every change
        viewModel.getCurrentWord().observe(this, currentWord -> {
            wordText.setText(currentWord);
        });

        nextButton.setOnClickListener( view -> {
            viewModel.nextWord();
        });

        previousButton.setOnClickListener(view -> {
            viewModel.previousWord();
        });
    }
}