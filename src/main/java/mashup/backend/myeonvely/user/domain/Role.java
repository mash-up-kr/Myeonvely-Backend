<<<<<<< HEAD:src/main/java/mashup/backend/myeonvely/users/domain/Role.java
<<<<<<< HEAD:src/main/java/mashup/backend/tich/user/domain/Role.java
package mashup.backend.tich.user.domain;
=======
package mashup.backend.myeonvely.users.domain;
>>>>>>> feat : 사용자 Repository 추가:src/main/java/mashup/backend/myeonvely/users/domain/Role.java
=======
package mashup.backend.myeonvely.user.domain;
>>>>>>> style : 패키지명과 클래스명 수정 (#6):src/main/java/mashup/backend/myeonvely/user/domain/Role.java

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
