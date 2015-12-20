package com.beter.timehole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View.OnClickListener;
import android.view.View;
import com.beter.timehole.fragments.SetTagDialogFragment;


public class AddTagsActivity extends AppCompatActivity {

    private Button dfragbutton;
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);

        dfragbutton = (Button) findViewById(R.id.dfragbutton);

        dfragbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                SetTagDialogFragment dFragment = new SetTagDialogFragment();
               // Show DialogFragment
               // SetTagDialogFragment.show(fm,"Dialog Fragment");
            }
        });


    }
}
