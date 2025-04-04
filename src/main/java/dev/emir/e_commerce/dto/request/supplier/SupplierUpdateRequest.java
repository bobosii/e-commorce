package dev.emir.e_commerce.dto.request.supplier;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SupplierUpdateRequest {
    @Positive
    @NotNull
    private int id;
    private String companyName;
    private String contactName;
    private String address;
    @Email
    private String contactMail;

    public SupplierUpdateRequest(int id, String companyName, String contactName, String address, String contactMail) {
        this.id = id;
        this.companyName = companyName;
        this.contactName = contactName;
        this.address = address;
        this.contactMail = contactMail;
    }

    @Positive
    @NotNull
    public int getId() {
        return id;
    }

    public void setId(@Positive @NotNull int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @Email String getContactMail() {
        return contactMail;
    }

    public void setContactMail(@Email String contactMail) {
        this.contactMail = contactMail;
    }
}
