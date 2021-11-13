package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {
  @NotBlank
  String Name;
  @Min(0)
  int age;

}
