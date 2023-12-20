package org.startsteps.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Realtor")
public class Realtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long realtorId;
    @NotNull(message = "Name must be between 2 to 50 characters")
    @Size(min = 2, max = 50)
    private String name;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Phone must not be blank")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "realtor")
    private List<Property> propertyList = new ArrayList<>();

}
