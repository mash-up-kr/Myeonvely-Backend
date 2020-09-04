package mashup.backend.tich.admin.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.tich.exception.ResultDoseNotExistException;
import mashup.backend.tich.item.domain.Category;
import mashup.backend.tich.item.domain.CategoryRepository;
import mashup.backend.tich.item.dto.CategoryResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminCategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponseDto> showCategories() {
        List<Category> categories = categoryRepository.findAll();

        return CategoryResponseDto.listOf(categories);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDto showCategory(Long categoryId) {
        Category category = findCategoryById(categoryId);

        return CategoryResponseDto.of(category);
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(ResultDoseNotExistException::new);
    }
}
