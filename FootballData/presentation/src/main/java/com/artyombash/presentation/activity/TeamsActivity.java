package com.artyombash.presentation.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.artyombash.presentation.FootballApplication;
import com.artyombash.presentation.R;
import com.artyombash.presentation.base.BaseActivity;
import com.artyombash.presentation.databinding.ActivityTeamsBinding;
import com.artyombash.presentation.viewModel.teams.TeamsViewModel;
import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;

public class TeamsActivity extends BaseActivity {

    @Inject
    TeamsViewModel teamsViewModel;
    public static int competitionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((FootballApplication) getApplication()).getAppComponent().inject(this);
        Fresco.initialize(this);

        super.viewModel = teamsViewModel;
        ActivityTeamsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_teams);

        binding.setViewModel(teamsViewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(teamsViewModel.adapter);
        binding.recyclerView.setHasFixedSize(true);

        competitionId = getIntent().getIntExtra("ID", 0);

        super.onCreate(savedInstanceState);
    }

}
