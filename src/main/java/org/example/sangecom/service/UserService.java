package org.example.sangecom.service;


import org.example.sangecom.dto.request.UserDto;
import org.example.sangecom.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

	public User saveUser(UserDto user);

	public User getUserByEmail(String email);

	public List<User> getUsers(String role);

	public Boolean updateAccountStatus(Integer id, Boolean status);

	public void increaseFailedAttempt(UserDto user);

	public void userAccountLock(User user);

	public boolean unlockAccountTimeExpired(UserDto user);

	public void resetAttempt(int userId);

	public void updateUserResetToken(String email, String resetToken);

	public User getUserByToken(String token);

	public User updateUser(UserDto user);

	public User updateUserProfile(UserDto user, MultipartFile img);

	public User saveAdmin(UserDto user);

	public Boolean existsEmail(String email);

}
