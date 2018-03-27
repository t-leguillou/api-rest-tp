package au.com.octo.repositories;

import au.com.octo.domain.entities.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface myRepository extends CrudRepository<au.com.octo.domain.entities.Application, Long> {

    List<Application> findAllByFormId(String formId);

    @Query("select u from Application u where u.formId = ?1 and u.trackingNumber = ?2")
    Application findByIdAndTrackingId(String formId, String trackingId);

    Application findByTrackingNumber(String trackingId);

    void deleteByTrackingNumber(String trackingId);

    void deleteByFormId(String formID);

    void deleteAll();
}

