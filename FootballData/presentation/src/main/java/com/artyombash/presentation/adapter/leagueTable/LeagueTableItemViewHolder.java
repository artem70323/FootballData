package com.artyombash.presentation.adapter.leagueTable;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.leagueTable.Standing;
import com.artyombash.presentation.base.BaseItemViewHolder;
import com.artyombash.presentation.databinding.ItemLeaguetableBinding;
import com.artyombash.presentation.viewModel.leagueTable.LeagueTableItemViewModel;

public class LeagueTableItemViewHolder extends BaseItemViewHolder<Standing,
        LeagueTableItemViewModel, ItemLeaguetableBinding>{

    private LeagueTableItemViewHolder(ItemLeaguetableBinding binding,
                                     LeagueTableItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setLeagueTable(viewModel);
    }

    public static LeagueTableItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                   LeagueTableItemViewModel viewModel) {
        ItemLeaguetableBinding binding = ItemLeaguetableBinding.inflate(inflater, parent, false);
        return new LeagueTableItemViewHolder(binding, viewModel);
    }

}
