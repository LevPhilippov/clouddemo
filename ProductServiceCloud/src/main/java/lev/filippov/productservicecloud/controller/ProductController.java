package lev.filippov.productservicecloud.controller;


import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;

import java.util.List;

public interface ProductController {

     ResponceEntity<List<ProductDto>> showAllProducts();

     ResponceEntity<ProductDto> showAllProducts(Long id);

     ResponceEntity<ProductDto> save(ResponceEntity<ProductDto> responceEntity);

     ResponceEntity<ProductDto> update(ResponceEntity<ProductDto> responceEntity);

     boolean delete(Long id);

}
