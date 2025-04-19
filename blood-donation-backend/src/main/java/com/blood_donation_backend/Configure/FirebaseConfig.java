package com.blood_donation_backend.Configure;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseAuth firebaseAuth() throws Exception {
        // ✅ This loads the file from src/main/resources
        InputStream serviceAccount = getClass().getClassLoader()
                .getResourceAsStream("blood-donation-project-1e7ae-firebase-adminsdk-fbsvc-d917185920.json");

        if (serviceAccount == null) {
            throw new IllegalStateException("Firebase service account file not found in resources");
        }

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseAuth.getInstance();
    }
}
