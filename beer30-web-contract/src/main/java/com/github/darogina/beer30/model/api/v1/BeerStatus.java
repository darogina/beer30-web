package com.github.darogina.beer30.model.api.v1;


import javax.validation.constraints.Min;

public class BeerStatus extends BaseModel {

    @Min(1)
    private Long statusTypeId;
    @Min(0)
    private String reason;
    @Min(1)
    private Long userId;

    public Long getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Long statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
