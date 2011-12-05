package com.tw.utilities;

import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String getJSONResponse(Resources context, int resourceName) {
        StringBuilder builder = new StringBuilder();
        try {
            InputStream content = context.openRawResource(resourceName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            Log.e("Error: ",e.getMessage());
        }
        return builder.toString();
    }

}
