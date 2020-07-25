package mashup.backend.myeonvely.users.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString(exclude = "user")
@Entity
@NoArgsConstructor
public class Devices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Devices(String token, Users user){
        this.token = token;
        this.user = user;
    }
}