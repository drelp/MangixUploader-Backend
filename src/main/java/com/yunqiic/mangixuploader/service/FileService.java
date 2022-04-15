package com.yunqiic.mangixuploader.service;

import com.yunqiic.mangixuploader.config.UploadConfig;
import com.yunqiic.mangixuploader.dao.FileDao;
import com.yunqiic.mangixuploader.model.File;
import com.yunqiic.mangixuploader.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.yunqiic.mangixuploader.utils.FileUtils.generateFileName;
import static com.yunqiic.mangixuploader.utils.UploadUtils.*;

/**
 * 文件上传服务
 */
@Service
public class FileService {
    @Autowired
    private FileDao fileDao;


    /**
     * 上传文件
     * @param md5
     * @param file
     */
    public void upload(String appId, String appFileId, String fileName,
                       String md5,
                       MultipartFile file) throws IOException {
        String path = UploadConfig.path + generateFileName();
        FileUtils.write(path, file.getInputStream());
        fileDao.save(new File(appId, appFileId, fileName, md5, path, new Date()));
    }

    /**
     * 分块上传文件
     * @param md5
     * @param size
     * @param chunks
     * @param chunk
     * @param file
     * @throws IOException
     */
    public void uploadWithBlock(String appId, String appFileId, String fileName,
                                String md5,
                                Long size,
                                Integer chunks,
                                Integer chunk,
                                MultipartFile file) throws IOException {
        String blockFileName = getFileName(md5, chunks);
        FileUtils.writeWithBlok(UploadConfig.path + blockFileName, size, file.getInputStream(), file.getSize(), chunks, chunk);
        addChunk(md5,chunk);
        if (isUploaded(md5)) {
            removeKey(md5);
            fileDao.save(new File(appId, appFileId, fileName, md5,UploadConfig.path + blockFileName, new Date()));
        }
    }

    /**
     * 检查Md5判断文件是否已上传
     * @param md5
     * @return
     */
    public boolean checkMd5(String md5) {
        File file = new File();
        file.setMd5(md5);
        return fileDao.getByFile(file) == null;
    }
}
