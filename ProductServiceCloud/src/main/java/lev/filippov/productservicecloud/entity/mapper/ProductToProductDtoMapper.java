package lev.filippov.productservicecloud.entity.mapper;

import lev.filippov.common.ProductDto;
import lev.filippov.productservicecloud.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductToProductDtoMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productTitle", source = "product.title")
    @Mapping(target = "productPrice", source = "product.price")
    ProductDto productToProductDto(Product product);

    @InheritInverseConfiguration
    Product productDtoToProduct(ProductDto productDto);
}
