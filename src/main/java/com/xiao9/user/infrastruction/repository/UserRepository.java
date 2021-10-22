package com.xiao9.user.infrastruction.repository;

import com.xiao9.user.domain.IUserRepository;
import com.xiao9.user.domain.User;
import com.xiao9.user.infrastruction.po.UserPO;
import com.xiao9.user.infrastruction.repository.converter.UserConverter;
import com.xiao9.user.infrastruction.repository.dao.UserDao;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String login) {
        if(new EmailValidator().isValid(login, null)) {
            return userDao.findOneByEmail(login)
                    .map(UserConverter.INSTANCE::po2Entity);
        }
        Optional<UserPO> po = userDao.findOneByLogin(login);
        return po.map(UserConverter.INSTANCE::po2Entity);
    }
}
