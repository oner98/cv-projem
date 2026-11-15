package com.alioner.portfolio.contact;

import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public void save(ContactRequest request) {
        ContactMessage contactMessage = new ContactMessage(request.name(), request.email(), request.message());
        contactMessageRepository.save(contactMessage);
    }
}
