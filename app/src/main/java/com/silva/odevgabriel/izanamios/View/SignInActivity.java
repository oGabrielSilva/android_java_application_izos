package com.silva.odevgabriel.izanamios.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        this.bindingViewHolder();
        this.setListeners();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.mViewHolder.signUpTextButton.getId()) {
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }

    private void setListeners() {
        this.mViewHolder.signUpTextButton.setOnClickListener(this);
    }

    private void bindingViewHolder() {
        this.mViewHolder.email = findViewById(R.id.edit_email);
        this.mViewHolder.password = findViewById(R.id.edit_password);
        this.mViewHolder.remember = findViewById(R.id.check_continue);
        this.mViewHolder.signIn = findViewById(R.id.button_sign_in);
        this.mViewHolder.signUpTextButton = findViewById(R.id.text_sign_in_button);
    }

    private static class ViewHolder {
        EditText email;
        EditText password;
        CheckBox remember;
        Button signIn;
        TextView signUpTextButton;
    }
}