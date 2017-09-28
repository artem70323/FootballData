package com.artyombash.presentation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.artyombash.presentation.FootballApplication;
import com.artyombash.presentation.R;
import com.artyombash.presentation.base.BaseActivity;
import com.artyombash.presentation.databinding.ActivityFixturesBinding;
import com.artyombash.presentation.viewModel.fixtures.FixturesViewModel;

import javax.inject.Inject;

public class FixturesActivity extends BaseActivity {

    @Inject
    FixturesViewModel viewModel;
    public static int competitionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((FootballApplication) getApplication()).getAppComponent().inject(this);

        super.viewModel = viewModel;
        ActivityFixturesBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_fixtures);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);
        binding.recyclerView.setHasFixedSize(true);

        competitionId = getIntent().getIntExtra("ID", 0);

        super.onCreate(savedInstanceState);
    }

}
