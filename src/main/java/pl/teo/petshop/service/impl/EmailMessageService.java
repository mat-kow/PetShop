package pl.teo.petshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.service.MessageService;

import java.util.Objects;

@Service
public class EmailMessageService implements MessageService {

    private final JavaMailSender javaMailSender;
    private final Environment env;

    @Autowired
    public EmailMessageService(JavaMailSender javaMailSender, Environment env) {
        this.javaMailSender = javaMailSender;
        this.env = env;
    }

    @Override
    public boolean sendVerification(User receiver) {
        String domain = env.getProperty("pl.teo.petshop.domain");
        String link = String.format("%s/verify?id=%s&uuid=%s",domain, receiver.getId(), receiver.getUuid());
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(receiver.getEmail());
        mail.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
        mail.setSubject("PetShop - Weryfikacja");
        mail.setText("Kliknij w poniższy link aby zakończyć rejestrację\n" + link);
        javaMailSender.send(mail);
        return false;
    }
}
