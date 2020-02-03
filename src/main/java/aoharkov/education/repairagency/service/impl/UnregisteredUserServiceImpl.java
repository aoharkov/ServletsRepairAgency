package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.UnregisteredUserService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public abstract class UnregisteredUserServiceImpl extends AbstractUserServiceImpl implements UnregisteredUserService {
    private static final String USER_EMAIL_COLLISION = "user is already present with such email";

    private final Encoder encoder;
    private final Validator<User> userValidator;

    public UnregisteredUserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao);
        this.encoder = encoder;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //todo validate login with email and password
        String encryptedPassword = encoder.encode(password);
        return userDao.findByEmail(email)
                .map(User::getPassword)
                .filter(userPass -> userPass.equals(encryptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException(USER_EMAIL_COLLISION);
        }
        userDao.save(user);
        return user;
    }
}
