package com.bodekjan.soundmeter;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by bodekjan on 2016/8/8.
 */
public class FileUtil {
    private static final String TAG = "FileUtil";

    private FileUtil() {
    }

    /**
     * To determine whether there is storage space *
     *
     * @return
     */
    public static boolean isExitSDCard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    private static boolean hasFile(Context context, String fileName) {
        File f = createFile(context, fileName);
        return null != f && f.exists();
    }

    public static File createFile(Context context, String fileName) {
        File myCaptureFile = new File(context.getFilesDir(), fileName);
        if (myCaptureFile.exists()) {
            myCaptureFile.delete();
        }
        try {
            myCaptureFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myCaptureFile;
    }
}
