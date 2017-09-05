package com.example.yogesh.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Searchcontact extends AppCompatActivity {
    EditText mobile;
    Button search;
    TextView showname;
    TextView showemail;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchcontact);
        db=new DatabaseHelper(Searchcontact.this);
        mobile=(EditText)findViewById(R.id.mobilenum);

        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                Cursor cursor= db.getdata(mobile.getText().toString());

                while(cursor.moveToNext()){
                    showemail.setText(""+cursor.getString(3));
                    showname.setText(""+cursor.getString(1));

                }
            }
        });

        search=(Button)findViewById(R.id.searchcon);
        showname=(TextView) findViewById(R.id.showName);
        showemail=(TextView)findViewById(R.id.showemail);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showemail.setText(" ");
                showname.setText("  ");
               Cursor cursor= db.getdata(mobile.getText().toString());
                while(cursor.moveToNext()){
                    showemail.setText(cursor.getString(3));
                    showname.setText(cursor.getString(1));

                }

            }
        });
    }
}
