package com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc;

import com.mindeulle.yoga.course.aggregate.common.store.doc.Doc;
import com.mindeulle.yoga.course.aggregate.profile.domain.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "profile")
public class ProfileDoc extends Doc {
    //
    private String userId;
    private String password;
    private String name;
    private String mobile;

    public static Profile toDomain(ProfileDoc doc) {
        //
        Profile profile = new Profile();
        BeanUtils.copyProperties(doc, profile);
        return profile;
    }

}
