package APIpractice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostPojo {
    // Jackson annotation, same as Expose. Used to set settings for including
    // or excluding fields on de-serialization
    // access = JsonProperty.Access.READ_ONLY -> deserialization
    // access = JsonProperty.Access.WRITE_ONLY -> serialization
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int userId;
    private String title;
    private String body;

    // We will use on the moment of serialization
    public PostPojo(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostPojo{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
