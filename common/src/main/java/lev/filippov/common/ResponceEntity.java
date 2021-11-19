package lev.filippov.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ResponceEntity<T> {

    T content;

    public ResponceEntity(T content) {
        this.content = content;
    }
}
