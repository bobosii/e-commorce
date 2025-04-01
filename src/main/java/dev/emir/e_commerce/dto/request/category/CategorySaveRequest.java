package dev.emir.e_commerce.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategorySaveRequest {
    @NotNull
    @NotEmpty
    private String name;

    public CategorySaveRequest(String name) {
        this.name = name;
    }
    public CategorySaveRequest() {
    }

    public @NotNull @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotNull @NotEmpty String name) {
        this.name = name;
    }
}
