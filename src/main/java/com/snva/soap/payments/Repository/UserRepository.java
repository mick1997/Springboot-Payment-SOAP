package com.snva.soap.payments.Repository;

import com.snva.soap.payments.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByFirstName(String firstName);
}
