package com.example.googlemapsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MapDashboardActivity extends AppCompatActivity {

    private FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser == null){
            startActivity(new Intent(MapDashboardActivity.this, RegisterActivity.class));
            finish();
        }

    }

    private TextView rank, steps, winningStreak;
    private LinearLayout lastMarathon, leaderboardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_dashboard);

        rank = findViewById(R.id.rank);
        steps = findViewById(R.id.stepsWalkedMarathon);
        winningStreak = findViewById(R.id.winningStreak);
        lastMarathon = findViewById(R.id.lastMarathonLayout);
        leaderboardLayout = findViewById(R.id.leaderboardLayout);

        // Make visibility of lastMarathon and leaderboardLayout GONE if no data

        Button leaderboard = findViewById(R.id.leaderboardBtn);
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapDashboardActivity.this, LeaderboardActivity.class);
                startActivity(intent);
            }
        });

        Button startMarathon = findViewById(R.id.startMarathon);
        startMarathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapDashboardActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
