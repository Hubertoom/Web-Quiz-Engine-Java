package engine.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record RegistrationRequest(@Email(regexp = ".+@.+\\.+.+") @NotBlank String email, @NotBlank  @Size(min = 5) String password) {
}
