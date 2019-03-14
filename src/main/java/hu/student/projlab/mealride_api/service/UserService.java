package hu.student.projlab.mealride_api.service;


import hu.student.projlab.mealride_api.domain.User;
import hu.student.projlab.mealride_api.repository.RoleRepository;
import hu.student.projlab.mealride_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    /**
     * Note: This is a bad solution. I cant store yet the authorities of a User in SecurityContext so
     * I implement this function as a temporary solution to let me move on.
     *
     * @return the database User of the current login
     */
    User getCurrentUser(Optional<String> email) {
        if(!email.isPresent())
            return null;
        else {
            Optional<User> user = userRepository.findByEmail(email.get());
            if (user.isPresent())
                return user.get();
            else return null;
        }
    }





}
