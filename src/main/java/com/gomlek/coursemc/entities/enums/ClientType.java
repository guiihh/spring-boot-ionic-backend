package com.gomlek.coursemc.entities.enums;

public enum ClientType {
    
PESSOAFISICA(1, "Pessoa Física"),
PESSOAJURIDICA(2, "Pessoa Juridica");


private int code;
private String discription;

private ClientType(int code, String discription){
    this.code = code;
    this.discription = discription;
}

public int getCode(){
    return code;
}

public String getDiscription(){
    return discription;
}
public static ClientType toEnum(Integer code){
    
    if (code == null){
        return null;
    }

    for (ClientType xType : ClientType.values()) {
        if(code.equals(xType.getCode())){
            return xType;
        }
    }

    throw new IllegalArgumentException("Id invalid" + code);
}


}