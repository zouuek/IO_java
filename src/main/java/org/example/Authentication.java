package org.example;


import org.apache.commons.codec.digest.DigestUtils;

public class Authentication {
    public static User login(String login, String password) {
        UserRepository repository = UserRepository.getInstance();
        User userFromList = repository.getUser(login);
//        System.out.println(hashPassword(password));
//        System.out.println(userFromList.getPassword());
        if (userFromList != null && hashPassword(password).equals(userFromList.getPassword())) {

            return userFromList;
        }
        return null;
    }

    public static Admin authenticateAdmin(String code) {
        if (Authentication.hashPassword(code).equals(Admin.getAuthenticationCode())) {
            return new Admin("admin");
        }
        return null;
    }

    public static String hashPassword(String password){
        return DigestUtils.sha256Hex(password);
    }


}
