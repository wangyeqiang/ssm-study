import com.example.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring.xml")
public class SpringAopTest {

    // aop - 代理 - jdk - 接口 - 代理类 - 代理对象和目标对象 拜把子兄弟 兄弟关系
    // aop - 代理
    @Autowired
    private CalculatorPureImpl calculator;
    
    @Test
    public void test(){

        int add = calculator.add(1,1);
        System.out.println("add = " + add);
    }

}
