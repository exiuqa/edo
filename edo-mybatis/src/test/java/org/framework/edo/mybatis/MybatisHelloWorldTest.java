package org.framework.edo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.InputStream;

@DisplayName("junit5测试用例")
class MybatisHelloWorldTest {
    private static SqlSession sqlSession;

    @BeforeAll
    public static void init() throws Exception {
        System.out.println("初始化数据");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @AfterAll
    public static void close() {
        System.out.println("清理数据");
        //关闭资源
        sqlSession.close();
    }

    @BeforeEach
    public void setUp() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("mybaties 1级缓存查询测试用例")
    @Test
    public void testOneCashSelect() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //第一次查询，放入缓存中
        User user4 = userDao.selectByPrimaryKey("1");
        System.out.println("-----------exiuqa-----------user4值=" + user4 + "," + "当前类=MybatisHelloWorld.main()");

        //第二次查询，如果缓存中有，不与数据库交互，直接返回结果
        User user5 = userDao.selectByPrimaryKey("1");
        System.out.println("-----------exiuqa-----------user5值=" + user5 + "," + "当前类=MybatisHelloWorld.main()");
    }

    @DisplayName("mybaties 1级缓存修改测试用例")
    @Test
    public void testOneCashUpdate() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //第一次查询，放入缓存中
        User user1 = userDao.selectByPrimaryKey("1");
        System.out.println("-----------exiuqa-----------user1值=" + user1 + "," + "当前类=MybatisHelloWorld.main()");

        //第2次更新（增删改），会清除sqlsession中1级缓存，避免脏读。
        User user = new User();
        user.setId("1");
        user.setSysName("zhangSan");
        userDao.updateByPrimaryKeySelective(user);
        //需要手动提交事务
        sqlSession.commit();

        //第3次查询，如果缓存中有，不与数据库交互，直接返回结果
        User user2 = userDao.selectByPrimaryKey("1");
        System.out.println("-----------exiuqa-----------user2值=" + user2 + "," + "当前类=MybatisHelloWorld.main()");
    }

    @DisplayName("mybaties 2级缓存测试用例")
    @Test
    void testTwoCash() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user3 = userDao.selectByPrimaryKey("1");
        System.out.println("-----------exiuqa-----------user3值=" + user3 + "," + "当前类=MybatisHelloWorld.main()");
    }
}