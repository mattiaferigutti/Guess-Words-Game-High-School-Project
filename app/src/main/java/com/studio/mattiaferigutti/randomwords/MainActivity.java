package com.studio.mattiaferigutti.randomwords;

import androidx.appcompat.app.AppCompatActivity;
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

        viewModel.fillList();
        wordText.setText(viewModel.words.get(viewModel.index));

        nextButton.setOnClickListener( view -> {
            wordText.setText(getNextItem());
        });

        previousButton.setOnClickListener(view -> {
            wordText.setText(getPreviousItem());
        });
    }

    private String getNextItem() {
        viewModel.index++;
        return getWords().get(getIndex() % getWords().size());
    }

    private String getPreviousItem() {
        if (getIndex() > 0) viewModel.index--;
        return getWords().get(getIndex() % getWords().size());
    }

    private int getIndex() {
        return viewModel.index;
    }

    private List<String> getWords() {
        return viewModel.words;
    }
}