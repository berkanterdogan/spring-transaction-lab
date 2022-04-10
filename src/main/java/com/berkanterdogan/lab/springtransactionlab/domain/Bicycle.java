package com.berkanterdogan.lab.springtransactionlab.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bicycle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static Bicycle createWithoutId(String name) {
        return builder()
                .name(name)
                .build();
    }
}
