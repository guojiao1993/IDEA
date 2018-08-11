package jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "jdbc/jdbctemplate.xml");
        UserDao userDao = context.getBean(UserDaoImpl.class);
        System.out.println(userDao.findOneUser(1));
        context.close();
    }
}
