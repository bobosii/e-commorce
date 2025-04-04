package dev.emir.e_commerce.business.abstracts;

import dev.emir.e_commerce.entities.Supplier;
import org.springframework.data.domain.Page;

public interface ISupplierService {
    Supplier save(Supplier supplier);
    Supplier get(int id);
    Page<Supplier> cursor(int page, int pageSize);
    boolean delete(int id);
    Supplier update(Supplier supplier);

}
