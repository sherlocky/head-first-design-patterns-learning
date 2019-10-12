package com.sherlocky.headfirst.pattern._13_proxy.virtualproxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 虚拟代理，以CD封面展示为例
 * <p>首先显示等待消息，当图像加载完成后，委托 ImageIcon 显示图像</p>
 */
public class ImageProxy implements Icon {
    volatile ImageIcon imageIcon;
    final URL imageURL;
    /**
     * 正在检索标志位
     */
    boolean retrieving = false;

    public ImageProxy(URL url) {
        imageURL = url;
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            // 加载过程中 ImageProxy 会显示 加载中 提示
            g.drawString("加载 CD 封面中，请稍候...", x + 300, y + 190);
            if (!retrieving) {
                retrieving = true;
                // 检索线程
                new Thread(() -> {
                    try {
                        // ImageProxy 创建一个 ImageIcon，然后开始从网络URL上加载封面
                        // 图像加载完成后，ImageProxy 把所有方法调用委托给真正的 ImageIcon 处理
                        setImageIcon(new ImageIcon(imageURL, "CD 封面"));
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
        // 如果用户请求新的封面，就创建新的代理，重复该过程
    }
}
