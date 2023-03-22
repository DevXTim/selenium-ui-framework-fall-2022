package pojos;

import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    public final Faker FAKER = new Faker();
    @Expose()
    private String address;
    @Expose()
    private String country;
    @Expose()
    private String dob;
    @Expose()
    private String emailAddress;
    @Expose()
    private String firstName;
    @Expose()
    private String gender;
    @Expose()
    private String homePhone;
    @Expose()
    private String lastName;
    @Expose()
    private String locality;
    @Expose()
    private String mobilePhone;
    @Expose()
    private String password;
    @Expose()
    private String postalCode;
    @Expose()
    private String region;
    @Expose()
    private String ssn;
    @Expose()
    private String title;
    @Expose()
    private String workPhone;

    public RegisterUser(Map<String, String> registerValues) {
        for (String value : registerValues.values()) {
            if (value.contains("faker")) {
                switch (value) {
                    case "fakerAddress":
                        this.setAddress(FAKER.address().fullAddress());
                        break;
                    case "fakerEmail":
                        this.setEmailAddress(FAKER.internet().emailAddress().toString());
                        break;
                    case "fakerLastName":
                        this.setLastName(FAKER.name().lastName().toString());
                        break;
                    case "fakerSSN":
                        this.setSsn(FAKER.idNumber().ssnValid().toString());
                        break;
                    case "fakerPhone":
                        this.setHomePhone(FAKER.numerify("##########"));
                        break;
                    case "fakerCity":
                        this.setLocality(FAKER.country().capital());
                        break;
                }
            }
        }

        this.country = registerValues.get("country");
        this.dob = registerValues.get("dob");
        this.firstName = registerValues.get("firstName") + "_" + FAKER.idNumber().valid();
        this.gender = registerValues.get("gender");
        this.mobilePhone = registerValues.get("");
        this.password = registerValues.get("password");
        this.postalCode = registerValues.get("postalCode");
        this.region = registerValues.get("region");
        this.title = registerValues.get("title");
        this.workPhone = registerValues.get("");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterUser{");
        sb.append("address='").append(address).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", homePhone='").append(homePhone).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", ssn='").append(ssn).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", workPhone='").append(workPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
