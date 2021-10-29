package tw.com.fcb.mimosa.examples.gettingstarted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

  static List<User> users = new ArrayList<User>();
  @Autowired
  UserDtoMapper mapper;

  @GetMapping
  List<UserDto> getUser() {
//      User user = new User();
//      user.setName("matt");
//      user.setAge(18);
//      return user;
//        return User.builder()
//                 .age(18)
//                 .name("matt")
//                 .build();
    List<UserDto> dtos = new ArrayList<UserDto>();
    for (User user : users) {
//        UserDto dto = UserDto.builder()
//          .name(user.getName())
//          .build();
      UserDto dto = mapper.from(user);
      dtos.add(dto);
    }
//      List<UserDto> java8dto = users.stream()
//        .map(user -> UserDto.builder().name(user.getName()).build())
//        .collect(Collectors.toList());
    return dtos;
  }

  @PostMapping
  void createUser(@RequestBody User user) {
    users.add(user);
  }


// repository: 2021-10-26-xxxxxx -> public

  //modify @PutMapping
  @PutMapping
  void modifyUser(@RequestBody User user) {
    int i = 0;
    for (User usr : users) {
      if (usr.getName().equals(user.getName())) {
        System.out.println("usr.getName()" + usr.getName());
        System.out.println("user.getName()" + user.getName());
        User modifyuser = User.builder().name(user.getName()).age(user.getAge()).build();
        users.set(i, modifyuser);
      }
      i++;
    }

  }

  //delete user
  //@DeleteMapping
  @DeleteMapping
  void deleteUser(@RequestBody User user) {

    for (User usr : users) {
      if (usr.getName().equals(user.getName())) {
        System.out.println("delete usr.getName()" + usr.getName());
        System.out.println("delete user.getName()" + user.getName());
        users.remove(usr);
        break;
      }
    }

  }
}
