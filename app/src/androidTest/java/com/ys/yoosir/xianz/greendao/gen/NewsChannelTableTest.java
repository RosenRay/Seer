package com.ys.yoosir.xianz.greendao.gen;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;
import com.ys.yoosir.xianz.greendao.gen.NewsChannelTableDao;

public class NewsChannelTableTest extends AbstractDaoTestLongPk<NewsChannelTableDao, NewsChannelTable> {

    public NewsChannelTableTest() {
        super(NewsChannelTableDao.class);
    }

    @Override
    protected NewsChannelTable createEntity(Long key) {
        NewsChannelTable entity = new NewsChannelTable();
        entity.set_id(key);
        entity.setNewsChannelName();
        entity.setNewsChannelId();
        entity.setNewsChannelType();
        entity.setNewsChannelSelect();
        entity.setNewsChannelIndex();
        entity.setNewsChannelFixed();
        return entity;
    }

}
