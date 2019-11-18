package org.framework.edo.office;

/**
 *
 *
 *
 * @Author L.Qiang
 * @Email: exiuqa@gmail.com
 * @Create 2019-11-04 14:22
 * @Version 1.0
 */

public class FileUtils {

    public static String getPath() {
        return FileUtils.class.getResource("/").getPath();
    }
}
