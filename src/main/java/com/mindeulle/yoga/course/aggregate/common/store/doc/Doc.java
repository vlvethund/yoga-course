package com.mindeulle.yoga.course.aggregate.common.store.doc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Doc {
    //
    @Id
    private String id;
    private String creator;
    private String modifier;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Doc() {
        //
        this.id = UUID.randomUUID().toString();
        this.created = LocalDateTime.now();
    }
}
