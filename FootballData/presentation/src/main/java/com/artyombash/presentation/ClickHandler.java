package com.artyombash.presentation;


import android.content.Context;
import android.content.Intent;

import com.artyombash.presentation.activity.TeamsActivity;

public class ClickHandler {

    private Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void getTeams(int id) {
        Intent intent = new Intent(context, TeamsActivity.class);
        intent.putExtra("ID", id);
        context.startActivity(intent);
    }

}
