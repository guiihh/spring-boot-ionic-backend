package com.gomlek.coursemc.dto;

import java.io.Serializable;

public class ClientNewDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String cpfOuCpnj;
    private Integer type;

    private String publicPlace;
    private String number;
    private String complement;
    private String district;
    private String cep;

    private String phoneOne;
    private String phoneTwo;
    private String phoneTree;

    private Long cidadeId;

    public ClientNewDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCpnj() {
        return cpfOuCpnj;
    }

    public void setCpfOuCpnj(String cpfOuCpnj) {
        this.cpfOuCpnj = cpfOuCpnj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    public String getPhoneTwo() {
        return phoneTwo;
    }

    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public String getPhoneTree() {
        return phoneTree;
    }

    public void setPhoneTree(String phoneTree) {
        this.phoneTree = phoneTree;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    
}
