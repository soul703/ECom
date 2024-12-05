package org.example.sangecom.service.impl;

import org.example.sangecom.dto.request.UserDto;
import org.example.sangecom.entity.User;
import org.example.sangecom.service.UserService;
import org.springframework.stereotype.Service;
import org.example.sangecom.repository.UserRepositoty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@lombok.RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepositoty userRepository;
    @Override
    public User saveUser(UserDto userdto) {
        User user = new User();
        user.setName(userdto.getName());
        user.setMobileNumber(userdto.getMobileNumber());
        user.setEmail(userdto.getEmail());
        user.setAddress(userdto.getAddress());
        user.setCity(userdto.getCity());
        user.setState(userdto.getState());
        user.setPincode(userdto.getPincode());
        user.setPassword(userdto.getPassword());
        user.setProfileImage(userdto.getProfileImage());
        user.setRole(userdto.getRole());
        user.setIsEnable(userdto.getIsEnable());
        user.setAccountNonLocked(userdto.getAccountNonLocked());
        user.setFailedAttempt(userdto.getFailedAttempt());
        user.setLockTime(userdto.getLockTime());
        user.setResetToken(userdto.getResetToken());

        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsers(String role) {
        return List.of();
    }

    @Override
    public Boolean updateAccountStatus(Integer id, Boolean status) {
        return null;
    }

    @Override
    public void increaseFailedAttempt(UserDto user) {

    }

    @Override
    public void userAccountLock(User user) {

    }

    @Override
    public boolean unlockAccountTimeExpired(UserDto user) {
        return false;
    }

    @Override
    public void resetAttempt(int userId) {

    }

    @Override
    public void updateUserResetToken(String email, String resetToken) {

    }

    @Override
    public User getUserByToken(String token) {
        return null;
    }

    @Override
    public User updateUser(UserDto user) {
        return null;
    }

    @Override
    public User updateUserProfile(UserDto user, MultipartFile img) {
        return null;
    }

    @Override
    public User saveAdmin(UserDto user) {
        return null;
    }

    @Override
    public Boolean existsEmail(String email) {
        return null;
    }
}
