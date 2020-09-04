package mashup.backend.tich.admin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mashup.backend.tich.admin.service.AdminCategoryService;
import mashup.backend.tich.item.dto.CategoryResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

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
}
