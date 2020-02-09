package cn.ChaosWong.flash.bean.constant.factory;

import cn.ChaosWong.flash.bean.constant.state.Order;
import cn.ChaosWong.flash.utils.HttpUtil;
import cn.ChaosWong.flash.utils.StringUtil;
import cn.ChaosWong.flash.utils.factory.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;


public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpUtil.getRequest();

        int limit = Integer.valueOf(request.getParameter("limit"));
        String pageNum = request.getParameter("page");

        int offset = 0;
        if (StringUtils.isNotEmpty(pageNum)) {
            offset = (Integer.valueOf(pageNum) - 1) * limit;
        } else {

            offset = Integer.valueOf(request.getParameter("offset"));
        }

        String sortName = request.getParameter("sort");

        String order = request.getParameter("order");
        if (StringUtil.isEmpty(sortName)) {
            Page<T> page = new Page<>((offset / limit + 1), limit);
            return page;
        } else {
            Page<T> page = new Page<>((offset / limit + 1), limit, sortName);
            if (Order.ASC.getDes().equals(order)) {
                Sort sort = Sort.by(Sort.Direction.ASC, order);
                page.setSort(sort);
            } else {
                Sort sort = Sort.by(Sort.Direction.DESC, order);
                page.setSort(sort);

            }
            return page;
        }
    }
}
