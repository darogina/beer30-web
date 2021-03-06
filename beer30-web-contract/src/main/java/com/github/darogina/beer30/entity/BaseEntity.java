package com.github.darogina.beer30.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Audited
public abstract class BaseEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = -8629675921073873654L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "OPTLOCK")
    private long version = 0;

    @Column(name = "UUID", nullable = false, unique = true)
    private String uuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onCreate() {
        getUuid();
    }

//    public abstract boolean equals(Object o);
//    public abstract int hashCode();

}
