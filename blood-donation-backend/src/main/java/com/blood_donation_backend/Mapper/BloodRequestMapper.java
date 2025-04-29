package com.blood_donation_backend.Mapper;

import com.blood_donation_backend.DTO.BloodRequest;
import com.blood_donation_backend.Entity.BloodRequestEntity;

public class BloodRequestMapper {

    public static BloodRequestEntity mapDtoToEntity(BloodRequest dto) {
        BloodRequestEntity entity = new BloodRequestEntity();

        entity.setPatientName(dto.getPatientName());
        entity.setBloodType(dto.getBloodType());
        entity.setRepresentativeName(dto.getRepresentativeName());
        entity.setRepresentativeRelation(dto.getRelationshipWithPatient()); // fixed
        entity.setRequestDate(dto.getRequestDate());
        entity.setPatientAge(dto.getPatientAge());
        entity.setPatientMedicalCondition(dto.getPatientMedicalCondition());
        entity.setEmail(dto.getEmail());

        return entity;
    }
}
