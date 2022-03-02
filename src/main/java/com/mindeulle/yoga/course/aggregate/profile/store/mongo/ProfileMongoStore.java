package com.mindeulle.yoga.course.aggregate.profile.store.mongo;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.repository.ProfileMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfileMongoStore implements ProfileStore {
    //
    private final ProfileMongoRepository profileMongoRepository;

    public ProfileMongoStore(ProfileMongoRepository profileMongoRepository) {
        //
        this.profileMongoRepository = profileMongoRepository;
    }

    @Override
    public ProfileDoc create(ProfileDoc doc) {
        //
        return profileMongoRepository.save(doc);
    }

    @Override
    public Profile retrieve(String id) {
        //
        Optional<ProfileDoc> profileDoc = profileMongoRepository.findById(id);
        return profileDoc.map(ProfileDoc::toDomain).orElse(null);
    }

    @Override
    public Profile findByUserId(String userId) {
        ProfileDoc profileDoc = profileMongoRepository.findByUserId(userId);
        return ProfileDoc.toDomain(profileDoc);
    }
}
