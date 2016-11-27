package com.thecoders.drplus.drplus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import tn.itskills.android.devfest16.models.Post;
//import tn.itskills.android.devfest16.models.Student;

public class HomeActivityBis extends BaseActivityBis implements  View.OnClickListener{

    private String TAG = "HomeActivityBis";

    private Button mSignOutButton, mReadPostMessage;
    private TextView mPostMessage;

    //private DatabaseReference mDatabase;

    //private Post mPost;
    //private ArrayList<Post> mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(HomeActivityBis.this, NewPostActivity.class));

            }
        });

        initView();

        //mDatabase = FirebaseDatabase.getInstance().getReference();

        //mDatabase.addValueEventListener(this);
    }


    private void initView() {
        mSignOutButton = (Button) findViewById(R.id.button_sign_out);
        mSignOutButton.setOnClickListener(this);

        mReadPostMessage = (Button) findViewById(R.id.button_read_messages);
        mReadPostMessage.setOnClickListener(this);

        mPostMessage = (TextView) findViewById(R.id.post_message);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_out:
                //signOut();
                break;
            case R.id.button_read_messages:
                //readPostMessage();
                break;
        }
    }


}
