package com.gamace.mapper;

import com.gamace.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Update("update course set username = #{username}," +
            " game = #{game}, language = #{language}, level = #{level}," +
            " price = #{price}" + " where id = #{id}")
    void updateCourse(@Param("id") int id,
                     @Param("username") String username,
                     @Param("game") String game,
                     @Param("language") String language,
                     @Param("level") String level,
                     @Param("price") String price
                     );

    @Update("update course set game = #{game} where id = #{id}")
    void updateGameCourse(@Param("id") int id,
                      @Param("game") String game
    );

    @Update("update course set language = #{language} where id = #{id}")
    void updateLanguageCourse(@Param("id") int id,
                          @Param("language") String language
                          );

    @Update("update course set level = #{level} where id = #{id}")
    void updateLevelCourse(@Param("id") int id,
                              @Param("level") String level
    );

    @Update("update course set price = #{price} where id = #{id}")
    void updatePriceCourse(@Param("id") int id,
                      @Param("price") String price
    );

    @Update("update course set description = #{description} where id = #{id}")
    void updateDescriptionCourse(@Param("id") int id,
                      @Param("description") String description
    );


    @Insert("insert into course "
            + "(username, game, language, level, price, description) "
            + "values "
            + "(#{username}, #{game}, #{language}, #{level}, #{price}, #{description})")
    void insertCourse(@Param("username") String username,
                      @Param("game") String game,
                      @Param("language") String language,
                      @Param("level") String level,
                      @Param("price") String price,
                      @Param("description") String description
    );

    @Select("select * from course")
    List<Course> getCourseList();

    @Select("select * from course where id = #{id}")
    Course getCourseById(@Param("id") int id);

    @Delete("delete from course where id = #{id}")
    void deleteCourse(@Param("id") int id);
}
