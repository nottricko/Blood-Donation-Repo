package com.blood_donation_backend.Service;


import com.blood_donation_backend.DTO.BloodRequest;
import com.blood_donation_backend.Entity.BloodRequestEntity;
import com.blood_donation_backend.Repository.BloodRequestRepository;
import com.blood_donation_backend.WebSocket.BloodRequestWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private BloodRequestWebSocketHandler webSocketHandler;

    public BloodRequestEntity saveBloodRequest(BloodRequestEntity bloodRequest) {

        return bloodRequestRepository.save(bloodRequest);
    }

    public void updateBloodRequestStatus(Long requestId, String status) {
        BloodRequestEntity bloodRequest = bloodRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("BloodRequest with ID " + requestId + " not found"));

        bloodRequest.setStatus(status);
        bloodRequestRepository.save(bloodRequest);


        String message = "Blood request ID: " + requestId + " status updated to " + status;
        webSocketHandler.sendStatusUpdate(message);
    }
}

