package com.blood_donation_backend.Service;



import com.blood_donation_backend.DTO.BloodRequest;
import com.blood_donation_backend.Entity.BloodRequestEntity;
import com.blood_donation_backend.Repository.BloodRequestRepository;
import com.blood_donation_backend.WebSocket.BloodRequestWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private BloodRequestWebSocketHandler webSocketHandler;

    public BloodRequestEntity saveBloodRequest(BloodRequestEntity bloodRequest) {
        // Debug logging
        System.out.println("Saving blood request: " + bloodRequest);
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
    public List<BloodRequestEntity> getAllRequests() {
        return bloodRequestRepository.findAll(); // This retrieves all the blood requests
    }
    public BloodRequestEntity getBloodRequestById(Long id) {
        return bloodRequestRepository.findById(id).orElse(null);
    }

    public BloodRequestEntity mapDtoToEntity(BloodRequest dto) {
        BloodRequestEntity entity = new BloodRequestEntity();

        entity.setPatientName(dto.getPatientName());
        entity.setBloodType(dto.getBloodType());
        entity.setRepresentativeName(dto.getRepresentativeName());
        entity.setRepresentativeRelation(dto.getRelationshipWithPatient()); // mapped correctly
        entity.setRequestDate(dto.getRequestDate());
        entity.setPatientAge(dto.getPatientAge());
        entity.setPatientMedicalCondition(dto.getPatientMedicalCondition());
        entity.setEmail(dto.getEmail());

        return entity;
    }


}

