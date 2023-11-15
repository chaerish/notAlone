package twotwone.notAlone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "voices")
@Getter
@Setter
@Builder
public class Voice {
    @Id
    private long id;
    private String name;
    private int count;
    public void updateCount(){
        this.count++;
    }
}
