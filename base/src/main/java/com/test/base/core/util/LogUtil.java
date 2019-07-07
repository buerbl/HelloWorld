package com.test.base.core.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.LogLog;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class LogUtil {
    private final static String LOGGER_FAIL = "failLogger";
    private final static String LOGGER_DEBUG = "debugLogger";
    private final static String LOGGER_INFO = "infoLogger";
    private final static String LOGGER_MAIL = "mailLogger";
    private static String project;
    private static String server;
    private static String logFilePath = null;
    private static final String FQCN = LogUtil.class.getName();

    private static boolean isflumelog=false;

    // 加载log4j配置文件
    static {
        try {
            Properties props = loadProperties();
            project = props.getProperty("project");
            // 处理server字段
            server = props.getProperty("server");
            if (CommonUtil.isNull(server)) {
                String serverip = CommonUtil.getLocalIP();
                String[] iptemps = serverip.split("\\.");
                server = iptemps[2] + "_" + iptemps[3];
                props.setProperty("server", server);
            }
            logFilePath = props.getProperty("logFilePath");
            //log4j阿里云服务器邮件配置
            System.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            System.setProperty("mail.smtp.socketFactory.fallback", "false");
            System.setProperty("mail.smtp.port", "465");
            System.setProperty("mail.smtp.socketFactory.port", "465");
            System.setProperty("mail.smtp.auth", "true");
            // 设置log4j配置
            PropertyConfigurator.configure(props);
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        // log4j.properties
        URL resoucePath = PropertiesLoader.class.getClassLoader().getResource(
                "log4j.properties");
        File file = new File(resoucePath.getPath());
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            props.load(in);
        } catch (Exception e) {
            LogLog.error(String.format("加载配置文件：%s失败！", file.getAbsolutePath()),
                    e);
        } finally {
            try {
                in.close();
            } catch (Exception e1) {
                LogLog.error(String.format("关闭配置文件：%s输入流失败！",
                        file.getAbsolutePath()), e1);
            }
        }
        // statcollection.properties
        Properties props_stat = new Properties();
        resoucePath = PropertiesLoader.class.getClassLoader().getResource(
                "flumelog.properties");
        if (resoucePath != null) {
            isflumelog=true;
            file = new File(resoucePath.getPath());
            try {
                in = new FileInputStream(file);
                props_stat.load(in);
            } catch (Exception e) {
                LogLog.error(
                        String.format("加载配置文件：%s失败！", file.getAbsolutePath()),
                        e);
            } finally {
                try {
                    in.close();
                } catch (Exception e1) {
                    LogLog.error(
                            String.format("关闭配置文件：%s输入流失败！",
                                    file.getAbsolutePath()), e1);
                }
            }
            props.putAll(props_stat);
        }
        return props;
    }

    /* mail */
    public static void mail(String message) {
        Logger logger = Logger.getLogger(LOGGER_MAIL);
        logger.error(message);
    }

    /* mail */
    public static void mail(String message, Throwable e) {
        Logger logger = Logger.getLogger(LOGGER_MAIL);
        logger.error(message, e);
    }

    /* error */
    public static void error(String message) {
        Logger logger = Logger.getLogger(LOGGER_FAIL);
        // logger.error(message);
        if(isflumelog) {
            logger.log(FQCN, Level.ERROR, message, null);
        } else {
            logger.error(message);
        }
    }

    public static void error(Throwable e) {
        Logger logger = Logger.getLogger(LOGGER_FAIL);
        if(isflumelog){
            String logmessage = "message:" + e.getMessage() + " "
                    + CommonUtil.getExceptionStackStr(e);
            // logger.error(logmessage);
            logger.log(FQCN, Level.ERROR, logmessage, null);
        }else {
            logger.error("", e);
        }
    }

    public static void error(String message, Throwable e) {
        Logger logger = Logger.getLogger(LOGGER_FAIL);
        if(isflumelog){
            String logmessage = "message:" + message + " " + e.getMessage() + " "
                    + CommonUtil.getExceptionStackStr(e);
            // logger.error(logmessage);
            logger.log(FQCN, Level.ERROR, logmessage, null);
        }else {
            logger.error(message, e);
        }
    }

    public static void error(String message, Object... arguments) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(LOGGER_FAIL);
        logger.error(message, arguments);

    }

    /* debug */
    public static void debug(String message) {
        Logger logger = Logger.getLogger(LOGGER_DEBUG);
        logger.debug(message);
    }

    public static void debug(String message, Throwable e) {
        Logger logger = Logger.getLogger(LOGGER_DEBUG);
        if(isflumelog){
            String logmessage = "message:" + message + " "
                    + CommonUtil.getExceptionStackStr(e);
            logger.debug(logmessage);
        }else {
            logger.debug(message, e);
        }
    }


    public static void debug(String message, Object... arguments) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(LOGGER_DEBUG);
        logger.debug(message, arguments);

    }

    /* info */
    public static void info(String message) {
        Logger logger = Logger.getLogger(LOGGER_INFO);
        logger.info(message);
    }

    public static void info(String message, Object... arguments) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(LOGGER_INFO);
        logger.info(message, arguments);

    }

    /* stat */
    public static void stat(String loggername, String message) {
        Logger logger = Logger.getLogger(loggername);
        logger.info(message);
    }

    /**
     * 记录统计日志
     *
     * @param loggername
     * @param separator
     *            字段间隔符
     * @param values
     */
    public static void stat(String loggername, String separator,
                            String... values) {
        Logger logger = Logger.getLogger(loggername);
        String logmessage = separator
                + CommonUtil.splitJointValue(separator, values);
        logger.info(logmessage);
    }





    public static String getLogFilePath() {
        return logFilePath;
    }


}
