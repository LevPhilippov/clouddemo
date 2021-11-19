package lev.filippov.productservicecloud.controller;

import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;
import lev.filippov.productservicecloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class ProductControllerImpl implements ProductController {

    private ProductService productService;

    @GetMapping(path = "/test")
    public String test(){
        return "test";
    }

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponceEntity<List<ProductDto>> showAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponceEntity<ProductDto> showAllProducts(@PathVariable(name="id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponceEntity<ProductDto> save(@RequestBody ResponceEntity<ProductDto> responceEntity){
        return productService.save(responceEntity);
    }

    @PutMapping(path = "/save")
    public ResponceEntity<ProductDto> update(@RequestBody ResponceEntity<ProductDto> responceEntity){
        return productService.update(responceEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean delete(@PathVariable(name = "id") Long id) {
        return productService.delete(id);
    }

}
