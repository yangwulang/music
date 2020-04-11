package top.yangwulang;

import top.yangwulang.swings.ui.CustomizeJavaDialog;
import top.yangwulang.swings.ui.CustomizeJavaFrame;


/**
 * @author yangwulang
 */
public class MainApplication {
    public static void main(String[] args) {
        CustomizeJavaFrame customizeJavaFrame = new CustomizeJavaFrame();
        customizeJavaFrame.setSize(1000, 500);
        customizeJavaFrame.setTitle("你好");
        customizeJavaFrame.startToPrintMainBody(frame -> {

        });
        customizeJavaFrame.setVisible(true);
        CustomizeJavaDialog dialog = new CustomizeJavaDialog("你好", customizeJavaFrame);
        dialog.setModal(true);
        dialog.showDialog();
    }
}
