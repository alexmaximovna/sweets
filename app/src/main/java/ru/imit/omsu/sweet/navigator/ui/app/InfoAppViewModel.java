package ru.imit.omsu.sweet.navigator.ui.app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoAppViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InfoAppViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This app is created for fans of sweet.\n" +
                "You can show,make publications,share with friends your emotions about something sweet,\n" +
                "stay comments,like pictures  and etc ..");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
