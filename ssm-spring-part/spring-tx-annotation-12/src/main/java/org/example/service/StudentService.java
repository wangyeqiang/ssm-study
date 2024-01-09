package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Transactional(timeout = 3)
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;


    /**
     * 添加事务：
     *   @Transactional
     *   位置： 方法 | 类 上
     *   方法：当前方法有事务
     *   类： 类下所有方法有事务
     *
     *   1. 只读模式
     *   只读模式可以提升查询事务的效率，推荐事务中只有查询代码，使用只读模式
     *   解释：一般情况都是通过类添加事务：
     *       类下的所有方法都有事务；
     *       查询方法可以通过再次添加注解，设置为只读模式，提高效率。
     *
     *   2. 超时时间
     *      默认： 永远不超时
     *      设置 timeout = 时间 描述， 超过时间 就会回滚事务，释放异常。
     *      如果类上设置了事务属性，方法也设置了事务注解，方法会不会生效?
     *      答：不会生效，因为方法上的注解覆盖了类上的注解
     *
     *   3. 指定异常回滚和指定异常不会滚
     *       默认情况下，发生运行时异常事务才会回滚
     *       我们可以指定Exception异常才回滚
     *       noRollbackFor 回滚异常范围内，控制某个异常回滚
     *
     *   4. 隔离级别设置，
     *      推荐设置第二隔离级别
     */

    @Transactional(readOnly = false, rollbackFor = Exception.class, noRollbackFor = FileNotFoundException.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(88,1);
        new FileInputStream("xxx");
        // int i = 1/0;
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo(){
        // 读取学生信息 查询数据库 不修改

    }


    /**
     * 传播行为
     * 声明两个独立修改数据库的事务业务方法
     * propagation = Propagation.REQUIRED 父方法有事务，就加入到父方法的事务中。
     *   最终是一个事务。 推荐使用默认值
     *
     * propagation = Propagation.REQUIRES_NEW
     *                不管父方法是否有事务，都是独立事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        studentDao.updateNameById("二狗子",1);
        int i = 1;
    }
}
