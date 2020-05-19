package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Description:
 * Created by zhangteng on 2020/5/19.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;

    public User(String name) {
        this.name = name;
    }
}
