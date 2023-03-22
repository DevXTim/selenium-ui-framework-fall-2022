package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    private String address;
    private String country;
    private String dob;
    private String emailAddress;
    private String firstName;
    private String gender;
    private String homePhone;
    private String lastName;
    private String locality;
    private String mobilePhone;
    private String password;
    private String postalCode;
    private String region;
    private String ssn;
    private String title;
    private String workPhone;
    
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
