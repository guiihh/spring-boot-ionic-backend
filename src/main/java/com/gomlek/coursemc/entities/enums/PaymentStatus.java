package com.gomlek.coursemc.entities.enums;

public enum PaymentStatus {
    
PENDING(1, "Pending"),
SETTLED(2, "Settled"),
CANCELED(3, "Canceled");


private int code;
private String discription;

private PaymentStatus(int code, String discription){
    this.code = code;
    this.discription = discription;
}

public int getCode(){
    return code;
}

public String getDiscription(){
    return discription;
}
public static PaymentStatus toEnum(Integer code){
    
    if (code == null){
        return null;
    }

    for (PaymentStatus xType : PaymentStatus.values()) {
        if(code.equals(xType.getCode())){
            return xType;
        }
    }

    throw new IllegalArgumentException("Id invalid" + code);
}
}
