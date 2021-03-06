package mashup.backend.tich.faq.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FaqSaveRequestDto {

    private String question;
    private String answer;

    @Builder
    public FaqSaveRequestDto(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
