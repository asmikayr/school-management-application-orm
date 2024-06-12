package com.cydeo.dto;

import com.cydeo.enums.State;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @NotBlank(message = "Address is a required field")
    @Size(max = 50, min = 10, message = "Address must be between 10 and 50 characters long")
    private String addressInfo;

    @NotNull(message = "Please select a state.")
    @Enumerated(EnumType.STRING)
    private State state;

    @NotBlank(message = "Phone number is a required field !")
    @Pattern(regexp = "^\\+1 \\(\\d{3}\\) \\d{3}-\\d{4}$", message = "USA phone numbers in the format +1 (XXX) XXX-XXXX")
    private String phoneNumber;
}
