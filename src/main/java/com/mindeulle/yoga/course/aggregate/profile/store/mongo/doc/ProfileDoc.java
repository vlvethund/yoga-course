package com.mindeulle.yoga.course.aggregate.profile.store.mongo.doc;

import com.mindeulle.yoga.course.aggregate.common.store.doc.Doc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collation = "profile")
public class ProfileDoc extends Doc {
    //
    private String name;
    private String password;
    private String mobile;

}
