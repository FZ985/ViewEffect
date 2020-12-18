package com.example.vplinkage.listener;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.vplinkage.adapter.BasePagerAdapter;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 16:25
 */
public class LinkPageChangeListener implements ViewPager.OnPageChangeListener {
    private ViewPager linkViewPager;
    private ViewPager selfViewPager;

    private int pos;

    public LinkPageChangeListener(ViewPager selfViewPager, ViewPager linkViewPager) {
        this.linkViewPager = linkViewPager;
        this.selfViewPager = selfViewPager;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int marginX = ((selfViewPager.getWidth() + selfViewPager.getPageMargin()) * position
                + positionOffsetPixels) * (linkViewPager.getWidth() + linkViewPager.getPageMargin()) / (
                selfViewPager.getWidth()
                        + selfViewPager.getPageMargin());

        if (linkViewPager.getScrollX() != marginX) {
            linkViewPager.scrollTo(marginX, 0);
        }

        if (linkViewPager.getAdapter() != null && linkViewPager.getAdapter() instanceof BasePagerAdapter) {
            float factor = Math.min(positionOffset, 1f);
            BasePagerAdapter basePagerAdapter = (BasePagerAdapter) linkViewPager.getAdapter();
            View current = basePagerAdapter.getItemView(position);
            View beforeView = null;
            if (this.pos - 1 >= 0 && this.pos - 1 < basePagerAdapter.getCount()) {
                beforeView = basePagerAdapter.getItemView(Math.max(this.pos - 1, 0));
            }
            View afterView = null;
            if (position + 1 < basePagerAdapter.getCount()) {
                afterView = basePagerAdapter.getItemView(position + 1);
            }

            if (current != null) {
                float currentAlpha = current.getAlpha();
                if (currentAlpha >= 1F) {
                    //当前缩小
                    current.setScaleX(Math.max(0.75f, 1F - factor));
                    current.setScaleY(Math.max(0.75f, 1F - factor));
                } else {
                    //当前放大
                    current.setScaleX(Math.max(0.75f, factor));
                    current.setScaleY(Math.max(0.75f, factor));
                }
            }
            if (beforeView != null) {
                if (factor == 0.0F) {
                    beforeView.setScaleX(0.75f);
                    beforeView.setScaleY(0.75f);
                } else {
//                    beforeView.setScaleX(Math.max(0.75f, f));
//                    beforeView.setScaleY(Math.max(0.75f, f));
                }
            }
            if (afterView != null) {
                if (factor == 0.0F) {
                    afterView.setScaleX(0.75f);
                    afterView.setScaleY(0.75f);
                } else {
                    float f = 0.75f + (factor) * (1.0f - 0.75f);
                    afterView.setScaleX(f);
                    afterView.setScaleY(f);
                }
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        this.pos = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            linkViewPager.setCurrentItem(pos);
        }
    }

    private void log(String m) {
        Log.e("LinkPage", m);
    }
}