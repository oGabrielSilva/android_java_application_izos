package com.silva.odevgabriel.izanamios.Listeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.silva.odevgabriel.izanamios.App.Constants;
import com.silva.odevgabriel.izanamios.Utils.TextListenersValidationOrder;
import com.silva.odevgabriel.izanamios.Utils.TextSuccess;
import com.silva.odevgabriel.izanamios.Utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class TextListener implements TextWatcher {

    private Integer minValue;
    private Integer maxValue;
    private TextSuccess textSuccess;
    private TextListenersValidationOrder order;

    public TextListener(TextListenersValidationOrder order, TextSuccess textSuccess) {
        this.textSuccess = textSuccess;
        this.order = order;
    }

    public TextListener(int minValue, TextListenersValidationOrder order, TextSuccess textSuccess) {
        this.textSuccess = textSuccess;
        this.order = order;
        this.minValue = minValue;
    }

    public TextListener(int minValue, int maxValue, TextListenersValidationOrder order, TextSuccess textSuccess) {
        this.textSuccess = textSuccess;
        this.order = order;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        switch (order) {
            case FIELD:
                this.validationField(s.toString());
                break;
            case EMAIL:
                this.validationEmail(s.toString());
                break;
        }
    }

    private void validationField(String s) {
        boolean result = maxValue != null
                ? Validation.isFieldValid(s.toString(), minValue, maxValue)
                : Validation.isFieldValid(s.toString(), minValue);

        textSuccess.run(result);
    }

    private void validationEmail(String email) {
        List<Integer> errors = new ArrayList<>();

        if (email.length() < 5) errors.add(1);
        if (email.split(" ").length > 1) errors.add(1);

        String[] emailSplit = email.split("@");
        if (emailSplit.length > 1) {
            if (!emailSplit[1].contains(".")) errors.add(1);

            String[] emailSplitDot = emailSplit[1].split("\\.");
            if (emailSplitDot.length <= 1) errors.add(1);
        } else errors.add(1);

        Log.d(Constants.TAG, String.valueOf(errors.size() >= 1));
        textSuccess.run(errors.size() < 1);
    }
}
