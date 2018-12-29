package com.example.android.fragmenttrying;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements listfrag.Chesspiecelistener{
    TextView tvdetails;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdetails = (TextView) findViewById(R.id.tvdetails);
        if(findViewById(R.id.layout_default)!=null)
        {
            FragmentManager fragmentManager=this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                            .show(fragmentManager.findFragmentById(R.id.fragment))
                            .hide(fragmentManager.findFragmentById(R.id.fragment2))
                            .commit();
        }
        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager fragmentManager=this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.fragment))
                    .show(fragmentManager.findFragmentById(R.id.fragment2))
                    .commit();
        }
    }

    @Override
    public void onChessPieceSelected(int index) {
        String details []=getResources().getStringArray(R.array.description);
        if(findViewById(R.id.layout_default)!=null)
        {
            FragmentManager fragmentManager=this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.fragment))
                    .show(fragmentManager.findFragmentById(R.id.fragment2))
                    .addToBackStack(null)
                    .commit();
        }
        tvdetails.setText(details[index]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt("index", id);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
