package com.example.whoisspy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whoisspy.R;
import com.example.whoisspy.databinding.ActivityGameBinding;
import com.example.whoisspy.adapters.PlayerAdapter;
import com.example.whoisspy.adapters.SpeechAdapter;
import com.example.whoisspy.managers.GameManager;
import com.example.whoisspy.models.GameSettings;
import com.example.whoisspy.models.Player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/whoisspy/activities/GameConstants;", "", "()V", "EXTRA_GAME_SETTINGS", "", "app_debug"})
public final class GameConstants {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_GAME_SETTINGS = "extra_game_settings";
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.activities.GameConstants INSTANCE = null;
    
    private GameConstants() {
        super();
    }
}