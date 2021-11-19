package lev.filippov.productservicecloud.service;

import lev.filippov.common.ProductDto;
import lev.filippov.common.ResponceEntity;
import lev.filippov.productservicecloud.entity.Product;
import lev.filippov.productservicecloud.entity.mapper.ProductToProductDtoMapper;
import lev.filippov.productservicecloud.exceptions.IdShouldBeNullToPersistEcxeption;
import lev.filippov.productservicecloud.exceptions.ProductIdNotFoundException;
import lev.filippov.productservicecloud.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductService {

    ProductRepository productRepository;
    ProductToProductDtoMapper mapper = Mappers.getMapper(ProductToProductDtoMapper.class);

    @Autowired
    private void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponceEntity<List<ProductDto>> findAll(){
        ResponceEntity<List<ProductDto>> responceEntity = new ResponceEntity<>(new ArrayList<ProductDto>());
        productRepository.findAll().stream().map(p-> mapper.productToProductDto(p)).forEach(responceEntity.getContent()::add);
        return responceEntity;
    }
//    @Transactional
//    public ProductDto saveOrUpdate(ProductDto dto) {
//        Product saved = productRepository.save(mapper.productDtoToProduct(dto));
//        return mapper.productToProductDto(saved);
//    }
    @Transactional
    public ResponceEntity<ProductDto> save(ResponceEntity<ProductDto> responceEntity) {
        if(responceEntity.getContent().getProductId() != null){
            throw new IdShouldBeNullToPersistEcxeption();
        }
        Product saved = productRepository.save(mapper.productDtoToProduct(responceEntity.getContent()));
        return new ResponceEntity<>(mapper.productToProductDto(saved));
    }

    @Transactional
    public ResponceEntity<ProductDto> update(ResponceEntity<ProductDto> responceEntity) {
        if(responceEntity.getContent().getProductId() == null){
            throw new ProductIdNotFoundException();
        }
        Product saved = productRepository.save(mapper.productDtoToProduct(responceEntity.getContent()));
        return new ResponceEntity<>(mapper.productToProductDto(saved));
    }

    @Transactional
    public boolean delete(Long id) {
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return true;
        } else return false;
    }

    public ResponceEntity<ProductDto> findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductIdNotFoundException());
        return new ResponceEntity<>(mapper.productToProductDto(product));
    }
}
