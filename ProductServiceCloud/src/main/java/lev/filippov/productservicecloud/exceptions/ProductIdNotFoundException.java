package lev.filippov.productservicecloud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product with such Id doesn't exist.")
public class ProductIdNotFoundException extends RuntimeException{
}
