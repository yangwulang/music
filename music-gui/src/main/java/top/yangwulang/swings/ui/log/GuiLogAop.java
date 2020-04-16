package top.yangwulang.swings.ui.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangwulang
 */
@Aspect
public class GuiLogAop {
    private final Logger log = LoggerFactory.getLogger(GuiLogAop.class);

}
