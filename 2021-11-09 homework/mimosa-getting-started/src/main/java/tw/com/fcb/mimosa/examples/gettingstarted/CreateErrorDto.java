package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateErrorDto {


    //不可為空字串
    @NotBlank
    String category;
    @NotBlank
    String code;
    @NotBlank
    String translation;
}
