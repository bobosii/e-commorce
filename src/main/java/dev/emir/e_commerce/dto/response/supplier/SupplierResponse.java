package dev.emir.e_commerce.dto.response.supplier;

public class SupplierResponse {
    private int id;
    private String company;

    public SupplierResponse(int id, String company) {
        this.id = id;
        this.company = company;
    }

    public SupplierResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
