package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;

//@NoArgsConstructor
//@AllArgsConstructor

//@ToString
//@Getter
//@Setter
//有@Data就包含上列
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue
  long id;
  @Column(name = "user_name")
  String name;
  int age;


}
