package fr.epsi.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "ACTIVITYAPP";
    private EditText nomSaisi;
    private EditText telSaisi;
    private EditText birthSaisi;
    String currentPhotoPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nomSaisi = (EditText) findViewById(R.id.nom);
        this.telSaisi = (EditText) findViewById(R.id.tel);
        this.birthSaisi = (EditText) findViewById(R.id.birth);

        Button boutonValider = (Button) findViewById(R.id.button_valid);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomSaisi.getText().toString();
                String tel = telSaisi.getText().toString();
                String birth = birthSaisi.getText().toString();
                String text = getString(R.string.message_Toast, nom, birth, tel);
                Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Button boutonReset = (Button) findViewById(R.id.button_reset);

        boutonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remiseAZero();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on passe dans le onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on passe dans le onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on passe dans le onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on passe dans le onStop()");
    }

    public void remiseAZero() {
        nomSaisi.setText("");
        telSaisi.setText("");
        birthSaisi.setText("");
    }

    public void photo(View view) {
        dispatchTakePictureIntent();
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Log.v(TAG, "Erreur enregistrement de photo");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "fr.epsi.birthdayapp.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            this.galleryAddPic();
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }


}


