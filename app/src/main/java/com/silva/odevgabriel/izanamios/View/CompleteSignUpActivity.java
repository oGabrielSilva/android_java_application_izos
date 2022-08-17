package com.silva.odevgabriel.izanamios.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.R;

import java.util.ArrayList;
import java.util.List;

public class CompleteSignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder mViewHolder = new ViewHolder();

    private final List<Integer> listOfId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_sign_up);

        this.bindingViewHolder();
        this.setListeners();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (listOfId.contains(id)) this.changeGender(id);
    }

    private void setListeners() {
        this.mViewHolder.female.setOnClickListener(this);
        this.mViewHolder.male.setOnClickListener(this);
        this.mViewHolder.other.setOnClickListener(this);
    }

    private void bindingViewHolder() {
        this.mViewHolder.imageProfile = findViewById(R.id.image_profile);
        this.mViewHolder.nickname = findViewById(R.id.edit_nickname);
        this.mViewHolder.status = findViewById(R.id.edit_status);
        this.mViewHolder.born = findViewById(R.id.edit_born);

        this.mViewHolder.female = findViewById(R.id.text_female_button);
        this.listOfId.add(this.mViewHolder.female.getId());
        this.mViewHolder.male = findViewById(R.id.text_male_button);
        this.listOfId.add(this.mViewHolder.male.getId());
        this.mViewHolder.other = findViewById(R.id.text_other_button);
        this.listOfId.add(this.mViewHolder.other.getId());
    }

    private void changeGender(int id) {
        TextView female = this.mViewHolder.female;
        TextView male = this.mViewHolder.male;
        TextView other = this.mViewHolder.other;

        this.setGender(female, id == female.getId());
        this.setGender(male, id == male.getId());
        this.setGender(other, id == other.getId());
    }

    private void setGender(TextView view, boolean isSelected) {
        if (isSelected) {
            view.setTag("true");
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            view.setTypeface(ResourcesCompat.getFont(this, R.font.ubuntu_bold));
            return;
        }
        view.setTag("false");
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        view.setTypeface(ResourcesCompat.getFont(this, R.font.ubuntu));
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