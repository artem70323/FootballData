package com.artyombash.presentation.adapter.teams;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.teams.Team;
import com.artyombash.presentation.base.BaseAdapter;
import com.artyombash.presentation.viewModel.teams.TeamsItemViewModel;

/**
 * Adaptar that manages a collection of {@link Team}.
 */
public class TeamsAdapter extends BaseAdapter<Team, TeamsItemViewModel> {

    @Override
    public TeamsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TeamsItemViewModel itemViewModel = new TeamsItemViewModel();
        return TeamsItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
