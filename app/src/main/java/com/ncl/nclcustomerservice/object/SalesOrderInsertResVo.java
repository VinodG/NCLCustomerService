package com.ncl.nclcustomerservice.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by SupraSoft on 1/28/2019.
 */

public class SalesOrderInsertResVo implements Serializable
{

    @SerializedName("sales_order_id")
    @Expose
    public Integer salesOrderId;
    private final static long serialVersionUID = -2592152266746396532L;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("salesOrderId", salesOrderId).toString();
    }
}
