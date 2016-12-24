package com.test.dao.impl;

import com.test.dao.ImageDao;
import com.test.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl extends BaseDaoImpl<Image, Long> implements ImageDao {
    @Override
    public Image findById(Long id) {
        Image image = getCurrentSession().get(Image.class, id);
        return image;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Image> findAll() {
        List<Image> images = (List<Image>) getCurrentSession().createQuery("from Image").list();
        return images;
    }
}
