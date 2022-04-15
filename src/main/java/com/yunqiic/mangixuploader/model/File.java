package com.yunqiic.mangixuploader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * File表存储上传的文件信息
 */
@Data
@AllArgsConstructor
@ToString
public class File implements Serializable {

    private static final long serialVersionUID = -6956947981866795431L;

    private Long fileId;
    private String appId;
    private String appFileId;
    private String fileName;
    private String md5;
    private String path;
    private Integer uploadTime;

    public File() {
    }

    public File(String appId, String appFileId, String fileName, String md5, String path, Date uploadTime) {
        this.appId = appId;
        this.appFileId = appFileId;
        this.fileName = fileName;
        this.md5 = md5;
        this.path = path;
        this.uploadTime = File.getSecondTimestamp(uploadTime);
    }

    public File(String appId, String appFileId, String fileName, String md5, String path, Integer uploadTime) {
        this.appId = appId;
        this.appFileId = appFileId;
        this.fileName = fileName;
        this.md5 = md5;
        this.path = path;
        this.uploadTime = uploadTime;
    }

    /**
     * 获取精确到秒的时间戳
     *
     * @return int
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }
}
