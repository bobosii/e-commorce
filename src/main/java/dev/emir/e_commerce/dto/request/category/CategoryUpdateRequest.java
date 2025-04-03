package dev.emir.e_commerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CategoryUpdateRequest {
    @Positive(message = "Id degeri pozitif sayi olmak zorunda")
    private int id;
    @NotNull(message = "Kategori isimi bos veya null olamaz")
    private String name;

    public CategoryUpdateRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryUpdateRequest(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
