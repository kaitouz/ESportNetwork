package com.gamace.mapper;

import com.gamace.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // user
    @Update("update user set password = #{password} where username = #{username}")
    void updatePasswordByUsername(@Param("username") String username,
                                 @Param("password") String password);

    @Update("update user set Role = #{Role} where username = #{username}")
    void updateRoleByUsername(@Param("username") String username,
                             @Param("Role") String Role);

    @Update("update user set" +
            " username = #{username}, first_name = #{first_name}," +
            " last_name = #{last_name}, email = #{email}, phone_number = #{phone_number}" +
            " where id = #{id}")
    void updateUserByID(@Param("id") int id,
                       @Param("username") String username,
                       @Param("first_name") String first_name,
                       @Param("last_name") String last_name,
                       @Param("email") String email,
                       @Param("phone_number") String phone_number);


    @Update("update user set" +
            " email = #{email} " +
            " where id = #{id}")
    void updateUserEmailByID(@Param("id") int id,
                        @Param("email") String email);

    @Update("update user set phone_number = #{phone_number} where id = #{id}")
    void updateUserPhoneNumberByID(@Param("id") int id,
                             @Param("phone_number") String phone_number);

    @Update("update user set first_name = #{first_name} where id = #{id}")
    void updateUserFirstNameByID(@Param("id") int id,
                             @Param("first_name") String first_name);

    @Update("update user set last_name = #{last_name} where id = #{id}")
    void updateUserLastNameByID(@Param("id") int id,
                             @Param("last_name") String last_name);

    @Update("update user set password = #{password} where id = #{id}")
    void updateUserPasswordByID(@Param("id") int id,
                                @Param("password") String password);

    @Update("update user set bio = #{bio} where id = #{id}")
    void updateUserBioByID(@Param("id") int id,
                                @Param("bio") String bio);

    @Update("update user set game = #{game} where id = #{id}")
    void updateUserGameByID(@Param("id") int id,
                           @Param("game") String game);

    @Update("update user set language = #{language} where id = #{id}")
    void updateUserLanguageByID(@Param("id") int id,
                            @Param("language") String language);

    @Update("update user set facebook = #{facebook} where id = #{id}")
    void updateUserFacebookByID(@Param("id") int id,
                                @Param("facebook") String facebook);

    @Update("update user set instagram = #{instagram} where id = #{id}")
    void updateUserInstagramByID(@Param("id") int id,
                                @Param("instagram") String instagram);

    @Insert("insert into user "
            + "(username, password, first_name, last_name, email, phone_number, role, game, language) "
            + "values "
            + "(#{username}, #{password}, #{first_name}, #{last_name}, #{email}, #{phone_number}, #{role}, #{game}, #{language}) ")

    void insertUser(@Param("username") String username,
                   @Param("password") String password,
                   @Param("first_name") String first_name,
                   @Param("last_name") String last_name,
                   @Param("email") String email,
                   @Param("phone_number") String phone_number,
                   @Param("role") String role,
                   @Param("game") String game,
                   @Param("language") String language
    );

    @Select("select count(*) from user where username = #{username}")
    int judgeUsernameExist(@Param("username") String username);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    @Select("select id from user where username = #{username}")
    int getIDByUsername(@Param("username") String username);

    @Select("select password from user where username = #{username}")
    String getPasswordByUsername(@Param("username") String username);

    @Select("select first_name from user where username = #{username}")
    String getFirst_nameByUsername(@Param("username") String username);

    @Select("select last_name from user where username = #{username}")
    String getLast_nameByUsername(@Param("username") String username);

    @Select("select email from user where username = #{username}")
    String getEmailByUsername(@Param("username") String username);

    @Select("select phone_number from user where username = #{username}")
    String getPhone_numberByUsername(@Param("username") String username);


    @Select("select * from user")
    List<User> getUserList();

    @Delete("delete from user where id = #{id}")
    void deleteUserByID(@Param("id") int id);

    @Select("select role from user where username = #{username}")
    String getRoleByUsername(@Param("username") String username);


}
