package org.startsteps.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    @NotBlank(message = "Property address cannot be blank")
    private String address;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private BigDecimal price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    @Temporal(TemporalType.DATE)
    private Date listingDate;
    @ManyToOne
    @JoinColumn(name = "realtorId", referencedColumnName = "realtorId")
    private Realtor realtor;
}
