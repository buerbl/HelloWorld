package com.test1.util;

import org.apache.commons.io.IOUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public class CommonUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isNull(String value) {
        if (value == null || value.trim().length() == 0
                || value.equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取本机的ip地址
     */
    public static String getLocalIP() {
        String ip = "";
        try {
            // 获取网卡
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            // 遍历网卡
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                // 网卡名
                // System.out.println(netInterface.getName());
                // 获取该网卡绑定的InetAddresses
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                // 遍历该网卡绑定的InetAddresses
                while (addresses.hasMoreElements()) {
                    // 选择不为127.0.0.1的ip地址作为该机器的ip地址
                    InetAddress addres = (InetAddress) addresses.nextElement();
                    if (addres != null && addres instanceof Inet4Address) {
                        // if (!"127.0.0.1".equals(addres.getHostAddress())
                        // && (addres.getHostAddress().startsWith("10.") ||
                        // addres
                        // .getHostAddress().startsWith("192."))) {
                        // ip = addres.getHostAddress();
                        // break;
                        // }
                        // start add by yxw 2013-07-08
                        // 修复获取内网地址的bug，国外的ip：10.18.18.
                        if (!addres.isLoopbackAddress()
                                && addres.isSiteLocalAddress()) {
                            ip = addres.getHostAddress();
                            break;
                        }
                        // end add by yxw 2013-07-08
                    }
                }
                if (ip != null && ip.length() > 5) {
                    break;
                }
            }
        } catch (Exception e) {
        }
        return ip;
    }

    /**
     * 获取异常的堆栈信息
     */
    public static String getExceptionStackStr(Throwable e) {
        if (e != null) {
            StringBuilder logStrBuilder = new StringBuilder();
            logStrBuilder.append("message:" + e.getMessage() + " ");
            logStrBuilder.append("stack:");
            // 堆栈信息
            StackTraceElement[] traces = e.getStackTrace();
            // if (traces != null && traces.length > 0) {
            // for (int i = 0; i < traces.length && i < 2; i++) {
            // logStrBuilder.append(traces[i].toString());
            // if (i < traces.length - 1 && i < 1) {
            // logStrBuilder.append(" ");
            // }
            // }
            // }
            for (int i = 0; null != traces && i < traces.length; i++) {
                logStrBuilder.append(traces[i].toString()).append(" ");
            }
            return logStrBuilder.toString();
        } else {
            return "";
        }
    }

    /**
     * 拼接多个字段信息
     *
     * @param separator
     * @param values
     * @return
     */
    public static String splitJointValue(String separator, String... values) {
        StringBuffer resultValue = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                resultValue.append(values[i]);
            }
            if (i < values.length - 1) {
                resultValue.append(separator);
            }
        }
        return resultValue.toString();
    }

    /**
     * 判断是否为数字
     *
     * @param
     * @return
     */
    public static boolean isNumber(String value) {
        if (isNull(value)) {
            return false;
        }
        value = value.replaceFirst("-", "");
        value = value.replaceFirst("\\.", "");
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) value);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static byte[] toByteArray(InputStream in, boolean close)
            throws Exception {
        try {
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (close) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static Integer[] stringToIntArray(String str, String regex) {
        String[] s = str.split(regex);
        Integer[] ite = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            ite[i] = Integer.parseInt(s[i]);
        }
        return ite;
    }

    public static String getHmacSha1(String data, String key)
            throws AppException {
        String result = null;
        try {
            byte[] data_byte = data.getBytes("UTF-8");
            byte[] key_byte = key.getBytes("UTF-8");
            SecretKeySpec signingKey = new SecretKeySpec(key_byte, "HmacSHA1");
            Mac mac = null;
            mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data_byte);
            result = Base64.encodeBytes(rawHmac);
        } catch (Exception e) {
            throw new AppException(-1, "HmacSHA1 Error", e);
        }
        return result;
    }

    public static String formatSize(int size) {
        DecimalFormat df = new DecimalFormat("###.#");
        String size_s;
        if (size < 1024) {
            size_s = size + "B";
        } else if (size < (1024 * 1024)) {
            size_s = df.format((float) size / 1024) + "KB";
        } else {
            size_s = df.format((float) size / (1024 * 1024)) + "MB";
        }
        return size_s;
    }

    /**
     * 通过对比version判断是否有新版本
     *
     * @param oldVersion
     * @param newVersion
     * @return
     */
    public static boolean hasNewVersion(String oldVersion, String newVersion) {
        if (greaterVersion(newVersion, oldVersion) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过对比version是否大于versioncompare;
     *
     * 返回值>0则表示version>versioncompare;
     *
     * 返回值=0则表示version=versioncompare;
     *
     * 返回值<0则表示version<versioncompare,
     *
     * @param version
     * @param versioncompare
     * @return
     */
    public static int greaterVersion(String version, String versioncompare) {
        if (CommonUtil.isNull(version) || CommonUtil.isNull(versioncompare)) {
            return -1;
        }
        version = version.trim();
        versioncompare = versioncompare.trim();
        if ((version.length() <= 0) || (versioncompare.length() <= 0)) {
            return -1;
        }
        if (version.equals(versioncompare)) {
            return 0;
        }
        try {
            String[] versionArray = version.split("\\D");
            String[] versioncompareArray = versioncompare.split("\\D");
            if ((versionArray.length <= 0) || (versioncompareArray.length <= 0)) {
                return -1;
            }

            for (int i = 0; (i < versionArray.length)
                    && (i < versioncompareArray.length); i++) {
                // int versionnum = Integer.parseInt(versionArray[i]);
                // int versioncomparenum =
                // Integer.parseInt(versioncompareArray[i]);
                // if (versionnum > versioncomparenum) {
                // return 1;
                // }
                // if (versionnum < versioncomparenum) {
                // return -1;
                // }
                if (versionArray[i].compareTo(versioncompareArray[i]) > 0) {
                    return 1;
                }
                if (versionArray[i].compareTo(versioncompareArray[i]) < 0) {
                    return -1;
                }
            }

            if (versionArray.length > versioncompareArray.length) {
                return 1;
            } else if (versionArray.length < versioncompareArray.length) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getRandomValue(int value) {
        if (value < 1) {
            value = 1;
        }
        Random rnd = new Random();
        return rnd.nextInt(value);
    }

    public static byte[] gzip(byte[] bs) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(1024 * 4);
        GZIPOutputStream gzout = null;
        try {
            gzout = new GZIPOutputStream(bout);
            gzout.write(bs);
            gzout.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            gzout.close();
            bout.close();
        }
        return bout.toByteArray();

    }

    public static byte[] ungzip(byte[] bs) throws Exception {
        GZIPInputStream gzin = null;
        ByteArrayInputStream bin = null;
        try {
            bin = new ByteArrayInputStream(bs);
            gzin = new GZIPInputStream(bin);
            return IOUtils.toByteArray(gzin);
        } catch (Exception e) {
            throw e;
        } finally {
            gzin.close();
            bin.close();
        }
    }

    public static byte[] inflate(byte[] bs, boolean nowrap) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(1024 * 4);
        try {
            Inflater decompressor = new Inflater(nowrap);
            decompressor.setInput(bs);

            byte[] buf = new byte[1024];
            while (!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                bout.write(buf, 0, count);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            bout.close();
        }
        return bout.toByteArray();
    }

    public static byte[] deflate(byte[] bs, boolean nowrap) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(1024 * 4);
        try {
            Deflater df = new Deflater(5, nowrap);
            // df.setLevel(Deflater.BEST_COMPRESSION);
            df.setInput(bs);
            df.finish();
            byte[] buff = new byte[1024];
            while (!df.finished()) {
                int count = df.deflate(buff);
                bout.write(buff, 0, count);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            bout.close();
        }
        return bout.toByteArray();
    }

    /**
     * @Title: zipObject
     * @Description: 对象压缩处理
     * @param @param object_
     * @param @return
     * @param @throws IOException 设定文件
     * @return byte[] 返回类型
     * @throws
     */
    public static byte[] compressObject(Object object) throws IOException {
        byte[] data_ = null;
        // 建立字节数组输出流
        ByteArrayOutputStream o = new ByteArrayOutputStream();
        // 建立gzip压缩输出流
        GZIPOutputStream gzout = new GZIPOutputStream(o);
        // 建立对象序列化输出流
        ObjectOutputStream out = new ObjectOutputStream(gzout);
        out.writeObject(object);
        out.flush();
        out.close();
        gzout.close();
        // 返回压缩字节流
        data_ = o.toByteArray();
        o.close();
        return data_;
    }

    /**
     * @Title: unZipObject
     * @Description: 对象解压处理
     * @param @param data_
     * @param @return
     * @param @throws IOException
     * @param @throws ClassNotFoundException 设定文件
     * @return Object 返回类型
     * @throws
     */
    public static Object unCompressObject(byte[] data)
            throws IOException, ClassNotFoundException {
        Object object_ = null;
        // 建立字节数组输入流
        ByteArrayInputStream i = new ByteArrayInputStream(data);
        // 建立gzip解压输入流
        GZIPInputStream gzin = new GZIPInputStream(i);
        // 建立对象序列化输入流
        ObjectInputStream in = new ObjectInputStream(gzin);
        // 按制定类型还原对象
        object_ = in.readObject();
        i.close();
        gzin.close();
        in.close();
        return object_;
    }

}
