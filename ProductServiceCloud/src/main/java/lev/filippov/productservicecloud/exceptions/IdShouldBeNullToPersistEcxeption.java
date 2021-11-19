package lev.filippov.productservicecloud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product Id should be null to persist. Use update query instead.")
public class IdShouldBeNullToPersistEcxeption extends RuntimeException{
}
