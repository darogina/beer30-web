package com.github.darogina.beer30.model.api.v1;

public class StatusType extends BaseModel {

    private String name;
    private String description;

    public StatusType() {}

    public StatusType(Long id, String name, String description) {
        this.name = name;
        this.description = description;
    }

    public StatusType(/*DateTime createDate, DateTime lastUpdate, String createdBy, String changedBy,*/ String uuid, String name, String description) {
        super(/*createDate, lastUpdate, createdBy, changedBy,*/ uuid);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
