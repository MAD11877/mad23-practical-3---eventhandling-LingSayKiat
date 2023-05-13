package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user  = new User("MAD", "I am a software engineer", 1, false);
        Button followbutton = findViewById(R.id.follow_button);
        Button messageButton = findViewById(R.id.message_button);

        // Load name and description from the user object
        String name = user.getName();
        String description = user.getDescription();

        TextView nameTextView = findViewById(R.id.HelloWorld);

        Intent intent = getIntent();
        int randomInt = intent.getIntExtra("RANDOM_INT", -1);
        if (randomInt != -1) {
            name = name + " " + randomInt;
        }

        nameTextView.setText(name);

        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.isFollowed()) {
                    followbutton.setText("Follow");
                    user.setFollowed(false);
                }
                else {
                    followbutton.setText("Unfollow");
                    user.setFollowed(true);
                }

            }

        });

        // Set an OnClickListener for the Message button
        messageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create an Intent to launch the MessageGroup activity
                    Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                    startActivity(intent);
                }
            });

}
}