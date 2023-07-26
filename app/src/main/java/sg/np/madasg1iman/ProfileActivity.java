package sg.np.madasg1iman;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madasg1iman.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView profile;
    private Button save,cancel;
    private FirebaseAuth mAuth;

    private DatabaseReference database;

    private Uri imagepath;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        save = findViewById(R.id.savebutton);
        cancel = findViewById(R.id.cancelbutton);
        profile = findViewById(R.id.circleImageView);
        setContentView(R.layout.activity_profile);
        mAuth.getInstance();


        cancel.setOnClickListener((view)->{
            Toast.makeText(ProfileActivity.this, "Activity Cancelled!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, HomePage.class));
        });

        save.setOnClickListener((view)->{

            uploadimage();
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photointent = new Intent(Intent.ACTION_PICK);
                photointent.setType("Image/*");
                startActivityForResult(photointent,1);
            }
        });
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode, data);

        if(requestCode==1 && resultCode == RESULT_OK && data!=null){
            data.getData();
            getimage();
        }
    }

    private void uploadimage() {
        final ProgressDialog process = new ProgressDialog(this);
        process.setTitle("Saving...");
        process.show();


        FirebaseStorage.getInstance().getReference("images/"+ UUID.randomUUID().toString()).putFile(imagepath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ProfileActivity.this, "New Profile Picture Saved!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ProfileActivity.this, "Action Failed", Toast.LENGTH_SHORT).show();
                }
                process.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = 100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount();
                process.setMessage("Uploaded"+(int) progress+"%");
            }
        });
    }

    private void getimage() {
        Bitmap bitmap = null;
        try{
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
        } catch(IOException e){
            e.printStackTrace();
        }
        profile.setImageBitmap(bitmap);




    }
}