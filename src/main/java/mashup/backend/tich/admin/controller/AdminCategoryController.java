package mashup.backend.tich.admin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mashup.backend.tich.admin.service.AdminCategoryService;
import mashup.backend.tich.item.dto.CategoryResponseDto;
import mashup.backend.tich.item.dto.CategorySaveRequestDto;
import mashup.backend.tich.item.dto.CategoryUpdateRequestDto;
import mashup.backend.tich.user.domain.Role;
import mashup.backend.tich.user.domain.User;
import mashup.backend.tich.user.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;
    private final UserRepository userRepository; /* 삭제 예정(관리자 확인용) */

    @ApiOperation("카테고리 목록 조회")
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> showCategories() {
        List<CategoryResponseDto> categoryResponseDto = adminCategoryService.showCategories();

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    @ApiOperation("카테고리 상세 조회")
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> showCategory(@PathVariable Long categoryId) {
        CategoryResponseDto categoryResponseDto = adminCategoryService.showCategory(categoryId);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    @ApiOperation("카테고리 등록")
    @PostMapping
    public ResponseEntity<CategoryResponseDto> saveCategory(@RequestHeader String accessToken,
                                                            @RequestBody CategorySaveRequestDto requestDto) {
        // 임시 코드 : 추후 수정
        User user = makeTempUser();
        // ToDo : user check (accessToken)

        CategoryResponseDto categoryResponseDto = adminCategoryService.saveCategory(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseDto);
    }

    @ApiOperation("카테고리 수정")
    @PutMapping
    public ResponseEntity<CategoryResponseDto> updateCategory(@RequestHeader String accessToken,
                                                              @RequestBody CategoryUpdateRequestDto requestDto) {
        // 임시 코드 : 추후 수정
        User user = makeTempUser();
        // ToDo : user check (accessToken)

        CategoryResponseDto categoryResponseDto = adminCategoryService.updateCategory(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    /* 임시 코드 : 삭제 예정 */
    private User makeTempUser() {
        User user;
        try {
            user = userRepository.findByEmail("admin")
                    .orElseThrow(() -> new NoResultException());
        } catch (NoResultException e) {
            user = userRepository.save(User.builder()
                    .name("관리자")
                    .email("admin")
                    .picture("temp")
                    .role(Role.ADMIN)
                    .build());
        }
        return user;
    }
}
