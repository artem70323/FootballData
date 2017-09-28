package com.artyombash.presentation.viewModel.teams;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;

import com.artyombash.domain.entity.teams.Team;
import com.artyombash.presentation.base.BaseItemViewModel;
import com.facebook.drawee.view.SimpleDraweeView;

public class TeamsItemViewModel extends BaseItemViewModel<Team> {

    public final ObservableField<String> name = new ObservableField<>("");
    public final ObservableField<String> code = new ObservableField<>("");
    public final ObservableField<String> shortName = new ObservableField<>("");
    public final ObservableField<String> squadMarketValue = new ObservableField<>("");
    public String crestUrl;


    @Override
    public void setItem(Team item) {
        name.set(item.getName());
        code.set(item.getCode());
        shortName.set(item.getShortName());
        squadMarketValue.set(item.getSquadMarketValue());
        crestUrl = item.getCrestUrl();
    }

    @BindingAdapter({"app:crestUrl"})
    public static void loadImage(SimpleDraweeView view, String crestUrl) {
        view.setImageURI(crestUrl);
    }

}
