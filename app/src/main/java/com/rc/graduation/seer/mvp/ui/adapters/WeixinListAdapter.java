package com.rc.graduation.seer.mvp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rc.graduation.seer.MyApplication;
import com.rc.graduation.seer.R;
import com.rc.graduation.seer.mvp.model.entity.weixin.WeixinList;
import com.rc.graduation.seer.mvp.ui.adapters.base.BaseRecyclerViewAdapter;
import com.rc.graduation.seer.mvp.ui.fragments.WeixinFragment;
import com.rc.graduation.seer.utils.DimenUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新闻列表适配器
 * Created by rosen on 2016/10/19 0019.
 */
public class WeixinListAdapter extends BaseRecyclerViewAdapter<WeixinList.ResultBean.ListBean> {

//    private List<WeixinList.ResultBean.ListBean> lists = null;
    private float photoThreeHeight;
    private float photoTwoHeight;
    private float photoOneHeight;
    static Context context;

    public WeixinListAdapter(List<WeixinList.ResultBean.ListBean> list ,Context context){
        super(list);
        this.context = context;
        photoThreeHeight = DimenUtil.dp2px(90);
        photoTwoHeight =  DimenUtil.dp2px(120);
        photoOneHeight =  DimenUtil.dp2px(150);
    }

    @Override
    public int getItemViewType(int position) {
        if(mIsShowFooter && isFooterPosition(position)){
            return TYPE_FOOTER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_FOOTER:
                return new FooterViewHolder(getView(parent,R.layout.adapter_footer_item));
            case TYPE_ITEM:
            default:
                NormalViewHolder normalViewHolder = new NormalViewHolder(getView(parent,R.layout.adapter_news_1_img_item));
                setItemOnClickEvent(normalViewHolder);
                return normalViewHolder;
        }
    }

    private void setItemOnClickEvent(final RecyclerView.ViewHolder holder){
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    mList.get(holder.getAdapterPosition());
                    System.out.println("我是"+holder.getAdapterPosition());
                    mOnItemClickListener.OnItemClickListener(v,holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder,position);
        int viewType = getItemViewType(position);
        if(viewType == TYPE_ITEM){
            updateNormalViews((NormalViewHolder)holder,position);
        }
    }

    /**
     * 加载普通条目
     */
    private void updateNormalViews(NormalViewHolder holder,int position){
        WeixinList.ResultBean.ListBean data = mList.get(position);
        String imgPath = data.getFirstImg();
        Glide.with(MyApplication.getInstance())
                .load(imgPath)
                .placeholder(R.color.image_place_holder)
                .error(R.mipmap.ic_load_fail)
                .into(holder.newsImgIv);

        holder.newsTitleTv.setText(data.getTitle());
        holder.newsSourceTv.setText(data.getSource());
    }



    private void loadImage(ImageView view,String path){
        view.setVisibility(View.VISIBLE);
        Glide.with(MyApplication.getInstance())
                .load(path)
                .placeholder(R.color.image_place_holder)
                .error(R.mipmap.ic_load_fail)
                .into(view);
    }

    public void setOnItemClickListener(WeixinFragment weixinFragment) {

    }

    static class NormalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.news_picture_iv)
        ImageView newsImgIv;

        @BindView(R.id.news_title_tv)
        TextView newsTitleTv;



        @BindView(R.id.news_source_tv)
        TextView newsSourceTv;

        NormalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            itemView.setOnClickListener(this);
//            itemView.setOnClickListener(this);
        }


    }
}
