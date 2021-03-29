package com.studio.mattiaferigutti.randomwords;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //site from where to get random words https://randomwordgenerator.com/
    private Button nextButton, previousButton;
    private TextView wordText;
    private List<String> words;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        wordText = findViewById(R.id.wordText);

        fillList();
        wordText.setText(words.get(index));

        nextButton.setOnClickListener( view -> {
            wordText.setText(getNextItem());
        });

        previousButton.setOnClickListener(view -> {
            wordText.setText(getPreviousItem());
        });
    }

    private String getNextItem() {
        index++;
        return words.get(index % words.size());
    }

    private String getPreviousItem() {
        if (index > 0) index--;
        return words.get(index % words.size());
    }

    private void fillList() {
        //20 words
        //You can also use Arrays.asList() to achieve the same result
        words = createList(
                "stand",
                "tank",
                "food",
                "mirror",
                "message",
                "investment",
                "dead",
                "scandal",
                "rock",
                "resort",
                "clown",
                "employ",
                "house",
                "bed"
        );
    }

    // How does SafeVarargs work?
    // https://stackoverflow.com/questions/14231037/java-safevarargs-annotation-does-a-standard-or-best-practice-exist
    @SafeVarargs
    private final <T> List<T> createList(T... listT) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, listT);
//        for (T item : listT) {
//            list.add(item);
//        }
        return list;
    }
}