package lev.filippov.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

public class ProductDto {
    Long productId;
    String productTitle;
    BigDecimal productPrice;

    public ProductDto(Long productId, String productTitle, BigDecimal productPrice) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public ProductDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
