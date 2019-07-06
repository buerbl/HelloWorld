package com.test.excel;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.filechooser.FileSystemView;

/**
 * @author buer
 * create 2019/6/8 23:10
 * description excel读写
 */
public class Excel {
    private final static Logger logger = LoggerFactory.getLogger(Excel.class);

    @Test
    public void test(){
        //获取桌面路径
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        String desktop = fileSystemView.getHomeDirectory().getPath();
        logger.debug("桌面路径为：[{}]", desktop);

    }
}
