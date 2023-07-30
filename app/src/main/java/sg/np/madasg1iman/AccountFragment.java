package sg.np.madasg1iman;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.madasg1iman.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import sg.np.madasg1iman.models.FeedbackModel;

public class AccountFragment extends Fragment {
    MaterialButton btnSend;
    private TextInputEditText txtName, txtEmailAddr, EdRemarks;
    private ImageView btnBack;
    private CardView card_mail, card_call, card_chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);
        initViews(v);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        clickListeners();


        // Inflate the layout for this fragment
        return v;
    }


    private void initViews(View v) {
        btnSend = v.findViewById(R.id.btnSend);
        txtName = v.findViewById(R.id.txtName);
        txtEmailAddr = v.findViewById(R.id.txtEmailAddr);
        EdRemarks = v.findViewById(R.id.txtCommentsEd);
        btnBack = v.findViewById(R.id.btn_back);
        card_call = v.findViewById(R.id.card_call);
        card_mail = v.findViewById(R.id.card_email);
        card_chat = v.findViewById(R.id.card_chat);
    }

    private void clickListeners() {
        btnSend.setOnClickListener(v -> {

            validateTxt();
        });

        btnBack.setOnClickListener(view -> getActivity().onBackPressed());

        card_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMessageIntent("123456", "Hi EduAcademy");
            }
        });

        card_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });

        card_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeEmail();
            }
        });
    }

    private void openMessageIntent(String phoneNumber, String message) {
        // Create a new intent to send an SMS
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);

        // Set the URI with "smsto:" followed by the recipient's phone number
        smsIntent.setData(Uri.parse("smsto:" + phoneNumber));

        // Set the pre-filled message
        smsIntent.putExtra("sms_body", message);

        // Check if the device has an app that can handle the SMS intent
        if (smsIntent.resolveActivity(getContext().getPackageManager()) != null) {
            // Start the messaging app
            startActivity(smsIntent);
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void composeEmail() {
        String[] recipients = {"recipient@example.com"};
        String subject = "Your email subject";
        String body = "Your email body";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Handle if no email client is available
            // For example, show a toast or a dialog informing the user
        }
    }

    private void makePhoneCall() {
        String phoneNumber = "1234567890"; // Replace with the phone number you want to call

        // Create the intent with the ACTION_CALL action and the phone number URI
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        try {
            // Start the call
            startActivity(callIntent);
        } catch (SecurityException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Call permission denied.", Toast.LENGTH_SHORT).show();
        }
    }

    private void validateTxt() {

        if (!txtName.getText().toString().equals("") || txtName.getText().toString() == null) {
            if (!txtEmailAddr.getText().toString().equals("") || txtName.getText().toString() == null) {
                if (!EdRemarks.getText().toString().equals("") || EdRemarks.getText().toString().equals(null)) {
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
                    if ((txtEmailAddr.getText().toString().matches(emailPattern))) {

                        uploadDataToFirebase();

                    } else txtEmailAddr.setError("Invalid Email");
                } else EdRemarks.setError("Can't leave empty");
            } else txtEmailAddr.setError("Can't leave empty");
        } else txtName.setError("Can't leave empty");
    }

    private void uploadDataToFirebase() {

        String name = txtName.getText().toString();
        String email = txtEmailAddr.getText().toString();
        String remarks = EdRemarks.getText().toString();

        FeedbackModel data = new FeedbackModel(name, email, remarks);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("feedback");

        // Generate a new unique key for the data entry
        String dataId = databaseReference.push().getKey();
        EdRemarks.setText("");
        txtEmailAddr.setText("");
        txtName.setText("");

        Toast.makeText(getContext(), "Feedback recorded, Thank You!", Toast.LENGTH_SHORT).show();

        assert dataId != null;
        databaseReference.child(dataId).setValue(data)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        EdRemarks.setText("");
                        txtEmailAddr.setText("");
                        txtName.setText("");
                        Toast.makeText(getContext(), "Feedback recorded, Thank You!", Toast.LENGTH_SHORT).show();

                    } else {
                        // Handle the error if the upload fails
                        Log.d(TAG, "uploadDataToFirebase: ");
                        // You can use task.getException() to get the specific error details
                    }
                });


    }

}