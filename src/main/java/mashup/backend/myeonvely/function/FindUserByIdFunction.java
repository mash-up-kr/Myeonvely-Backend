package mashup.backend.myeonvely.function;

import lombok.AllArgsConstructor;
import mashup.backend.myeonvely.exception.UserNotFoundException;
import mashup.backend.myeonvely.user.domain.User;
import mashup.backend.myeonvely.user.domain.UserRepository;

import java.util.function.Function;

@AllArgsConstructor
public class FindUserByIdFunction implements Function<Long, User> {

    private UserRepository userRepository;

    public User apply(Long userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
