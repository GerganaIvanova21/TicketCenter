package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.User;
import bg.tuvarna.si.ticketcenterl.models.response.UserDataResponse;
import bg.tuvarna.si.ticketcenterl.models.response.UserResponse;
import bg.tuvarna.si.ticketcenterl.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class UserService   {

    private final UserRepository userRepository;
    public UserResponse getUserByEmail(String email){
        User user = userRepository.findByEmail(email).get();
        return new UserResponse(user.getUserID(),user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public UserDataResponse getUserData(String name){
        var user= userRepository.findByEmail(name).get();
        return new UserDataResponse(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole().toString());
    }


   public void deleteUser(Integer id){
        userRepository.deleteById(id);
   }

}
