package com.mindeulle.yoga.course.aggregate.profile.domain.logic;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.ProfileStore;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileLogic {

    private final ProfileStore profileStore;

    public ProfileLogic(ProfileStore profileStore) {
        this.profileStore = profileStore;
    }

    public Profile save(ProfileDoc profileDoc) {
        ProfileDoc doc = this.profileStore.save(profileDoc);
        Profile profile = new Profile();
        BeanUtils.copyProperties(doc, profile);
        return profile;
    }
}
