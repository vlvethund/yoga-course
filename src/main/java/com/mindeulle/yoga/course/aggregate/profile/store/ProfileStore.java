package com.mindeulle.yoga.course.aggregate.profile.store;

import com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc.ProfileDoc;

public interface ProfileStore {
    ProfileDoc save(ProfileDoc doc);
}
