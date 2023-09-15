package dev.spring.square.pay.model;

public class BodyCreatePayment {
    private String locationId;
    private String sourceId;
    private String verificationToken;
    private String idempotencyKey;

    public BodyCreatePayment() {
    }

    public BodyCreatePayment(String locationId, String sourceId, String verificationToken, String idempotencyKey) {
        this.locationId = locationId;
        this.sourceId = sourceId;
        this.verificationToken = verificationToken;
        this.idempotencyKey = idempotencyKey;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    @Override
    public String toString() {
        return "BodyCreatePayment{" +
                "locationId='" + locationId + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", idempotencyKey='" + idempotencyKey + '\'' +
                '}';
    }
}
