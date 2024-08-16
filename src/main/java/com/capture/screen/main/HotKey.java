package com.capture.screen.main;

import thread.CaptureThread;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.JIntellitypeConstants;

/**
 * @author Administrator
 */
public class HotKey implements HotkeyListener {
    private static final int RUN = 168;
    private static final int PAUSE = 169;
    private   CaptureThread capture;

    public HotKey(CaptureThread capture) {
        this.capture = capture;
    }

    static {
        JIntellitype.getInstance().registerHotKey(RUN, JIntellitypeConstants.MOD_ALT + JIntellitypeConstants.MOD_CONTROL, (int)'R');
        JIntellitype.getInstance().registerHotKey(PAUSE, JIntellitypeConstants.MOD_ALT + JIntellitypeConstants.MOD_CONTROL ,  (int)'P');
    }

    @Override
    public void onHotKey(int identifier) {
        System.out.println("KEY="+identifier);
        if (PAUSE == identifier) {
            capture.pause();
            System.out.println("截屏线程暂停成功。。。\n");
        }
        if (RUN == identifier) {
            capture.play();
            System.out.println("截屏线程启动成功。。。。。\n");
        }

    }

}
