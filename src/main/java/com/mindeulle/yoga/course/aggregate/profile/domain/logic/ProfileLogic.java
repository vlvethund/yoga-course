package com.mindeulle.yoga.course.aggregate.profile.domain.logic;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileLogic {

    private final ProfileStore profileStore;

    public ProfileLogic(ProfileStore profileStore) {
        this.profileStore = profileStore;
    }

    public void create(ProfileDoc profileDoc) {
        String hashpw = BCrypt.hashpw(profileDoc.getPassword(), BCrypt.gensalt());
        profileDoc.setPassword(hashpw);
        this.profileStore.create(profileDoc);
    }

    public Profile retrieve(String id) {
        return profileStore.retrieve(id);
    }
}
