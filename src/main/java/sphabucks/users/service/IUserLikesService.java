package sphabucks.users.service;

import sphabucks.users.model.UserLikes;
import sphabucks.users.vo.RequestUserLikes;

import java.util.List;

public interface IUserLikesService {
    void addUserLikes(RequestUserLikes requestUserLikes);
    List<UserLikes> getUserLikes(Long userId);
    List<UserLikes> getAll();
}
