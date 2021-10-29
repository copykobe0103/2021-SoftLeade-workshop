package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.*;

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
public class User {

  String name;
  int age;

//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public int getAge() {
//    return age;
//  }
//
//  public void setAge(int age) {
//    this.age = age;
//  }
}
