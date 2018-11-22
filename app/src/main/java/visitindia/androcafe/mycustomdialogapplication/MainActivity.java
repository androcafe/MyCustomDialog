package visitindia.androcafe.mycustomdialogapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShoeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Button
        btnShoeDialog=findViewById(R.id.btn_shoe_dialog);

        //set OnClickListener
        btnShoeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();

            }
        });
    }

    private void showCustomDialog() {

        //Create an Initialize view for dialog box
        LayoutInflater layoutInflater=getLayoutInflater();
        View viewCustomDialog=layoutInflater.inflate(R.layout.custom_dialog_layout,null);

        //Define and instantiati dialog
        final Dialog dialog=new Dialog(MainActivity.this,R.style.ThemeOverlay_AppCompat);

        //set view to dialog box
        dialog.setContentView(viewCustomDialog);

        //set dialog cancelable true or false
        dialog.setCancelable(true);

        //get widgets and UI components on dialog
        final EditText edtUsername=viewCustomDialog.findViewById(R.id.edt_user);
        final EditText edtPassword=viewCustomDialog.findViewById(R.id.edtp_password);
        Button buttonLogin=viewCustomDialog.findViewById(R.id.btn_login);


        //set Onclickelistner to button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();

                Toast.makeText(MainActivity.this, "Username : "+username+"\nPassword : "+password, Toast.LENGTH_LONG).show();

                //dismiss dialog after login
                dialog.dismiss();
            }
        });

        //show dialog
        dialog.show();

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

    }
}
