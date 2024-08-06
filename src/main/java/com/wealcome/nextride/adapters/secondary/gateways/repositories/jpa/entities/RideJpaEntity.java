package com.wealcome.nextride.adapters.secondary.gateways.repositories.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "rides")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class RideJpaEntity {

    @Id
    private UUID id;
    private UUID riderId;
    private String departure;
    private String arrival;
    private float distance;
    private boolean wantsUberX;
    private BigDecimal price;

}
