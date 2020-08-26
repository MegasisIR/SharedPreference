package m.t.sharedpreference;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private UserManager userManager;
    private TextInputEditText fullNameEt, emailEt;
    private RadioButton maleRb, femaleRb;
    private RadioGroup genderRg;
    private MaterialButton saveInformationBtn;
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userManager = new UserManager(this);

        fullNameEt = findViewById(R.id.et_main_fullName);
        emailEt = findViewById(R.id.et_main_email);
        maleRb = findViewById(R.id.rb_main_male);
        femaleRb = findViewById(R.id.rb_main_female);
        genderRg = findViewById(R.id.rg_main_gender);
        saveInformationBtn = findViewById(R.id.btn_main_saveInformation);

        fullNameEt.setText(userManager.getFullName());
        emailEt.setText(userManager.getEmail());
        if (userManager.getGender().equalsIgnoreCase("male")) {
            maleRb.setChecked(true);
        } else {
            femaleRb.setChecked(true);
        }

        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_main_female) {
                    gender = "female";
                } else {
                    gender = "male";
                }
            }
        });


        saveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userManager.saveInformation(fullNameEt.getText().toString(),
                        emailEt.getText().toString(),
                        !gender.isEmpty() ? gender : userManager.getGender())) {
                    Toast.makeText(MainActivity.this, "اطلاعات ذخیره شد", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}
