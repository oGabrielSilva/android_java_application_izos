package com.silva.odevgabriel.izanamios.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUpAndSignInViewModel extends ViewModel {
    private MutableLiveData<Boolean> mNameIsReady = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> mLastNameIsReady = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> mEmailIsReady = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> mPasswordIsReady = new MutableLiveData<>(false);

    public LiveData<Boolean> nameIsReady = mNameIsReady;
    public LiveData<Boolean> lastNameIsReady = mLastNameIsReady;
    public LiveData<Boolean> emailIsReady = mEmailIsReady;
    public LiveData<Boolean> passwordIsReady = mPasswordIsReady;

    public void nameIsValid(boolean valid) {
        this.mNameIsReady.setValue(valid);
    }

    public void lastNameIsValid(boolean valid) {
        this.mLastNameIsReady.setValue(valid);
    }

    public void emailIsValid(boolean valid) {
        this.mEmailIsReady.setValue(valid);
    }

    public void passwordIsValid(boolean valid) {
        this.mPasswordIsReady.setValue(valid);
    }
}
