package com.example.yogesh.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddContact extends AppCompatActivity {
  EditText Name;
    EditText Phone;
    EditText Email;
    Button insert;

    private DatabaseHelper databaseHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper=new DatabaseHelper(AddContact.this);
        setContentView(R.layout.activity_add_contact);
        Phone=(EditText)findViewById(R.id.contactmobile);
        Email=(EditText)findViewById(R.id.contactemail);
        Name=(EditText)findViewById(R.id.contactname);
        insert=(Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=Name.getText().toString();
                Integer phone=Integer.parseInt(Phone.getText().toString());
                String email=Email.getText().toString();
               boolean result= databaseHelper.InsertData(name,phone,email);
                 if(result){
                     Toast.makeText(AddContact.this,"Data Inserted",Toast.LENGTH_LONG).show();
                 }
                 else {
                     Toast.makeText(AddContact.this,"Data Inserted",Toast.LENGTH_LONG).show();
                 }
            }
        });


    }
}
