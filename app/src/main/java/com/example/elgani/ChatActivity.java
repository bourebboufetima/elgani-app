package com.example.elgani;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterChat adapter;
    private List<Message> messageList;
    private String currentUserId = "user1"; // Example current user ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerView);
        EditText messageInput = findViewById(R.id.messageInput);
        Button sendButton = findViewById(R.id.sendButton);

        messageList = new ArrayList<>();
        adapter = new AdapterChat(messageList, currentUserId);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        sendButton.setOnClickListener(v -> {
            String messageText = messageInput.getText().toString().trim();
            if (!messageText.isEmpty()) {
                String timestamp = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
                messageList.add(new Message(currentUserId, messageText, timestamp));
                adapter.notifyDataSetChanged();
                messageInput.setText("");
                recyclerView.scrollToPosition(messageList.size() - 1);
            }
        });
    }
}
