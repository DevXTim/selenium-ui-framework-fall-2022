package pojos;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    public final Faker FAKER = new Faker();
    private String address;
    private String country;
    private String dob;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String locality;
    private String mobilePhone;
    private String password;
    private String postalCode;
    private String region;
    private String ssn;
    private String title;
    private String workPhone;

    public RegisterUser(HashMap<String, String> registerValues) {
        for (String value : registerValues.values()) {
            if (value.contains("faker")) {
                switch (value) {
                    case "fakerAddress":
                        this.setAddress(FAKER.address().toString());
                        break;
                    case "fakerEmail":
                        this.setEmailAddress(FAKER.internet().emailAddress());
                        break;
                        case ""
                }
            }
        }
    }
}
