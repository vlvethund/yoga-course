package com.mindeulle.yoga.course.aggregate.profile.domain.logic;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileLogic {

    private final ProfileStore profileStore;
    private final PasswordEncoder passwordEncoder;

    public ProfileLogic(ProfileStore profileStore, PasswordEncoder passwordEncoder) {
        this.profileStore = profileStore;
        this.passwordEncoder = passwordEncoder;
    }

    public Profile create(ProfileDoc profileDoc) {
        String hashpw = BCrypt.hashpw(profileDoc.getPassword(), BCrypt.gensalt());
        profileDoc.setPassword(hashpw);
        ProfileDoc doc = this.profileStore.create(profileDoc);
        Profile profile = new Profile();
        BeanUtils.copyProperties(doc, profile);
        return profile;
    }

    public Profile retrieve(String id) {
        return profileStore.retrieve(id);
    }
}
