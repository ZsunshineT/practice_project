package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 * Created by zhangteng on 2020/10/27.
 */
public class FileTool {
    /**
     * 写入文件流
     * @param sql
     * @param file
     */
    public static void writeToFile(String sql, File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(sql.getBytes());// 往文件里写入字符串
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
