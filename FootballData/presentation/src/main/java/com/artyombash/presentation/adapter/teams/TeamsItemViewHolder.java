package com.artyombash.presentation.adapter.teams;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.teams.Team;
import com.artyombash.presentation.base.BaseItemViewHolder;
import com.artyombash.presentation.databinding.ItemTeamBinding;
import com.artyombash.presentation.viewModel.teams.TeamsItemViewModel;

public class TeamsItemViewHolder extends BaseItemViewHolder<Team,
        TeamsItemViewModel, ItemTeamBinding>{

    public TeamsItemViewHolder(ItemTeamBinding binding,
                               TeamsItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setTeam(viewModel);
    }

    public static TeamsItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                             TeamsItemViewModel viewModel) {
        ItemTeamBinding binding = ItemTeamBinding.inflate(inflater, parent, false);
        return new TeamsItemViewHolder(binding, viewModel);
    }

}
