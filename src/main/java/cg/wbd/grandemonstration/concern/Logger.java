package cg.wbd.grandemonstration.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    public void error() {
    }

    /**
     * Point cut được viết ở trên mô tả rằng phương thức log được thực thi khi phương thức triển khai findAll
     * từ interface CustomerService tung ra ngoại lệ thực thi.
     * Dấu .. ngu ý rằng poincut này áp dụng cho mọi bộ tham số của findAll.
     */
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.*.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[cus_prov_manager] co loi xay ra: %s.%s%s: %s", className, methodName, args, e.getMessage()));
//        System.out.println("[cus_prov_manager] co loi xay ra: " + e.getMessage());
    }
}
