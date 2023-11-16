package twotwone.notAlone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voices")
@Getter
@Builder
public class Voice {

    @Id
    private String id;
    private String name;
    private int count;
    public void increaseCount(){
        this.count++;
    }
}
