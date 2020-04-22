package top.yangwulang.panels.indexpanel;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import top.yangwulang.jsons.BaseRecommendResultTemplate;
import top.yangwulang.pojo.qq.RecommendResult;
import top.yangwulang.pojo.qq.RecommendResultData;
import top.yangwulang.services.QqService;
import top.yangwulang.swings.ui.CustomizeJavaImagePanel;
import top.yangwulang.swings.ui.StartApplicationFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * 首页推荐面板
 *
 * @author yangwulang
 * @date 2020/4/22 在swing的线程中增加了刷新面板，以防止需要事件才能刷新面板
 */
public class RecommendPanel extends JPanel {
    private List<RecommendResultData.DataBean.VHotBean> list = new LinkedList<>();
    private final RecommendPanel recommendPanel = this;

    private final Timer timer;

    public RecommendPanel() {
        try {
            StartApplicationFactory.start(this.getClass());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        ConfigurableListableBeanFactory beanFactory = StartApplicationFactory.getContext().getBeanFactory();
        QqService service = beanFactory.getBean(QqService.class);
        service.searchRecommend(new BaseRecommendResultTemplate<RecommendResultData>() {
            @Override
            public void callBack(RecommendResult<RecommendResultData> recommendResultDataRecommendResult, Exception exception) {
                list = recommendResultDataRecommendResult.getRecomPlaylist()
                        .getData()
                        .getV_hot();
            }
        });

        timer = new Timer(100, new Times());
        timer.start();
    }

    class Times extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (list.size() > 0) {
                list.stream().limit(10).forEach(bean -> SwingUtilities.invokeLater(() -> {
                    CustomizeJavaImagePanel javaImagePanel = new CustomizeJavaImagePanel(bean.getCover()
                            , bean.getTitle(), 200, 200, 60);
                    javaImagePanel.initUi();
                    recommendPanel.add(javaImagePanel);
                    recommendPanel.revalidate();
                }));
                timer.stop();
            }
        }
    }
}