<<<<<<< HEAD:src/main/java/mashup/backend/tich/user/domain/User.java
package mashup.backend.tich.user.domain;
=======
package mashup.backend.myeonvely.users.domain;
>>>>>>> feat : 사용자 Repository 추가:src/main/java/mashup/backend/myeonvely/users/domain/Users.java

import lombok.*;
import mashup.backend.tich.common.domain.BaseTimeEntity;
import mashup.backend.tich.device.domain.Device;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString(exclude = "devices")
@Entity
<<<<<<< HEAD:src/main/java/mashup/backend/tich/user/domain/User.java
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
=======
@NoArgsConstructor
public class Users extends BaseTimeEntity {
>>>>>>> feat : 사용자 Repository 추가:src/main/java/mashup/backend/myeonvely/users/domain/Users.java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Device> devices;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

<<<<<<< HEAD:src/main/java/mashup/backend/tich/user/domain/User.java
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public User update(String name, String picture){
=======
    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }

    public Users update(String name, String picture){
>>>>>>> feat : 사용자 Repository 추가:src/main/java/mashup/backend/myeonvely/users/domain/Users.java
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
