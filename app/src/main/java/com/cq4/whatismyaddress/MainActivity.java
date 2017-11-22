package com.cq4.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button saveButton;
    private Button button2;
    private EditText email_edit;
    private String emailCapture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.savebutton);
        saveButton.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        email_edit = (EditText) findViewById(R.id.email_edittext);


    }

    public void loadprefs(){
    SharedPreferences msharedpreferences = getSharedPreferences("address_shared_preferences", MODE_PRIVATE);
  emailCapture = msharedpreferences.getString("email",email_edit.getText().toString());

}



    public void setMsharedpreferences(String email) {
        SharedPreferences msharedpreferences = getSharedPreferences("address_shared_preferences", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = msharedpreferences.edit();
        mEditor.putString(email,email_edit.getText().toString());
        mEditor.apply();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.savebutton:
                loadprefs();
                email_edit.setText("");
                Toast.makeText(this, emailCapture, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Intent i = new Intent(this, RecyclerActivity.class);
                i.putExtra("sharedPref",emailCapture);
                startActivity(i);


        }

    }
}

