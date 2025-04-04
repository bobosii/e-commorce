package dev.emir.e_commerce.api;

import dev.emir.e_commerce.business.abstracts.ICategoryService;
import dev.emir.e_commerce.business.abstracts.IProductService;
import dev.emir.e_commerce.business.abstracts.ISupplierService;
import dev.emir.e_commerce.core.config.modelMapper.IModelMapperService;
import dev.emir.e_commerce.core.result.Result;
import dev.emir.e_commerce.core.result.ResultData;
import dev.emir.e_commerce.core.utilies.ResultHelper;
import dev.emir.e_commerce.dto.request.product.ProductSaveRequest;
import dev.emir.e_commerce.dto.request.product.ProductUpdateRequest;
import dev.emir.e_commerce.dto.response.product.ProductResponse;
import dev.emir.e_commerce.dto.response.supplier.SupplierResponse;
import dev.emir.e_commerce.entities.Category;
import dev.emir.e_commerce.entities.Product;
import dev.emir.e_commerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final IProductService productService;
    private final IModelMapperService modelMapperService;
    private final ICategoryService categoryService;
    private final ISupplierService supplierService;

    public ProductController(
            IProductService productService,
            IModelMapperService modelMapperService,
            ICategoryService categoryService,
            ISupplierService supplierService) {

        this.productService = productService;
        this.modelMapperService = modelMapperService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    // Save product
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest){
        Product saveProduct = this.modelMapperService.forRequest().map(productSaveRequest, Product.class);

        // productSaveRequest has only id , but we need an object for save operation
        // So we assign an object

        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());

        saveProduct.setCategory(category);
        saveProduct.setSupplier(supplier);

        this.productService.save(saveProduct);

        return ResultHelper.created(this.modelMapperService.forResponse().map(saveProduct,ProductResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id") int id){
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(product,ProductResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> update(@Valid @RequestBody ProductUpdateRequest productUpdateRequest){
        Product updateProduct = modelMapperService.forRequest().map(productUpdateRequest,Product.class);
        this.productService.update(updateProduct);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateProduct,ProductResponse.class));
    }

    @GetMapping("/{id}/supplier")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> getSupplier(@PathVariable("id") int id){
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(product.getSupplier(),SupplierResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.productService.delete(id);
        return ResultHelper.ok();
    }

}
