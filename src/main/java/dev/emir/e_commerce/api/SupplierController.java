package dev.emir.e_commerce.api;

import dev.emir.e_commerce.business.abstracts.ISupplierService;
import dev.emir.e_commerce.core.config.modelMapper.IModelMapperService;
import dev.emir.e_commerce.core.result.Result;
import dev.emir.e_commerce.core.result.ResultData;
import dev.emir.e_commerce.core.utilies.ResultHelper;
import dev.emir.e_commerce.dto.request.supplier.SupplierSaveRequest;
import dev.emir.e_commerce.dto.request.supplier.SupplierUpdateRequest;
import dev.emir.e_commerce.dto.response.CursorResponse;
import dev.emir.e_commerce.dto.response.supplier.SupplierResponse;
import dev.emir.e_commerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapperService;
    public SupplierController(ISupplierService supplierService, IModelMapperService modelMapperService) {
        this.supplierService = supplierService;
        this.modelMapperService = modelMapperService;
    }

    // Create Supplier
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponse> save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest){
        // map for save
        Supplier saveSupplier = modelMapperService.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(saveSupplier);

        return ResultHelper.created(this.modelMapperService.forResponse().map(saveSupplier, SupplierResponse.class));
    }

    // Get supplier
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> get(@PathVariable("id") int id){
        Supplier supplier = this.supplierService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(supplier, SupplierResponse.class));
    }

    // Update Supplier
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> update(@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest){
        Supplier updateSupplier = modelMapperService.forRequest().map(supplierUpdateRequest,Supplier.class);
        this.supplierService.update(updateSupplier);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateSupplier, SupplierResponse.class));
    }

    // Get all suppliers with cursor
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<SupplierResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    )
    {
        Page<Supplier> supplierPage = this.supplierService.cursor(page,pageSize);
        Page<SupplierResponse> supplierResponsePage = supplierPage.map(supplier -> this.modelMapperService.forResponse()
                .map(supplier, SupplierResponse.class));
        return ResultHelper.cursor(supplierResponsePage);
    }

    // Delete suppliers
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.supplierService.delete(id);
        return ResultHelper.ok();
    }

}
