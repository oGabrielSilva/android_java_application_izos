package com.silva.odevgabriel.izanamios.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Boolean> mIsReady = new MutableLiveData<>(false);
    public LiveData<Boolean> isReady = mIsReady;

    public void forceAppReady() {
        this.mIsReady.setValue(true);
    }
}
