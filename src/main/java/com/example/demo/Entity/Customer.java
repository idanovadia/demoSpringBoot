package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

// @Data:
    // A shortcut for
        // @ToString, @EqualsAndHashCode,
        // @Getter on all fields,
        // @Setter on all non-final fields, and @RequiredArgsConstructor!
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @EqualsAndHashCode.Include
    private Integer studentID;

    private String firstName;

    private String lastName;
}
