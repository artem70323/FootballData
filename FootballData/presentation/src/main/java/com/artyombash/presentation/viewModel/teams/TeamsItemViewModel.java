package com.artyombash.presentation.viewModel.teams;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;

import com.artyombash.domain.entity.teams.Team;
import com.artyombash.presentation.base.BaseItemViewModel;
import com.facebook.drawee.view.SimpleDraweeView;

public class TeamsItemViewModel extends BaseItemViewModel<Team> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> code = new ObservableField<>("");
    public ObservableField<String> shortName = new ObservableField<>("");
    public ObservableField<String> squadMarketValue = new ObservableField<>("");
    public String imageUrl;


    @Override
    public void setItem(Team item) {
        name.set(item.getName());
        code.set(item.getCode());
        shortName.set(item.getShortName());
        squadMarketValue.set(item.getSquadMarketValue());
        imageUrl = item.getCrestUrl();
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(SimpleDraweeView view, String imageUrl) {
        view.setImageURI(imageUrl);
    }

}
