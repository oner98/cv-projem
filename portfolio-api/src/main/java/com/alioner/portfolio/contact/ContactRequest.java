package com.alioner.portfolio.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank(message = "Ad soyad zorunludur.")
        @Size(min = 2, max = 100, message = "Ad soyad 2 ile 100 karakter arasında olmalıdır.")
        String name,

        @NotBlank(message = "E-posta zorunludur.")
        @Email(message = "Geçerli bir e-posta adresi giriniz.")
        String email,

        @NotBlank(message = "Mesaj alanı boş olamaz.")
        @Size(min = 10, max = 5000, message = "Mesaj 10 ile 5000 karakter arasında olmalıdır.")
        String message
) {
}
