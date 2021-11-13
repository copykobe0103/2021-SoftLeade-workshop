package tw.com.fcb.mimosa.examples.gettingstarted;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.http.APIRequest;
import tw.com.fcb.mimosa.http.APIResponse;
import tw.com.fcb.mimosa.tracing.Traced;

import javax.validation.constraints.Min;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Traced
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  //static List<User> users = new ArrayList<User>();

  final UserRepository repository;
  final UserDtoMapper mapper;
  final UserService service;
//  @Autowired
//  UserDtoMapper mapper;
  @PostMapping("/names")
  APIResponse<User> getByName(@RequestBody APIRequest<String> name) {
    return APIResponse.success(service.getByName(name.getBody()));
  }

  @GetMapping
  APIResponse<List<UserDto>> getUsers() {
    return APIResponse.success(service.getUsers().stream()
      .map(mapper::from)
      .collect(Collectors.toList()))
      ;
//    List<UserDto> found = service.getUsers().stream().map(mapper::from).collect(Collectors.toList());
//    if (found.isEmpty()){
//      //throw new APIErrorT9nException(null);
//      //return APIResponse.error(err -> err.code("").message(""));
//    }
//    return APIResponse.success(found);
  }
//  List<UserDto> getUser() {
//    return service.getUsers().stream().map(mapper::from)
//      .collect(Collectors.toList());

//    List<UserDto> dtos = new ArrayList<UserDto>();
//    for (User user : users) {
//// //       UserDto dto = UserDto.builder()
////          .name(user.getName())
//// //         .build();
//      UserDto dto = mapper.from(user);
//      dtos.add(dto);
//    }
//      List<UserDto> java8dto = users.stream()
//        .map(user -> UserDto.builder().name(user.getName()).build())
//        .collect(Collectors.toList());
//    return dtos;

  @PostMapping
  APIResponse<Long> creatUser(@Validated @RequestBody APIRequest<CreateUserDto> user){
    return APIResponse.success(service.createUser(user.getBody()))
      .map(User::getId);
  }
//  void createUser(@Validated @RequestBody CreateUserDto user) {
//    service.createUser(user);
//  }



// repository: 2021-10-26-xxxxxx -> public

  //modify @PutMapping
//  @PutMapping
//  void modifyUser(@RequestBody User user) {
//    int i = 0;
//    for (User usr : users) {
//      if (usr.getName().equals(user.getName())) {
//        System.out.println("usr.getName()" + usr.getName());
//        System.out.println("user.getName()" + user.getName());
//        User modifyuser = User.builder().name(user.getName()).age(user.getAge()).build();
//        users.set(i, modifyuser);
//      }
//      i++;
//    }
//
//  }

  //delete user
  //@DeleteMapping
//  @DeleteMapping
//  void deleteUser(@RequestBody User user) {
//
//    for (User usr : users) {
//      if (usr.getName().equals(user.getName())) {
//        System.out.println("delete usr.getName()" + usr.getName());
//        System.out.println("delete user.getName()" + user.getName());
//        users.remove(usr);
//        break;
//      }
//    }
//
//  }
  //modify user
//  @PutMapping("/{id}")
//  void replaceUser(@PathVariable("id") Long id,@RequestBody User user){
//      for (User u : users){
//        if (u.getId() == id){
//          u.setName((user.getName()));
//          u.setAge(user.getAge());
//        }
//      }
//  }
//  void replaceUser(@PathVariable("id") long id, @RequestBody ReplaceUserDto user){
//    service.replaceUser(id,user);
//  }

  @PutMapping("/{id}")
  void replaceUser(@Min(0) @PathVariable("id") long id , @Validated @RequestBody ReplaceUserDto user ){
    service.replaceUser(id,user);
  }
  // delete user
  @DeleteMapping("/{id}")
  void deleteUser(@Min(0) @PathVariable("id") long id) {
    //users.removeIf(user -> user.getId() == id);
    service.delete(id);
  }

}
