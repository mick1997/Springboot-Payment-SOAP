package com.snva.soap.payments.Repository;

import com.snva.soap.payments.model.Bootcamp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends MongoRepository<Bootcamp, String> {

    Bootcamp findBootcampById(String id);
}
