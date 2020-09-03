package mashup.backend.myeonvely.item.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mashup.backend.myeonvely.common.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer averageCycle;

    @Builder
    public Category(String name, Integer averageCycle) {
        this.name = name;
        this.averageCycle = averageCycle;
    }
}
