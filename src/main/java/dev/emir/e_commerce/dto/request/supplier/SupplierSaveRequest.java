package dev.emir.e_commerce.dto.request.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SupplierSaveRequest {
    @NotNull
    private String companyName;
    private String contactName;
    private String address;
    @Email
    private String contactMail;

    public SupplierSaveRequest() {
    }

    public SupplierSaveRequest(String companyName, String contactName, String address, String contactMail) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.address = address;
        this.contactMail = contactMail;
    }


    public @NotNull String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotNull String companyName) {
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
