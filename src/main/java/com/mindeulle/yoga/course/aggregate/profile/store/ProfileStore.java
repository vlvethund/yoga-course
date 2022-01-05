package com.mindeulle.yoga.course.aggregate.profile.store;

import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;

public interface ProfileStore {
    ProfileDoc create(ProfileDoc doc);

    Profile retrieve(String id);
}
