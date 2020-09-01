package pl.teo.petshop.service;

import pl.teo.petshop.entity.User;

public interface MessageService {
    boolean sendVerification(User receiver);
}
