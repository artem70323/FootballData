package com.artyombash.presentation.adapter.fixtures;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.fixtures.Fixture;
import com.artyombash.presentation.base.BaseAdapter;
import com.artyombash.presentation.viewModel.fixtures.FixturesItemViewModel;

/**
 * Adaptar that manages a collection of {@link Fixture}.
 */
public class FixturesAdapter extends BaseAdapter<Fixture, FixturesItemViewModel> {

    @Override
    public FixturesItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FixturesItemViewModel itemViewModel = new FixturesItemViewModel();
        return FixturesItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
