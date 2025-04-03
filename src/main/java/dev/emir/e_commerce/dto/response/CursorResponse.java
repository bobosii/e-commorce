package dev.emir.e_commerce.dto.response;

import java.util.List;

public class CursorResponse<T> {
    private int pageNumber;
    private int pageSize;
    private long totalElement;
    private List<T> items;

    public CursorResponse() {
    }

    public CursorResponse(int pageNumber, int pageSize, long totalElement, List<T> items) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElement = totalElement;
        this.items = items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
