package dev.emir.e_commerce.api;

import dev.emir.e_commerce.business.abstracts.ICategoryService;
import dev.emir.e_commerce.core.config.modelMapper.IModelMapperService;
import dev.emir.e_commerce.core.result.ResultData;
import dev.emir.e_commerce.core.utilies.ResultHelper;
import dev.emir.e_commerce.dto.request.category.CategorySaveRequest;
import dev.emir.e_commerce.dto.response.CursorResponse;
import dev.emir.e_commerce.dto.response.category.CategoryResponse;
import dev.emir.e_commerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id){
        Category category = this.categoryService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(category, CategoryResponse.class));
    }


    // Got a response with our own structure
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    )
    {
        Page<Category> categoryPage = this.categoryService.cursor(page,pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage.
                map(category -> this.modelMapperService.forResponse().
                        map(category, CategoryResponse.class));

        CursorResponse<CategoryResponse> cursor = new CursorResponse<>();
        cursor.setItems(categoryResponsePage.getContent());
        cursor.setPageNumber(categoryResponsePage.getNumber());
        cursor.setPageSize(categoryPage.getSize());
        cursor.setTotalElement(categoryResponsePage.getTotalElements());

        return ResultHelper.success(cursor);

    }
}
