package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.BloodRequestEntity;
import com.blood_donation_backend.Service.BloodRequestService;
import com.blood_donation_backend.Service.EmailService;
import com.blood_donation_backend.DTO.BloodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospital/email")
public class EmailController {

    @Autowired
    private BloodRequestService bloodRequestService;

    @Autowired
    private EmailService emailService;

    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateBloodRequestStatusAndNotify(@PathVariable Long id,
                                                                    @RequestParam String status) {

        // Only allow Approved or Declined
        if (!status.equalsIgnoreCase("Approved") && !status.equalsIgnoreCase("Declined")) {
            return ResponseEntity.badRequest().body("Invalid status. Use 'Approved' or 'Declined'");
        }

        // Fetch the blood request from the DB
        BloodRequestEntity bloodRequest = bloodRequestService.getBloodRequestById(id);
        if (bloodRequest == null) {
            return ResponseEntity.notFound().build();
        }

        // Update status
        bloodRequestService.updateBloodRequestStatus(id, status);

        // Send email to recipient
        String recipientEmail = bloodRequest.getEmail(); // assuming your BloodRequest model has getEmail()
        if (recipientEmail == null || recipientEmail.isEmpty()) {
            return ResponseEntity.status(500).body("Email not found for this blood request.");
        }

        String subject = "Your Blood Request has been " + status;
        String messageBody = "Dear " + bloodRequest.getRepresentativeName() + ",<br><br>" +
                "Your blood request has been <b>" + status + "</b>.<br>" +
                "Thank you for using our blood donation system.<br><br>" +
                "Regards,<br>The Blood Donation Team";

        boolean emailSent = emailService.sendEmail(recipientEmail, subject, messageBody);
        if (emailSent) {
            return ResponseEntity.ok("Blood request updated and email sent.");
        } else {
            return ResponseEntity.status(500).body("Status updated, but failed to send email.");
        }
    }
}
