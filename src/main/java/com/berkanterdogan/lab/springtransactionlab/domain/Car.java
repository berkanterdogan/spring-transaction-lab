package com.berkanterdogan.lab.springtransactionlab.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long timeInMsFromZeroToOneHundredKm;

    public static Car createWithoutId(String name, Long timeInMsFromZeroToOneHundredKm) {
        return builder()
                .name(name)
                .timeInMsFromZeroToOneHundredKm(timeInMsFromZeroToOneHundredKm)
                .build();
    }

}
