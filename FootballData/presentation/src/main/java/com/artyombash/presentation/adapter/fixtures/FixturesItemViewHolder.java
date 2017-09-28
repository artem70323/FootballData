package com.artyombash.presentation.adapter.fixtures;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.fixtures.Fixture;
import com.artyombash.presentation.base.BaseItemViewHolder;
import com.artyombash.presentation.databinding.ItemFixtureBinding;
import com.artyombash.presentation.viewModel.fixtures.FixturesItemViewModel;

public class FixturesItemViewHolder extends BaseItemViewHolder<Fixture,
        FixturesItemViewModel, ItemFixtureBinding>{

    private FixturesItemViewHolder(ItemFixtureBinding binding,
                                   FixturesItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setFixtures(viewModel);
    }

    public static FixturesItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                FixturesItemViewModel viewModel) {
        ItemFixtureBinding binding = ItemFixtureBinding.inflate(inflater, parent, false);
        return new FixturesItemViewHolder(binding, viewModel);
    }

}
