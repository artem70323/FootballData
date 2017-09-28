package com.artyombash.presentation;


import android.content.Context;
import android.content.Intent;

import com.artyombash.presentation.activity.FixturesActivity;
import com.artyombash.presentation.activity.LeagueTableActivity;
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

    public void getLeagueTable(int id) {
        Intent intent = new Intent(context, LeagueTableActivity.class);
        intent.putExtra("ID", id);
        context.startActivity(intent);
    }

    public void getFixtures(int id) {
        Intent intent = new Intent(context, FixturesActivity.class);
        intent.putExtra("ID", id);
        context.startActivity(intent);
    }

}
