package lev.filippov.productservicecloud.controller;

import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;
import lev.filippov.productservicecloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class ProductController {

    private ProductService productService;

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponceEntity<List<ProductDto>> showAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponceEntity<?> showAllProducts(@PathVariable(name="id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponceEntity<?> save(@RequestBody ResponceEntity<ProductDto> responceEntity){
        return productService.save(responceEntity);
    }

    @PutMapping(path = "/save")
    public ResponceEntity<?> update(@RequestBody ResponceEntity<ProductDto> responceEntity){
        return productService.update(responceEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable(name = "id") Long id) {
        return productService.delete(id);
    }

}
