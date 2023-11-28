package com.ontop.martinez.interview.transaction.domain.model;

public enum TransactionStatus {

    CREATED("CREATED"), PROCESSING("PROCESSING"), FAILED("FAILED"), FAILED_BY_PROVIDER("FAILED"), FAILED_BY_WALLET("FAILED_WALLET"), DENIED("DENIED"), SUCCEEDED("SUCCEEDED");

    public final String status;

    private TransactionStatus(String status) {
        this.status = status;
    }

    public static TransactionStatus valueOfString(String status) {
        for (TransactionStatus e : values()) {
            if (e.status.equalsIgnoreCase(status)) {
                return e;
            }
        }
        return null;
    }
}
