package top.yangwulang.swings.ui.interfaces;

/**
 * @author yangwulang
 */
@FunctionalInterface
public interface ComponentFragment<T> {
    /**
     * 改写UI
     *
     * @param component ui组件
     */
    void print(T component);
}
