package com.dp.digip.service.interfaces;

import com.dp.digip.models.User;
import com.dp.digip.models.DTO.UserObject;
import com.dp.digip.models.DTO.ParentObject;

public interface UserService{

    //public long getNumberOfUsers(); 

    //public User findUser(String username);

    //public User getCurrentUser();

    //public void updateUser(User user);

    //public void enableUser(String username);

    //public void disableUser(String username);

    public void saveUser(UserObject user,ParentObject parent);

}
