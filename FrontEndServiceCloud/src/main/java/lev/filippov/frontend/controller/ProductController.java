package lev.filippov.frontend.controller;

import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("productservice")
public interface ProductController {

    @GetMapping("productservice/api/v1/")
    ResponceEntity<List<ProductDto>> showAllProducts();

    @GetMapping("productservice/api/v1/{id}")
    ResponceEntity<ProductDto> showAllProducts(@PathVariable(name="id") Long id);

    @PostMapping("productservice/api/v1/save")
    ResponceEntity<ProductDto> save(@RequestBody ResponceEntity<ProductDto> responceEntity);

    @PutMapping(path = "productservice/api/v1/save")
    ResponceEntity<ProductDto> update(@RequestBody ResponceEntity<ProductDto> responceEntity);

    @DeleteMapping(path = "productservice/api/v1/delete/{id}")
    boolean delete(@PathVariable(name = "id") Long id);

    @GetMapping(path = "productservice/api/v1/test")
    String test();


}
