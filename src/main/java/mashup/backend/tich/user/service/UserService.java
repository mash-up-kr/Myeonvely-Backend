package mashup.backend.tich.user.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.tich.jwt.JwtProvider;
import mashup.backend.tich.user.domain.User;
import mashup.backend.tich.user.domain.UserRepository;
import mashup.backend.tich.user.dto.SignInResponseDto;
import mashup.backend.tich.user.dto.SignUpRequestDto;
import mashup.backend.tich.user.dto.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) throws Exception {
        //System.out.println("Sign-up");
        if("".equals(signUpRequestDto.getToken().trim())){
            throw new Exception("invalid token");
        }
        if(userRepository.findByEmail(signUpRequestDto.getEmail()).isPresent()) {
            throw new Exception("duplicate email");
        }
        User user = userRepository.save(signUpRequestDto.toEntity());
        String token = jwtProvider.createToken(String.valueOf(user.getId()));
        return new SignUpResponseDto(user.getId(), token, user.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.getOne(Long.valueOf(id));
        if(!user.getId().equals(Long.valueOf(id))){
            throw new UsernameNotFoundException("Invalid Request");
        }
        return org.springframework.security.core.userdetails.User.builder().username(id).password("").roles("").build();
    }

    public SignInResponseDto loginByToken(String token) throws Exception {
        if(jwtProvider.validateToken(token)) {
            User user = userRepository.getOne(Long.valueOf(jwtProvider.getUserPk(token)));
            return new SignInResponseDto(user.getId(), token, user.getName());
        }
        else {
            throw new Exception("Invalid Token");
        }
    }

    public User findUserByToken(String token) {
        return userRepository.getOne(Long.valueOf(jwtProvider.getUserPk(token)));
    }

//    public SignInResponseDto loginByOauth(SignInRequestDto signInRequestDto) throws Exception {
//        User user = userRepository.findByEmail(signInRequestDto.)
//        if(user == null){
//            throw new Exception("need to sign up");
//        }
//        String token = jwtProvider.createToken(String.valueOf(user.getId()));
//        return new SignInResponseDto(user.getId(), token, user.getName());
//    }

}