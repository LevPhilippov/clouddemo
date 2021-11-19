package lev.filippov.productservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceCloudApplication.class, args);
    }
}
