package com.mindeulle.yoga.course.aggregate.profile.store.mongo.repository;

import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileMongoRepository extends MongoRepository<ProfileDoc, String> {
}
