package lev.filippov.frontend.controller;

import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController{

    ProductController productController;

    @Autowired
    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        ResponceEntity<List<ProductDto>> responceEntity = productController.showAllProducts();
        model.addAttribute("products", responceEntity.getContent());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("prod", new ProductDto());
        return "edit_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "prod") ProductDto productDto) {
        ResponceEntity<ProductDto> responceEntity = new ResponceEntity<>(productDto);
        if(productDto.getProductId() != null)
            productController.update(responceEntity);
        if(productDto.getProductId() == null)
            productController.save(responceEntity);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") Long id, Model model) {
        ResponceEntity<ProductDto> responceEntity = productController.showAllProducts(id);
        ProductDto dto = responceEntity.getContent();
        System.out.println(dto);
        model.addAttribute("prod", dto);
        return "edit_form";
    }

    @GetMapping("/del")
    public String delete(@PathParam("id") Long id) {
        productController.delete(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    @ResponseBody
    public String doTest(){
        return productController.test();
    }
}