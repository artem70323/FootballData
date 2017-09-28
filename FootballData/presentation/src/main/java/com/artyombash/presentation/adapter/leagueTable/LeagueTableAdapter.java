package com.artyombash.presentation.adapter.leagueTable;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.leagueTable.Standing;
import com.artyombash.presentation.base.BaseAdapter;
import com.artyombash.presentation.viewModel.leagueTable.LeagueTableItemViewModel;

/**
 * Adaptar that manages a collection of {@link Standing}.
 */
public class LeagueTableAdapter extends BaseAdapter<Standing, LeagueTableItemViewModel> {

    @Override
    public LeagueTableItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LeagueTableItemViewModel itemViewModel = new LeagueTableItemViewModel();
        return LeagueTableItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
