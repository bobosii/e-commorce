package dev.emir.e_commerce.business.concretes;

import dev.emir.e_commerce.business.abstracts.ISupplierService;
import dev.emir.e_commerce.core.config.exception.NotFoundException;
import dev.emir.e_commerce.core.utilies.Messages;
import dev.emir.e_commerce.dao.SupplierRepo;
import dev.emir.e_commerce.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierManager implements ISupplierService{
    private final SupplierRepo supplierRepo;

    public SupplierManager(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    }

    @Override
    public Supplier get(int id) {
        return this.supplierRepo.findById(id).orElseThrow(() -> new NotFoundException(Messages.NOT_FOUND));
    }

    @Override
    public Page<Supplier> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.supplierRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Supplier supplier = this.get(id);
        this.supplierRepo.delete(supplier);
        return true;
    }

    @Override
    public Supplier update(Supplier supplier) {
        this.get(supplier.getId());
        return this.supplierRepo.save(supplier);
    }
}
