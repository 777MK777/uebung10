package gelato.mailversand;

import gelato.db.Kunde;

import java.io.IOException;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class MailVersand {

    public void sendMail(Mail mail, Kunde kunde) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        try {
            Process process = processBuilder
                    .command("java", "-jar", "bin/mail.jar", kunde.email(), mail.subject(), mail.body())
                    .redirectOutput(INHERIT)
                    .redirectError(INHERIT)
                    .start();
            process.waitFor(5, SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
