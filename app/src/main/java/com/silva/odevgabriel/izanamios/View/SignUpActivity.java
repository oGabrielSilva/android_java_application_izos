package com.silva.odevgabriel.izanamios.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.App.Constants;
import com.silva.odevgabriel.izanamios.Controller.UserController;
import com.silva.odevgabriel.izanamios.Listeners.TextListener;
import com.silva.odevgabriel.izanamios.Model.User;
import com.silva.odevgabriel.izanamios.R;
import com.silva.odevgabriel.izanamios.Utils.TextListenersValidationOrder;
import com.silva.odevgabriel.izanamios.ViewModel.SignUpAndSignInViewModel;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder mViewHolder = new ViewHolder();
    private SignUpAndSignInViewModel model;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.user = UserController.get();
        this.model = new ViewModelProvider(this).get(SignUpAndSignInViewModel.class);

        this.bindingViewHolder();
        this.setObservers();
        this.setListeners();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_sign_in_button) finish();
        else if(v.getId() == R.id.button_sign_up) this.clickOnSignUpButton();
    }

    private void setObservers() {
        model.nameIsReady.observe(this, observer -> {
            if (!observer) {
                this.mViewHolder.name.setBackgroundResource(R.drawable.input_sign_custom_error);
                this.user.setName("");
                return;
            }
            this.user.setName(this.mViewHolder.name.getText().toString());
            this.mViewHolder.name.setBackgroundResource(R.drawable.input_sign_custom);
        });

        model.lastNameIsReady.observe(this, observer -> {
            if (!observer) {
                this.mViewHolder.lastName.setBackgroundResource(R.drawable.input_sign_custom_error);
                this.user.setLastName("");
                return;
            }
            this.user.setLastName(this.mViewHolder.lastName.getText().toString());
            this.mViewHolder.lastName.setBackgroundResource(R.drawable.input_sign_custom);
        });

        model.emailIsReady.observe(this, observer -> {
            if (!observer) {
                this.mViewHolder.email.setBackgroundResource(R.drawable.input_sign_custom_error);
                this.user.setEmail("");
                return;
            }
            this.user.setEmail(this.mViewHolder.email.getText().toString());
            this.mViewHolder.email.setBackgroundResource(R.drawable.input_sign_custom);
        });

        model.passwordIsReady.observe(this, observer -> {
            if (!observer) {
                this.mViewHolder.password.setBackgroundResource(R.drawable.input_sign_custom_error);
                this.user.setPassword("");
                return;
            }
            this.user.setPassword(this.mViewHolder.password.getText().toString());
            this.mViewHolder.password.setBackgroundResource(R.drawable.input_sign_custom);
        });
    }

    private void bindingViewHolder() {
        this.mViewHolder.name = findViewById(R.id.edit_name);
        this.mViewHolder.lastName = findViewById(R.id.edit_last_name);
        this.mViewHolder.email = findViewById(R.id.edit_email);
        this.mViewHolder.password = findViewById(R.id.edit_password);
        this.mViewHolder.signUp = findViewById(R.id.button_sign_up);
        this.mViewHolder.alreadyHaveAccount = findViewById(R.id.text_sign_in_button);
    }

    private void setListeners() {
        TextListenersValidationOrder field = TextListenersValidationOrder.FIELD;
        TextListenersValidationOrder email = TextListenersValidationOrder.EMAIL;

        this.mViewHolder.alreadyHaveAccount.setOnClickListener(this);
        this.mViewHolder.signUp.setOnClickListener(this);

        this.mViewHolder.name.addTextChangedListener(
                new TextListener(2, field, validation -> model.nameIsValid(validation))
        );
        this.mViewHolder.lastName.addTextChangedListener(
                new TextListener(5, field, validation -> model.lastNameIsValid(validation))
        );
        this.mViewHolder.email.addTextChangedListener(
                new TextListener(1, email, validation -> model.emailIsValid(validation))
        );
        this.mViewHolder.password.addTextChangedListener(
                new TextListener(8, field, validation -> model.passwordIsValid(validation))
        );
    }

    private void clickOnSignUpButton() {
        if(user.getName().length() < 1) {
            this.mViewHolder.name.requestFocus();
            return;
        }
        if(user.getLastName().length() < 1) {
            this.mViewHolder.lastName.requestFocus();
            return;
        }
        if(user.getEmail().length() < 1) {
            this.mViewHolder.email.requestFocus();
            return;
        }
        if(user.getPassword().length() < 1) {
            this.mViewHolder.password.requestFocus();
            return;
        }

        Intent intent = new Intent(this, CompleteSignUpActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.USER, user);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private static class ViewHolder {
        EditText name;
        EditText lastName;
        EditText email;
        EditText password;
        Button signUp;
        TextView alreadyHaveAccount;
    }
}