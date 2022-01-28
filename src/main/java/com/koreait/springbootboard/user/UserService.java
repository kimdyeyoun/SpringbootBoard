package com.koreait.springbootboard.user;


import com.koreait.springbootboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private MyUserUtils userUtils;
    // 0:에러, 1:성공, 2:아이디없음, 3:비밀번호 다름
    public int login(UserEntity entity){
        UserEntity dbUser = null;
        try {
            dbUser = mapper.selUser(entity);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        if (entity.getUid() == null){
            return 2;//아이디 없어
        }
        if (!BCrypt.checkpw(entity.getUpw(), dbUser.getUpw())){
            return 3;//비밀번호 없어
        }
        dbUser.setUpw(null);
        dbUser.setRdt(null);
        dbUser.setMdt(null);
        userUtils.setLoginUser(dbUser);
        return 1;
    }
}
