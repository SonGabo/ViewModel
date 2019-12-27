package xyz.gabrielrohez.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import xyz.gabrielrohez.viewmodel.util.User;

public class UserViewModel extends ViewModel {

    List<User> userList;

    public UserViewModel() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
