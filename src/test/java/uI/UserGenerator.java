package uI;

import uI.pojos.SimpleUser;

public class UserGenerator {

    public static SimpleUser userGenerator() {
        String randomNumber = String.valueOf(System.currentTimeMillis());
        return SimpleUser
                .builder()
                .name(randomNumber)
                .email(randomNumber + "@mail.ru")
                .password(randomNumber)
                .build();
    }
}
