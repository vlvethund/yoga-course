package com.mindeulle.yoga.course.aggregate.profile.store.mongo;

import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.repository.ProfileMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileMongoStore implements ProfileStore {

    private final ProfileMongoRepository profileMongoRepository;

    public ProfileMongoStore(ProfileMongoRepository profileMongoRepository) {
        this.profileMongoRepository = profileMongoRepository;
    }

    @Override
    public ProfileDoc save(ProfileDoc doc) {
        return profileMongoRepository.save(doc);
    }
}
