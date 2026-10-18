package com.alioner.portfolio.api;

import com.alioner.portfolio.contact.ContactMessageService;
import com.alioner.portfolio.contact.ContactRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactMessageService contactMessageService;

    public ContactController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse submit(@Valid @RequestBody ContactRequest request) {
        contactMessageService.save(request);
        return new ContactResponse(true,
                "Mesajınız başarıyla alındı. En kısa zamanda dönüş yapacağım.");
    }
}
