package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.RecipientEntity;
import com.blood_donation_backend.Service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipients")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;


    @PostMapping
    public ResponseEntity<RecipientEntity> saveRecipient(@RequestBody RecipientEntity recipientEntity) {
        RecipientEntity savedRecipient = recipientService.saveRecipient(recipientEntity);
        return ResponseEntity.ok(savedRecipient);
    }


    @GetMapping
    public ResponseEntity<List<RecipientEntity>> getAllRecipients() {
        List<RecipientEntity> recipients = recipientService.getAllRecipients();
        return ResponseEntity.ok(recipients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecipientEntity> getRecipientById(@PathVariable int id) {
        Optional<RecipientEntity> recipient = recipientService.getRecipientById(id);
        return recipient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Need pa i improve need best approach
    @GetMapping("/by-date/{dateNeededBy}")
    public ResponseEntity<List<RecipientEntity>> findRecipientsByDateNeededBy(@PathVariable @RequestBody Date dateNeededBy) {
        List<RecipientEntity> recipients = recipientService.findRecipientsByDateNeededBy(dateNeededBy);
        if (recipients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipients);
    }






    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipient(@PathVariable int id) {
        recipientService.deleteRecipient(id);
        return ResponseEntity.noContent().build();
    }
}
