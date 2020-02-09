package cn.ChaosWong.flash.core.factory;

import cn.ChaosWong.flash.bean.dto.UserDto;
import cn.ChaosWong.flash.bean.entity.system.User;
import org.springframework.beans.BeanUtils;


public class UserFactory {

    public static User createUser(UserDto userDto, User user){
        if(userDto == null){
            return null;
        }else{
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
    public static User updateUser(UserDto userDto,User user){
        if(userDto == null){
            return null;
        }else{
            user.setName(userDto.getName());
            user.setDeptid(userDto.getDeptid());
            user.setSex(userDto.getSex());
            user.setPhone(userDto.getPhone());
            user.setEmail(userDto.getEmail());
            user.setBirthday(userDto.getBirthday());
            if(userDto.getStatus()!=null){
                user.setStatus(userDto.getStatus());
            }
            return user;
        }
    }
}
