package com.silva.odevgabriel.izanamios.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.R;

public class CompleteSignUpActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_sign_up);

        this.bindingViewHolder();
    }

    private void bindingViewHolder() {
        this.mViewHolder.imageProfile = findViewById(R.id.image_profile);
        this.mViewHolder.nickname = findViewById(R.id.edit_nickname);
        this.mViewHolder.status = findViewById(R.id.edit_status);
        this.mViewHolder.born = findViewById(R.id.edit_born);

        this.mViewHolder.female = findViewById(R.id.text_female_button);
        this.mViewHolder.male = findViewById(R.id.text_male_button);
        this.mViewHolder.other = findViewById(R.id.text_other_button);
    }

    private static class ViewHolder {
        ImageView imageProfile;
        EditText nickname;
        EditText status;
        EditText born;

        TextView female;
        TextView male;
        TextView other;
    }
}