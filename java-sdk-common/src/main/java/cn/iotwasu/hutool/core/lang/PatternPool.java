package cn.iotwasu.hutool.core.lang;

import cn.iotwasu.hutool.core.util.ReUtil;
import java.util.regex.Pattern;

/**
 * 常用正则表达式集合
 *
 * @author Looly
 */
public class PatternPool {

  /** 英文字母 、数字和下划线 */
  public static final Pattern GENERAL = Pattern.compile("^\\w+$");
  /** 数字 */
  public static final Pattern NUMBERS = Pattern.compile("\\d+");
  /** 字母 */
  public static final Pattern WORD = Pattern.compile("[a-zA-Z]+");
  /** 单个中文汉字 */
  public static final Pattern CHINESE = Pattern.compile(ReUtil.RE_CHINESE);
  /** 中文汉字 */
  public static final Pattern CHINESES = Pattern.compile(ReUtil.RE_CHINESES);
  /** 分组 */
  public static final Pattern GROUP_VAR = Pattern.compile("\\$(\\d+)");
  /** IP v4 */
  public static final Pattern IPV4 =
      Pattern.compile(
          "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
  /** IP v6 */
  public static final Pattern IPV6 =
      Pattern.compile(
          "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))");
  /** 货币 */
  public static final Pattern MONEY = Pattern.compile("^(\\d+(?:\\.\\d+)?)$");
  /** 邮件，符合RFC 5322规范，正则来自：http://emailregex.com/ */
  // public final static Pattern EMAIL = Pattern.compile("(\\w|.)+@\\w+(\\.\\w+){1,2}");
  public static final Pattern EMAIL =
      Pattern.compile(
          "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
          Pattern.CASE_INSENSITIVE);
  /** 移动电话 */
  public static final Pattern MOBILE = Pattern.compile("(?:0|86|\\+86)?1[3456789]\\d{9}");
  /** 18位身份证号码 */
  public static final Pattern CITIZEN_ID =
      Pattern.compile(
          "[1-9]\\d{5}[1-2]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}(\\d|X|x)");
  /** 邮编 */
  public static final Pattern ZIP_CODE = Pattern.compile("[1-9]\\d{5}(?!\\d)");
  /** 生日 */
  public static final Pattern BIRTHDAY =
      Pattern.compile("^(\\d{2,4})([/\\-\\.年]?)(\\d{1,2})([/\\-\\.月]?)(\\d{1,2})日?$");
  /** URL */
  public static final Pattern URL = Pattern.compile("[a-zA-z]+://[^\\s]*");
  /** Http URL */
  public static final Pattern URL_HTTP =
      Pattern.compile("(https://|http://)?([\\w-]+\\.)+[\\w-]+(:\\d+)*(/[\\w- ./?%&=]*)?");
  /** 中文字、英文字母、数字和下划线 */
  public static final Pattern GENERAL_WITH_CHINESE = Pattern.compile("^[\u4E00-\u9FFF\\w]+$");
  /** UUID */
  public static final Pattern UUID =
      Pattern.compile("^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}$");
  /** 不带横线的UUID */
  public static final Pattern UUID_SIMPLE = Pattern.compile("^[0-9a-z]{32}$");
  /** 中国车牌号码 */
  public static final Pattern PLATE_NUMBER =
      Pattern.compile(
          "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$");
  /** MAC地址正则 */
  public static final Pattern MAC_ADDRESS =
      Pattern.compile(
          "((?:[A-F0-9]{1,2}[:-]){5}[A-F0-9]{1,2})|(?:0x)(\\d{12})(?:.+ETHER)",
          Pattern.CASE_INSENSITIVE);
  /** 16进制字符串 */
  public static final Pattern HEX = Pattern.compile("^[a-f0-9]+$", Pattern.CASE_INSENSITIVE);
  /** 时间正则 */
  public static final Pattern TIME = Pattern.compile("\\d{1,2}:\\d{1,2}(:\\d{1,2})?");

  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
  /** Pattern池 */
  private static final SimpleCache<RegexWithFlag, Pattern> POOL = new SimpleCache<>();

  /**
   * 先从Pattern池中查找正则对应的{@link Pattern}，找不到则编译正则表达式并入池。
   *
   * @param regex 正则表达式
   * @return {@link Pattern}
   */
  public static Pattern get(String regex) {
    return get(regex, 0);
  }

  /**
   * 先从Pattern池中查找正则对应的{@link Pattern}，找不到则编译正则表达式并入池。
   *
   * @param regex 正则表达式
   * @param flags 正则标识位集合 {@link Pattern}
   * @return {@link Pattern}
   */
  public static Pattern get(String regex, int flags) {
    final RegexWithFlag regexWithFlag = new RegexWithFlag(regex, flags);

    Pattern pattern = POOL.get(regexWithFlag);
    if (null == pattern) {
      pattern = Pattern.compile(regex, flags);
      POOL.put(regexWithFlag, pattern);
    }
    return pattern;
  }

  /**
   * 移除缓存
   *
   * @param regex 正则
   * @param flags 标识
   * @return 移除的{@link Pattern}，可能为{@code null}
   */
  public static Pattern remove(String regex, int flags) {
    return POOL.remove(new RegexWithFlag(regex, flags));
  }

  /** 清空缓存池 */
  public static void clear() {
    POOL.clear();
  }

  // ---------------------------------------------------------------------------------------------------------------------------------
  /**
   * 正则表达式和正则标识位的包装
   *
   * @author Looly
   */
  private static class RegexWithFlag {
    private String regex;
    private int flag;

    /**
     * 构造
     *
     * @param regex 正则
     * @param flag 标识
     */
    public RegexWithFlag(String regex, int flag) {
      this.regex = regex;
      this.flag = flag;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + flag;
      result = prime * result + ((regex == null) ? 0 : regex.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      RegexWithFlag other = (RegexWithFlag) obj;
      if (flag != other.flag) {
        return false;
      }
      if (regex == null) {
        if (other.regex != null) {
          return false;
        }
      } else if (!regex.equals(other.regex)) {
        return false;
      }
      return true;
    }
  }
}
