package dev.emir.e_commerce.api;

import dev.emir.e_commerce.business.abstracts.ICategoryService;
import dev.emir.e_commerce.core.config.modelMapper.IModelMapperService;
import dev.emir.e_commerce.core.result.ResultData;
import dev.emir.e_commerce.core.utilies.ResultHelper;
import dev.emir.e_commerce.dto.request.category.CategorySaveRequest;
import dev.emir.e_commerce.dto.response.category.CategoryResponse;
import dev.emir.e_commerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapperService;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapperService) {
        this.categoryService = categoryService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        // map for save
        Category saveCategory = modelMapperService.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);

        return ResultHelper.created(this.modelMapperService.forResponse().map(saveCategory, CategoryResponse.class));
    }
}
