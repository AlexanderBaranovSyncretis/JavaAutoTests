package pages;

public class UserGenerator {

    public static Person userGenerator() {
        String randomNumber = String.valueOf(System.currentTimeMillis());
        return Person
                .builder()
                .name(randomNumber)
                .email(randomNumber + "@mail.ru")
                .password(randomNumber)
                .build();
    }
}
