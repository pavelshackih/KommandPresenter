package org.simplepresenter.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static org.simplepresenter.sample.R.id;
import static org.simplepresenter.sample.R.layout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    add(id.root, new SampleFragment()).
                    commit();
        }
    }
}
